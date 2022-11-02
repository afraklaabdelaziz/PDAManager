package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.ActiveteDaoImpl;
import com.example.pdamanager.Dao.InterfaceDao;
import com.example.pdamanager.Entities.Activité;

import java.util.List;

public class ActiveteServiceImpl implements InterfaceService<Activité>{
    InterfaceDao activeteDao = new ActiveteDaoImpl();
    @Override
    public void Add(Activité activité) {
        activeteDao.add(activité);
    }

    @Override
    public void update(Activité activité) {

    }

    @Override
    public List<Activité> getAll() {
        return activeteDao.getAll();
    }

}
