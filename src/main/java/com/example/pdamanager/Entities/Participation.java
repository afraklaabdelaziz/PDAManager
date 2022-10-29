package com.example.pdamanager.Entities;

import jakarta.persistence.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import java.io.Serializable;

@Entity
public class Participation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  Statut statut;

    @ManyToOne
    @JoinColumn(name = "ParticipantId")
    private Participant participant;
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
}
