package com.example.pdamanager.Entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Participant extends User implements Serializable {
    private String Domaine;
    private String Structure;
    @Enumerated(EnumType.STRING)
    private  Genre genre;
    @OneToMany(mappedBy = "participant")
    private List<Participation> participationList= new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "participant")
    private List<Demande> villes = new ArrayList<>();

     public  Participant(){}

    public Participant(long id, String nom, String prenom, String email, String phone, String password, Adresse adresse, List<Role> roles, String domaine, String structure, Genre genre, List<Participation> participationList) {
        super(id, nom, prenom, email, phone, password, adresse);
        Domaine = domaine;
        Structure = structure;
        this.genre = genre;
        this.participationList = participationList;
    }

    public String getDomaine() {
        return Domaine;
    }

    public void setDomaine(String domaine) {
        Domaine = domaine;
    }

    public String getStructure() {
        return Structure;
    }

    public void setStructure(String structure) {
        Structure = structure;
    }

    public List<Participation> getParticipationList() {
        return participationList;
    }

    public void setParticipationList(List<Participation> participationList) {
        this.participationList = participationList;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
