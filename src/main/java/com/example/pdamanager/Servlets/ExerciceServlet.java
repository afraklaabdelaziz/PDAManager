package com.example.pdamanager.Servlets;

import com.example.pdamanager.Entities.*;
import com.example.pdamanager.Repositories.ActiveteRepositoryImpl;
import com.example.pdamanager.Repositories.DemandeRepoditoryImpl;
import com.example.pdamanager.Repositories.UserRepositoryImpl;
import com.example.pdamanager.Services.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "ExerciceServlet", urlPatterns = {"/Exercice","/addExercice","/updateExercice","/demandes","/listParticipant"})
public class ExerciceServlet extends HttpServlet {
    InterfaceService exerciceService = new ExerciceServiceImpl();
    DemandeRepoditoryImpl demandeRepoditory =  new DemandeRepoditoryImpl();
    UserServiceImpl userService = new UserServiceImpl();
    InterfaceService participationService = new ParticipationServiceImpl();
    InterfaceService demandeService = new DemandeServiceImpl();
    ActiveteRepositoryImpl activeteRepository = new ActiveteRepositoryImpl();
    ParticipantServiceImpl participantService = new ParticipantServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        switch (path) {
            case ("/updateExercice"):
                EtatExercice[] etatExercices = EtatExercice.values();
                request.setAttribute("etatExercices",etatExercices);
                Long id = Long.parseLong(request.getParameter("id"));
                Exercice execice1= (Exercice) exerciceService.findByID(id);
                request.setAttribute("exercice",execice1);
                request.getRequestDispatcher("updateExercice.jsp").forward(request, response);
                break;
            case ("/Exercice"):
                List<Exercice> exercices = exerciceService.getAll();
                Activité activite = activeteRepository.findActiviteByResponsblaID((Long) session.getAttribute("idUser"));
                request.setAttribute("activiteRes",activite);
                request.setAttribute("exercices",exercices);
                request.getRequestDispatcher("/listExercice.jsp").forward(request,response);
                break;
            case ("/demandes"):
                List<Demande> demandes = demandeRepoditory.findDemandeByIdRespo((Long) session.getAttribute("idUser"));
                request.setAttribute("demandesRes",demandes);
                System.out.println(demandes.toString());
                request.getRequestDispatcher("demande.jsp").forward(request,response);
                break;
            case ("/listParticipant"):
               Activité activitee = activeteRepository.findActiviteByResponsblaID((Long) session.getAttribute("idUser"));
                List<Participant> participants = participantService.findParticipantByActivite(activitee.getId());
                request.setAttribute("participants",participants);
                request.getRequestDispatcher("/listParticipant.jsp").forward(request,response);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        switch (path){
            case "/Exercice":
                LocalDate an=LocalDate.parse( request.getParameter("anne"));
                LocalDate debut=LocalDate.parse(request.getParameter("debut"));
                LocalDate fin=LocalDate.parse(request.getParameter("fin"));
                String nom=request.getParameter("nom");
                Exercice exercice=new Exercice();
                //EtatExercice etat= EtatExercice.valueOf(request.getParameter(""));
                exercice.setEtatExercice(EtatExercice.EnCours);
                exercice.setAnnée(an);
                exercice.setDate_debut(debut);
                exercice.setDate_fin(fin);
                exercice.setNom(nom);
                exerciceService.Add(exercice);
                response.sendRedirect("/PDAManager_war_exploded/Exercice");
                break;

            case "/updateExercice":
                LocalDate annee=LocalDate.parse( request.getParameter("annee"));
                LocalDate debutt=LocalDate.parse(request.getParameter("debutt"));
                LocalDate finn=LocalDate.parse(request.getParameter("finn"));
                String nome=request.getParameter("nome");
                String etatex=request.getParameter("etatt");
                Long idExercice = Long.parseLong(request.getParameter("id"));
                Exercice exercice1= (Exercice) exerciceService.findByID(idExercice);
                exercice1.setNom(nome);
                exercice1.setDate_debut(debutt);
                exercice1.setDate_fin(finn);
                exercice1.setAnnée(annee);
                switch (etatex){
                    case "Encours":
                        exercice1.setEtatExercice(EtatExercice.EnCours);
                        break;
                    case "Terminé":
                        exercice1.setEtatExercice(EtatExercice.Terminé);
                        break;
                }
                exerciceService.update(exercice1);
                response.sendRedirect("PDAManager_war_exploded/Exercice");
                break;
            case ("/demandes") :
                String statusDemande = request.getParameter("statut");
                String  email = request.getParameter("email");
                Long id = Long.parseLong(request.getParameter("id"));
                Participation participation = new Participation();
                switch (statusDemande){
                    case "accept":
                     Participant participant = (Participant) userService.findUserByEmail(email);
                     Activité activite = activeteRepository.findActiviteByResponsblaID((Long) session.getAttribute("idUser"));
                     System.out.println(activite.getId());
                     participation.setActivite(activite);
                     participation.setParticipant(participant);
                     participation.setStatut(Statut.Present);
                     participationService.Add(participation);
                     Demande demande = (Demande) demandeService.findByID(id);
                     demande.setStatutDemande(StatutDemande.Accepte);
                     demandeService.update(demande);
                     response.sendRedirect("/PDAManager_war_exploded/demandes");
                        break;
                    case "refuse":
                        Demande demande1 = (Demande) demandeService.findByID(id);
                        demandeService.findByID(id);
                        demande1.setStatutDemande(StatutDemande.Refusee);
                        demandeService.update(demande1);
                        response.sendRedirect("/PDAManager_war_exploded/demandes");
                        break;

                }
                break;
        }


    }
}
