package com.example.pdamanager.Entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Exercice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date Année;
    private  Date Date_debut;
    private  Date Date_fin;
    private  EtatExercice etatExercice;

    @ManyToMany
    private List<Activité> activitéList= new ArrayList<>();
    public Exercice(){}

    public Exercice(Long id, Date année, Date date_debut, Date date_fin, EtatExercice etatExercice, List<Activité> activitéList) {
        this.id = id;
        Année = année;
        Date_debut = date_debut;
        Date_fin = date_fin;
        this.etatExercice = etatExercice;
        this.activitéList = activitéList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAnnée() {
        return Année;
    }

    public void setAnnée(Date année) {
        Année = année;
    }

    public Date getDate_debut() {
        return Date_debut;
    }

    public void setDate_debut(Date date_debut) {
        Date_debut = date_debut;
    }

    public Date getDate_fin() {
        return Date_fin;
    }

    public void setDate_fin(Date date_fin) {
        Date_fin = date_fin;
    }

    public EtatExercice getEtatExercice() {
        return etatExercice;
    }

    public void setEtatExercice(EtatExercice etatExercice) {
        this.etatExercice = etatExercice;
    }

    public List<Activité> getActivitéList() {
        return activitéList;
    }

    public void setActivitéList(List<Activité> activitéList) {
        this.activitéList = activitéList;
    }
}
