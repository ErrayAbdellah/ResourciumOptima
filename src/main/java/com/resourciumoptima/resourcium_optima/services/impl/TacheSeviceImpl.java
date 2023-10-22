package com.resourciumoptima.resourcium_optima.services.impl;

import com.resourciumoptima.resourcium_optima.models.entities.Tache;
import com.resourciumoptima.resourcium_optima.repositories.TacheRepo;
import com.resourciumoptima.resourcium_optima.repositories.impl.TacheRepoImpl;
import com.resourciumoptima.resourcium_optima.services.ITacheService;

import java.util.List;

public class TacheSeviceImpl implements ITacheService {

    private final TacheRepo tacheRepo;

    public TacheSeviceImpl(){
        tacheRepo = new TacheRepoImpl();
    }

    @Override
    public void save(Tache tache) {
        tacheRepo.save(tache);
    }

    @Override
    public List<Tache> findAll() {
       return tacheRepo.finAll();
    }
}
