package com.resourciumoptima.resourcium_optima.repositories.impl;

import com.resourciumoptima.resourcium_optima.models.entities.User;
import com.resourciumoptima.resourcium_optima.repositories.UserRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;
import java.util.stream.Collectors;

public class UserRepoImpl implements UserRepo {
    EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = managerFactory.createEntityManager();


    @Override
    public void save(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void singIn(String email ,String psw) {
        try {
            TypedQuery<User> query = entityManager.createQuery(
                    "SELECT u FROM User u where u.email like :email ",
                    User.class
            );
            query.setParameter("email", email);
            List<User> users = query.getResultList();
            List<User> userFound = users.stream()
                    .filter(user -> verifyPassword(psw,user.getPassword())==true)
                    .collect(Collectors.toList());
            System.out.println(userFound);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean verifyPassword(String inputPassword, String hashedPassword) {
        return BCrypt.checkpw(inputPassword, hashedPassword);
    }
}
