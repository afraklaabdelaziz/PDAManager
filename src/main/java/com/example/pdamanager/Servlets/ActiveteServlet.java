package com.example.pdamanager.Servlets;

import com.example.pdamanager.Entities.Activité;
import com.example.pdamanager.Entities.Etat;
import com.example.pdamanager.Entities.TypeActivité;
import com.example.pdamanager.Services.ActiveteServiceImpl;
import com.example.pdamanager.Services.InterfaceService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "ActiveteServlet", urlPatterns = {"/listActivetes" ,"/updateActivete"})
public class ActiveteServlet extends HttpServlet {

    TypeActivité typeActivité;
    InterfaceService activeteService = new ActiveteServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path = request.getServletPath();
    switch (path){
        case ("/updateActivete"):
            request.getRequestDispatcher("updateActivete.jsp").forward(request,response);
            break;
        case ("/listActivetes") :
            TypeActivité [] typeActivites = TypeActivité.values();
            request.setAttribute("typeActivete",typeActivites);

            List<Activité> activites = activeteService.getAll();

            request.setAttribute("activetes",activites);
            request.getRequestDispatcher("/listeActivete.jsp").forward(request,response);
            break;
    }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       LocalDate dateDInsc = LocalDate.parse(request.getParameter("dateDI"));
       LocalDate dateFInsc = LocalDate.parse(request.getParameter("dateFI"));
       LocalDate dateDebut = LocalDate.parse(request.getParameter("dateDebut"));
       LocalDate dateFin = LocalDate.parse(request.getParameter("dateFin"));
       String description = request.getParameter("desc");
       String type = request.getParameter("choixType");

       Activité activité =   new Activité();
        activité.setDate_debut(dateDebut);
        activité.setDate_de_participation(dateDInsc);
        activité.setDate_fin_participation(dateFInsc);
        activité.setDate_fin(dateFin);
        activité.setDescription(description);
        activité.setEtatActivité(Etat.Active);
        switch (type){
            case "Evenement":
                activité.setTypeActivité(TypeActivité.Evenement);
                break;
            case "Formation" :
                activité.setTypeActivité(TypeActivité.Formation);
                break;
            case "Talk" :
                activité.setTypeActivité(TypeActivité.Talk);
                break;
        }
        activeteService.Add(activité);
    }
}
