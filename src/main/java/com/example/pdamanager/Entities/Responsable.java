package com.example.pdamanager.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
@Entity
public class Responsable extends User implements Serializable {
    private String Domaine;
    private Type type;
    @OneToOne(mappedBy = "responsable")
    private Activité activité;

    public Responsable(){

    }

    public Responsable(long id, String nom, String prenom, String email, String phone, String password, Adresse adresse, List<Role> roles, String domaine, Type type) {
        super(id, nom, prenom, email, phone, password, adresse, roles);
        Domaine = domaine;
        this.type = type;
    }

    public String getDomaine() {
        return Domaine;
    }

    public void setDomaine(String domaine) {
        Domaine = domaine;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
