package com.resourciumoptima.resourcium_optima.repositories.impl;

import com.resourciumoptima.resourcium_optima.models.entities.Tache;
import com.resourciumoptima.resourcium_optima.models.entities.User;
import com.resourciumoptima.resourcium_optima.repositories.TacheRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TacheRepoImpl implements TacheRepo {
    EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = managerFactory.createEntityManager();
    @Override
    public boolean save(Tache tache) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(tache);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Tache> finAll() {
        TypedQuery<Tache> query = entityManager.createQuery("SELECT t FROM Tache t", Tache.class);
        return query.getResultList();
    }

    @Override
    public Tache findById(int id) {
        Tache tache =  new Tache();
        try {
            tache = entityManager.find(Tache.class,id);
            return tache ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Tache tache) {
        try {
            entityManager.getTransaction().begin();
            Tache existingTache = entityManager.find(Tache.class, tache.getId());

            if (existingTache != null) {
                existingTache.setDescription(tache.getDescription());
                existingTache.setStartDate(tache.getStartDate());
                existingTache.setDateLimite(tache.getDateLimite());
                existingTache.setPriorite(tache.getPriorite());
                entityManager.merge(existingTache);
                entityManager.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
