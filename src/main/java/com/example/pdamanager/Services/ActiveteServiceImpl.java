package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.ActiveteDaoImpl;
import com.example.pdamanager.Dao.InterfaceDao;
import com.example.pdamanager.Entities.Activité;

import java.util.List;

public class ActiveteServiceImpl implements InterfaceService<Activité>{
    InterfaceDao activeteDao = new ActiveteDaoImpl();
    @Override
    public void Add(Activité activité) {
        System.out.println(3);
        activeteDao.add(activité);
        System.out.println(4);
    }

    @Override
    public void update(Activité activité) {
     activeteDao.update(activité);
    }

    @Override
    public List<Activité> getAll() {
        return activeteDao.getAll();
    }

    @Override
    public Activité findByID(long id) {
        return (Activité) activeteDao.findById(id);
    }

}
