package com.example.pdamanager.Entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Participation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private  Statut statut;

    @ManyToOne
    @JoinColumn(name = "ParticipantId")
    private Participant participant;
    @ManyToOne
    @JoinColumn(name = "activite_id")
    private Activité activite;
    public Participation(){}
    public Participation(Long id, Statut statut) {
        this.id = id;
        this.statut = statut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Activité getActivite() {
        return activite;
    }

    public void setActivite(Activité activite) {
        this.activite = activite;
    }
}
