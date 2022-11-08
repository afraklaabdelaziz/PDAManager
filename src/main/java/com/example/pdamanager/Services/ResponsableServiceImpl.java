package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.InterfaceDao;
import com.example.pdamanager.Dao.ResponsableDaoImpl;
import com.example.pdamanager.Entities.Responsable;

import java.util.List;

public class ResponsableServiceImpl implements InterfaceService<Responsable> {
    InterfaceDao responsableDao = new ResponsableDaoImpl();
    @Override
    public void Add(Responsable responsable) {

    }

    @Override
    public void update(Responsable responsable) {

    }

    @Override
    public List<Responsable> getAll() {
        return responsableDao.getAll();
    }

    @Override
    public Responsable findByID(long id) {
        return (Responsable) responsableDao.findById(id);
    }
}
