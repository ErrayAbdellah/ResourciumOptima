package com.resourciumoptima.resourcium_optima.repositories;

import com.resourciumoptima.resourcium_optima.models.entities.Equipement;
import com.resourciumoptima.resourcium_optima.models.entities.Tache;

import java.util.List;

public interface EquipementRepo {

    boolean save(Equipement equipement);
    List<Equipement> finAll();
    Equipement findById(int id);
    boolean update(Equipement equipement);
    boolean delete(int id_delete);
}
