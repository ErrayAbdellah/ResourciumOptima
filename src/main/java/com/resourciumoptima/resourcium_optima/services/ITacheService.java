package com.resourciumoptima.resourcium_optima.services;

import com.resourciumoptima.resourcium_optima.models.entities.Tache;

import java.util.List;

public interface ITacheService {

    void save(Tache tache);

    List<Tache> findAll();

    Tache findById(int id);

    void update(Tache tache);

    void delete(int id_delete);
}
