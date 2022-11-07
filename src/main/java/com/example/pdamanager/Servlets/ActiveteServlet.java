package com.example.pdamanager.Servlets;

import com.example.pdamanager.Entities.Activité;
import com.example.pdamanager.Entities.Etat;
import com.example.pdamanager.Entities.TypeActivité;
import com.example.pdamanager.Entities.User;
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
            TypeActivité [] typeActivitesUp = TypeActivité.values();
            request.setAttribute("typeActiveteUp",typeActivitesUp);
            long id = Long.parseLong(request.getParameter("id"));
            Activité findActivite = (Activité) activeteService.findByID(id);
            request.setAttribute("actevete",findActivite);
            request.getRequestDispatcher("updateActivete.jsp").forward(request,response);
            break;
        case ("/listActivetes"):
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
    String path = request.getServletPath();
        switch (path){
            case ("/listActivetes") :
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
                          break;
            case ("/updateActivete") :
                LocalDate dateDInscUp = LocalDate.parse(request.getParameter("dateDIUp"));
                LocalDate dateFInscUp = LocalDate.parse(request.getParameter("dateFIUp"));
                LocalDate dateDebutUp = LocalDate.parse(request.getParameter("dateDebutUp"));
                LocalDate dateFinUp = LocalDate.parse(request.getParameter("dateFinUp"));
                String descriptionUp = request.getParameter("descUp");
                String typeUp = request.getParameter("choixTypeUp");
                Activité activiteUp =   new Activité();
                activiteUp.setDate_debut(dateDebutUp);
                activiteUp.setDate_de_participation(dateDInscUp);
                activiteUp.setDate_fin_participation(dateFInscUp);
                activiteUp.setDate_fin(dateFinUp);
                activiteUp.setDescription(descriptionUp);
                activiteUp.setEtatActivité(Etat.Active);
                switch (typeUp){
                    case "Evenement":
                        activiteUp.setTypeActivité(TypeActivité.Evenement);
                        break;
                    case "Formation" :
                        activiteUp.setTypeActivité(TypeActivité.Formation);
                        break;
                    case "Talk" :
                        activiteUp.setTypeActivité(TypeActivité.Talk);
                        break;
                }
                activeteService.update(activiteUp);
                break;
        }


    }
}
