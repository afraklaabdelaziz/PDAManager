package com.example.pdamanager.Services;

import com.example.pdamanager.Dao.AdresseDaoImpl;
import com.example.pdamanager.Dao.UseDaoImpl;
import com.example.pdamanager.Entities.Adresse;

public class AdresseServiceImpl<T> implements InterfaceService <T> {
    AdresseDaoImpl AdresseDao=new AdresseDaoImpl();
    @Override
    public void Add(T t) {


                AdresseDao.add(t);
        }
        public void AddVille(T t){
        AdresseDao.addVille(t);
        }
        public void AddPays(T t){
        AdresseDao.addPays(t);
        }
    }

