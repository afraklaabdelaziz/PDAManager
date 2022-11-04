package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.ActiveteDaoImpl;
import com.example.pdamanager.Dao.ExerciceDaoImpl;
import com.example.pdamanager.Dao.InterfaceDao;
import com.example.pdamanager.Entities.Activité;
import com.example.pdamanager.Entities.Exercice;

import java.util.List;

public class ExerciceServiceImpl implements InterfaceService <Exercice>{

    InterfaceDao exerciceDao = new ExerciceDaoImpl();
    @Override
    public void Add(Exercice exercice) {
        exerciceDao.add(exercice);
    }

    @Override
    public void update(Exercice exercice) {

    }

    @Override
    public List<Exercice> getAll() {
        return exerciceDao.getAll();
    }

    @Override
    public Exercice findByID(long id) {
        return null;
    }

}
