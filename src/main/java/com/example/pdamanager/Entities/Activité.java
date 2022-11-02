package com.example.pdamanager.Entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Activité implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Description;
    private LocalDate Date_debut;
    private LocalDate date_fin;
    private LocalDate date_de_participation;
    private LocalDate date_fin_participation;

    @Enumerated(EnumType.STRING)
    private Etat etatActivité;

    @Enumerated(EnumType.STRING)
    private TypeActivité typeActivité;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ResponsableId",referencedColumnName = "id")
    private Responsable responsable;

    public  Activité(){}

    public Activité(Long id, String description, LocalDate date_debut, LocalDate date_fin, LocalDate date_de_participation, LocalDate date_fin_participation, Etat etatActivité, TypeActivité typeActivité, Responsable responsable) {
        this.id = id;
        Description = description;
        Date_debut = date_debut;
        this.date_fin = date_fin;
        this.date_de_participation = date_de_participation;
        this.date_fin_participation = date_fin_participation;
        this.etatActivité = etatActivité;
        this.typeActivité = typeActivité;
        this.responsable = responsable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDate getDate_debut() {
        return Date_debut;
    }

    public void setDate_debut(LocalDate date_debut) {
        Date_debut = date_debut;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    public LocalDate getDate_de_participation() {
        return date_de_participation;
    }

    public void setDate_de_participation(LocalDate date_de_participation) {
        this.date_de_participation = date_de_participation;
    }

    public LocalDate getDate_fin_participation() {
        return date_fin_participation;
    }

    public void setDate_fin_participation(LocalDate date_fin_participation) {
        this.date_fin_participation = date_fin_participation;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }
    public Etat getEtatActivité() {
        return etatActivité;
    }

    public void setEtatActivité(Etat etatActivité) {
        this.etatActivité = etatActivité;
    }

    public TypeActivité getTypeActivité() {
        return typeActivité;
    }

    public void setTypeActivité(TypeActivité typeActivité) {
        this.typeActivité = typeActivité;
    }
}
