package com.resourciumoptima.resourcium_optima.services;

import com.resourciumoptima.resourcium_optima.models.entities.Equipement;
import com.resourciumoptima.resourcium_optima.models.entities.Tache;

import java.util.List;

public interface IEquipementService {
    void save(Equipement equipement);

    List<Equipement> findAll();

    Equipement findById(int id);

    void update(Equipement equipement);

    void delete(int id_delete);
}
