package com.example.pdamanager.Services;
import com.example.pdamanager.Dao.AdresseDaoImpl;
import com.example.pdamanager.Dao.InterfaceDao;
import com.example.pdamanager.Entities.Pays;
import com.example.pdamanager.Entities.Ville;
import java.util.List;

public class AdresseServiceImpl<T> implements InterfaceService <T> {
    InterfaceDao AdresseDao=new AdresseDaoImpl();
    @Override
    public void Add(T t) {


                AdresseDao.add(t);
        }

    @Override
    public void update(T t) {

    }

    public List<T> getAll() {
        return null;
    }

    @Override
    public T findByID(long id) {
        return null;
    }


    public void Add(Ville ville){
        AdresseDao.add(ville);
        }
        public void Add(Pays pays){
        AdresseDao.add(pays);
        }
    }

