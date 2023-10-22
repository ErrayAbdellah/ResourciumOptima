package com.resourciumoptima.resourcium_optima.repositories.impl;

import com.resourciumoptima.resourcium_optima.models.entities.User;
import com.resourciumoptima.resourcium_optima.repositories.UserRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.mindrot.jbcrypt.BCrypt;

public class UserRepoImpl implements UserRepo {
    EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = managerFactory.createEntityManager();


    @Override
    public boolean save(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User singIn(String email ,String psw) {
        try{
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.email = :email", User.class
        );
        query.setParameter("email", email);

            User user = query.getSingleResult();
            System.out.println(user);
            System.out.println(user);
            if (verifyPassword(psw,user.getPassword())==true && user!=null){
                    return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
    }

    @Override
    public boolean update(User user) {
        try {
            entityManager.getTransaction().begin();
            User existingUser = entityManager.find(User.class, user.getId());

            if (existingUser != null) {
                existingUser.setName(user.getName());
                existingUser.setEmail(user.getEmail());
                entityManager.merge(existingUser);
                entityManager.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean verifyPassword(String inputPassword, String hashedPassword) {
        return BCrypt.checkpw(inputPassword, hashedPassword);
    }
}
