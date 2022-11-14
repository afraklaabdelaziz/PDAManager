package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.DemandeDaoImpl;
import com.example.pdamanager.Dao.InterfaceDao;
import com.example.pdamanager.Entities.Demande;

import java.util.List;

public class DemandeServiceImpl implements InterfaceService<Demande>{
    InterfaceDao demandeDao = new DemandeDaoImpl();
    @Override
    public void Add(Demande demande) {
        demandeDao.add(demande);
    }

    @Override
    public void update(Demande demande) {
      demandeDao.update(demande);
    }

    @Override
    public List<Demande> getAll() {
        return null;
    }

    @Override
    public Demande findByID(long id) {
        return (Demande) demandeDao.findById(id);
    }
}
