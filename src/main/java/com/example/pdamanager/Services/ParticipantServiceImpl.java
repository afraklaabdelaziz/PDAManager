package com.example.pdamanager.Services;

import com.example.pdamanager.Entities.Genre;
import com.example.pdamanager.Entities.Participant;
import com.example.pdamanager.Repositories.ParticipantRepositoryImpl;
import jakarta.servlet.http.Part;

import java.util.List;

public class ParticipantServiceImpl  {
    ParticipantRepositoryImpl participantRepository = new ParticipantRepositoryImpl();
    public List<Participant> findParticipantByActivite(Long idActivite){
        return participantRepository.findParticipantById(idActivite);
    }
    public List<Participant> findParticipantByGenre(Long idActivite ,Genre genre){
        return  participantRepository.findParticipantByGenre(idActivite,genre);
    }

    public Participant findParticiByIdActivete(Long idActivite){
        return participantRepository.findParticipantByIDActivete(idActivite);
    }

    public List<Participant> findAllParticipant() {
        return participantRepository.findAllParticipant();
    }

    public  List<Participant> findParticipantByGenre(Genre genre){
        return (List<Participant>) participantRepository.findParticipantByGenre(genre);

    }
}
