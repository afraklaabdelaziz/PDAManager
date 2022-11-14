package com.example.pdamanager.Entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Demande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatutDemande statutDemande;

    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private Responsable responsable;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    private String message;


    public Demande(Long id, StatutDemande statutDemande, Responsable responsable, Participant participant, String message) {
        this.id = id;
        this.statutDemande = statutDemande;
        this.responsable = responsable;
        this.participant = participant;
        this.message = message;
    }

    public Demande() {
    }

    public StatutDemande getStatutDemande() {
        return statutDemande;
    }

    public void setStatutDemande(StatutDemande statutDemande) {
        this.statutDemande = statutDemande;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Demande{" +
                "id=" + id +
                ", statutDemande=" + statutDemande +
                ", responsable=" + responsable +
                ", participant=" + participant +
                ", message='" + message + '\'' +
                '}';
    }
}
