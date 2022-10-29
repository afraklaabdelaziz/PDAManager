package com.example.pdamanager.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pays")
    private List<Ville> villes = new ArrayList<>();

    public Pays() {
    }

    public Pays(long id, String nom, List<Ville> villes) {
        this.id = id;
        this.nom = nom;
        this.villes = villes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Ville> getVilles() {
        return villes;
    }

    public void setVilles(List<Ville> villes) {
        this.villes = villes;
    }
}
