package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.InterfaceDao;
import com.example.pdamanager.Dao.PaysDaoImpl;
import com.example.pdamanager.Entities.Pays;

import java.util.List;

public class PaysServiceImpl implements InterfaceService<Pays>{
    InterfaceDao paysDao = new PaysDaoImpl();
    @Override
    public void Add(Pays pays) {
        paysDao.add(pays);
    }

    @Override
    public void update(Pays pays) {
      paysDao.update(pays);
    }

    @Override
    public List<Pays> getAll() {
        return paysDao.getAll();
    }

    @Override
    public Pays findByID(long id) {
        return (Pays) paysDao.findById(id);
    }
}
