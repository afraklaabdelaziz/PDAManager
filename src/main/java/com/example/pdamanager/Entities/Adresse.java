package com.example.pdamanager.Entities;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codePostal;
    private String adresse;
    @OneToMany(cascade =  CascadeType.ALL,mappedBy = "adresse")
    private List<User> users = new ArrayList<>();

    @ManyToOne
     @JoinColumn(name = "ville_id")
    private Ville ville;

    public Adresse() {
    }

    public Adresse(long id, String codePostal, String adresse, List<User> users, Ville ville) {
        this.id = id;
        this.codePostal = codePostal;
        this.adresse = adresse;
        this.users = users;
        this.ville = ville;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
