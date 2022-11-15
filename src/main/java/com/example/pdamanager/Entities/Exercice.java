package com.example.pdamanager.Entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Exercice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nom;
    private LocalDate Année;

    private  LocalDate Date_debut;

    private  LocalDate Date_fin;
    @Enumerated(EnumType.STRING)
    private  EtatExercice etatExercice;

    public Exercice(){}

    public Exercice(Long id ) { this.id = id;}

    public Exercice(Long id, LocalDate année, LocalDate date_debut, LocalDate date_fin, EtatExercice etatExercice) {
        this.id = id;
        Année = année;
        Date_debut = date_debut;
        Date_fin = date_fin;
        this.etatExercice = etatExercice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getAnnée() {
        return Année;
    }

    public void setAnnée(LocalDate année) {
        Année = année;
    }

    public LocalDate getDate_debut() {
        return Date_debut;
    }

    public void setDate_debut(LocalDate date_debut) {
        Date_debut = date_debut;
    }

    public LocalDate getDate_fin() {
        return Date_fin;
    }

    public void setDate_fin(LocalDate date_fin) {
        Date_fin = date_fin;
    }

    public EtatExercice getEtatExercice() {
        return etatExercice;
    }

    public void setEtatExercice(EtatExercice etatExercice) {
        this.etatExercice = etatExercice;
    }


    public String getNom() {
        return Nom;
    }
    public void setNom(String nom) {
        Nom = nom;
    }
}
