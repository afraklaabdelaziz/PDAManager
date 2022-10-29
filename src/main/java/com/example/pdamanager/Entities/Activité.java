package com.example.pdamanager.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Activité implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Description;
    private Date Date_debut;
    private Date date_fin;
    private Date date_de_participation;
    private Date date_fin_participation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ResponsableId",referencedColumnName = "id")
    private Responsable responsable;

    public  Activité(){}

    public Activité(Long id, String description, Date date_debut, Date date_fin, Date date_de_participation, Date date_fin_participation, List<Exercice> exerciceList, Responsable responsable) {
        this.id = id;
        Description = description;
        Date_debut = date_debut;
        this.date_fin = date_fin;
        this.date_de_participation = date_de_participation;
        this.date_fin_participation = date_fin_participation;
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

    public Date getDate_debut() {
        return Date_debut;
    }

    public void setDate_debut(Date date_debut) {
        Date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Date getDate_de_participation() {
        return date_de_participation;
    }

    public void setDate_de_participation(Date date_de_participation) {
        this.date_de_participation = date_de_participation;
    }

    public Date getDate_fin_participation() {
        return date_fin_participation;
    }

    public void setDate_fin_participation(Date date_fin_participation) {
        this.date_fin_participation = date_fin_participation;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

}
