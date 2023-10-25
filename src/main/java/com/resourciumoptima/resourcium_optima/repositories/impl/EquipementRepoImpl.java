package com.resourciumoptima.resourcium_optima.repositories.impl;

import com.resourciumoptima.resourcium_optima.models.entities.Equipement;
import com.resourciumoptima.resourcium_optima.repositories.EquipementRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class EquipementRepoImpl implements EquipementRepo {
    EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = managerFactory.createEntityManager();
    @Override
    public boolean save(Equipement equipement) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(equipement);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Equipement> finAll() {
        try {
            TypedQuery<Equipement> query = entityManager.createQuery("SELECT e FROM Equipement e", Equipement.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Equipement findById(int id) {
        Equipement equipement =  new Equipement();
        try {
            equipement = entityManager.find(Equipement.class,id);
            return equipement ;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public boolean update(Equipement equipement) {
        try {
            entityManager.getTransaction().begin();
            Equipement existingEquipement = entityManager.find(Equipement.class, equipement.getId());

            if (existingEquipement != null) {
                existingEquipement.setName(equipement.getName());
                existingEquipement.setType(equipement.getType());
                existingEquipement.setEtat(equipement.getEtat());
                existingEquipement.setDateAchat(equipement.getDateAchat());
                existingEquipement.setDateMaintenance(equipement.getDateMaintenance());
                //existingEquipement.setReservations(equipement.getReservations());
                entityManager.merge(existingEquipement);
                entityManager.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return false;
    }

    @Override
    public boolean delete(int id_delete) {
        try {
            entityManager.getTransaction().begin();
            Equipement equipementToDelete = entityManager.find(Equipement.class, id_delete);

            if (equipementToDelete != null) {
                entityManager.remove(equipementToDelete);
                entityManager.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
        return false;
    }
}
