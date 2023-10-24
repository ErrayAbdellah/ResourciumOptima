package com.resourciumoptima.resourcium_optima.repositories;

import com.resourciumoptima.resourcium_optima.models.entities.Tache;
import com.resourciumoptima.resourcium_optima.models.entities.User;

import java.util.List;

public interface TacheRepo {
    boolean save(Tache tache);

    List<Tache> finAll();

    Tache findById(int id);

    boolean update(Tache tache);

    boolean delete(int id_delete);
}
