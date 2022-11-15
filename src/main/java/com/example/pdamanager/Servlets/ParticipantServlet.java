package com.example.pdamanager.Servlets;

import com.example.pdamanager.Entities.*;
import com.example.pdamanager.Services.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ParticipantServlet", urlPatterns = {"/dashboard","/updateProfile"})
public class ParticipantServlet extends HttpServlet {
    InterfaceService activeteService = new ActiveteServiceImpl();
    InterfaceService demandeService = new DemandeServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();
    InterfaceService participantService=new ParticipationServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String path = request.getServletPath();
     switch (path){
         case ("/dashboard") :
             List<Activité> activites = activeteService.getAll();
             request.setAttribute("activetes",activites);
             request.getRequestDispatcher("dashboard.jsp").forward(request,response);
             break;
         case ("/updateProfile"):
             request.getRequestDispatcher("updateProfile.jsp").forward(request,response);
             break;
     }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        switch (path){
            case "/dashboard" :
                String message = request.getParameter("message");
                String emailResponsable = request.getParameter("emailResponsable");
                Demande demande = new Demande();
                demande.setMessage(message);
                demande.setStatutDemande(StatutDemande.EnCours);
                Participant participant = (Participant) userService.findUserByEmail((String) session.getAttribute("email"));
                Responsable responsable = (Responsable) userService.findUserByEmail(emailResponsable);
                demande.setParticipant(participant);
                demande.setResponsable(responsable);
                demandeService.Add(demande);
                response.sendRedirect("/PDAManager_war_exploded/dashboard");
                break;
        }
    }
}
