package com.example.pdamanager.Entities;

import jakarta.persistence.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Responsable extends User implements Serializable {
    private String Domaine;
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToOne(mappedBy = "responsable")
    private Activité activité;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "responsable")
    private List<Demande> demandes = new ArrayList<>();

    public Responsable(){

    }

    public Responsable(long id, String nom, String prenom, String email, String phone, String password, Adresse adresse, List<Role> roles, String domaine, Type type) {
        super(id, nom, prenom, email, phone, password, adresse);
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

    public Activité getActivité() {
        return activité;
    }

    public void setActivité(Activité activité) {
        this.activité = activité;
    }

    public List<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }
}
