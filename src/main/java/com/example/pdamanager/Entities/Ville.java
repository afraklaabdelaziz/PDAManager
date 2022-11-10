package com.example.pdamanager.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @OneToMany (cascade = CascadeType.ALL ,mappedBy = "ville")
    private List<Adresse> adresses = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "pays_id")
    private Pays pays;

    public Ville() {
    }

    public Ville(long id, String nom, List<Adresse> adresses, Pays pays) {
        this.id = id;
        this.nom = nom;
        this.adresses = adresses;
        this.pays = pays;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }
}
