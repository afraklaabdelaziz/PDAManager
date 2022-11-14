package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.InterfaceDao;
import com.example.pdamanager.Dao.ParticipationDaoImpl;
import com.example.pdamanager.Entities.Participation;

import java.util.List;

public class ParticipationServiceImpl implements InterfaceService<Participation>{
    InterfaceDao participationDao = new ParticipationDaoImpl();
    @Override
    public void Add(Participation participation) {
        participationDao.add(participation);
    }

    @Override
    public void update(Participation participation) {

    }

    @Override
    public List<Participation> getAll() {
        return null;
    }

    @Override
    public Participation findByID(long id) {
        return null;
    }
}
