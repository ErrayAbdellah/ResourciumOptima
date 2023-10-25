package com.resourciumoptima.resourcium_optima.services.impl;

import com.resourciumoptima.resourcium_optima.models.entities.Equipement;
import com.resourciumoptima.resourcium_optima.repositories.EquipementRepo;
import com.resourciumoptima.resourcium_optima.repositories.impl.EquipementRepoImpl;
import com.resourciumoptima.resourcium_optima.services.IEquipementService;

import java.util.List;

public class EquipementServiceImpl implements IEquipementService {
    private final EquipementRepo equipementRepo ;

    public EquipementServiceImpl(){
        equipementRepo = new EquipementRepoImpl();
    }
    @Override
    public void save(Equipement equipement) {
        equipementRepo.save(equipement);
    }

    @Override
    public List<Equipement> findAll() {
        List<Equipement> equipements = equipementRepo.finAll();
        System.out.println(equipements);
        return equipements;
    }

    @Override
    public Equipement findById(int id) {
        return null;
    }

    @Override
    public void update(Equipement equipement) {

    }

    @Override
    public void delete(int id_delete) {

    }
}
