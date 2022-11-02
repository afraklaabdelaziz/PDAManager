package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.ActiveteDaoImpl;
import com.example.pdamanager.Entities.Activité;

public class ActiveteServiceImpl implements InterfaceService<Activité>{
    ActiveteDaoImpl activeteDao = new ActiveteDaoImpl();
    @Override
    public void Add(Activité activité) {
        activeteDao.add(activité);
    }

    @Override
    public void update(Activité activité) {

    }
    
}
