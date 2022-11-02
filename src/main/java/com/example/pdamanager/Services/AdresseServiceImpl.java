package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.AdresseDaoImpl;

import java.util.List;

public class AdresseServiceImpl<T> implements InterfaceService <T> {
    AdresseDaoImpl AdresseDao=new AdresseDaoImpl();
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

    public void AddVille(T t){
        AdresseDao.addVille(t);
        }
        public void AddPays(T t){
        AdresseDao.addPays(t);
        }
    }

