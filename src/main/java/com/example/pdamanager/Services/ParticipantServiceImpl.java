package com.example.pdamanager.Services;

import com.example.pdamanager.Entities.Participant;
import com.example.pdamanager.Repositories.ParticipantRepositoryImpl;
import jakarta.servlet.http.Part;

import java.util.List;

public class ParticipantServiceImpl  {
    ParticipantRepositoryImpl participantRepository = new ParticipantRepositoryImpl();
    public List<Participant> findParticipantByActivite(Long idActivite){
        return participantRepository.findParticipantById(idActivite);
    }

    public Participant findParticiByIdActivete(Long idActivite){
        return participantRepository.findParticipantByIDActivete(idActivite);
    }
}
