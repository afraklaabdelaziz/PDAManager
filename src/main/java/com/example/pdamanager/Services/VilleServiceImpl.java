package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.InterfaceDao;
import com.example.pdamanager.Dao.VilleDaoImpl;
import com.example.pdamanager.Entities.Ville;

import java.util.List;

public class VilleServiceImpl implements InterfaceService<Ville>{
    InterfaceDao villeDao = new VilleDaoImpl();
    @Override
    public void Add(Ville ville) {
        villeDao.add(ville);
    }

    @Override
    public void update(Ville ville) {
   villeDao.update(ville);
    }

    @Override
    public List<Ville> getAll() {
        return villeDao.getAll();
    }

    @Override
    public Ville findByID(long id) {
        return (Ville) villeDao.findById(id);
    }
}
