package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.ActiveteDaoImpl;
import com.example.pdamanager.Dao.ExerciceDaoImpl;
import com.example.pdamanager.Dao.InterfaceDao;
import com.example.pdamanager.Entities.Activité;
import com.example.pdamanager.Entities.Exercice;
import com.example.pdamanager.Repositories.ExerciceRepositoryImpl;

import java.util.List;

public class ExerciceServiceImpl implements InterfaceService <Exercice>{

    InterfaceDao exerciceDao = new ExerciceDaoImpl();
    ExerciceRepositoryImpl exerciceRepository = new ExerciceRepositoryImpl();
    @Override
    public void Add(Exercice exercice) {
        exerciceDao.add(exercice);
    }

    @Override
    public void update(Exercice exercice) {
    exerciceDao.update(exercice);
    }

    @Override
    public List<Exercice> getAll() {
        return exerciceDao.getAll();
    }

    @Override
    public Exercice findByID(long id) {
        return (Exercice) exerciceDao.findById(id);
    }



        public List<Exercice> findExrciceByActivite(Long idActivite) {
            return exerciceRepository.findExrciceByActivite(idActivite);
        }

}
