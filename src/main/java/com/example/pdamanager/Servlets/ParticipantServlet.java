package com.example.pdamanager.Servlets;

import com.example.pdamanager.Entities.Activité;
import com.example.pdamanager.Entities.Demande;
import com.example.pdamanager.Entities.Participant;
import com.example.pdamanager.Entities.StatutDemande;
import com.example.pdamanager.Services.ActiveteServiceImpl;
import com.example.pdamanager.Services.DemandeServiceImpl;
import com.example.pdamanager.Services.InterfaceService;
import com.example.pdamanager.Services.UserServiceImpl;
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
                Demande demande = new Demande();
                demande.setMessage(message);
                demande.setStatutDemande(StatutDemande.EnCours);
                Participant participant = (Participant) userService.findUserByEmail((String) session.getAttribute("email"));
                demande.setParticipant(participant);
                demandeService.Add(demande);
                break;
        }
    }
}
