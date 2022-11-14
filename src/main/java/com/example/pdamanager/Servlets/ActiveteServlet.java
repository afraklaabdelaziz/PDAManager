package com.example.pdamanager.Servlets;

import com.example.pdamanager.Entities.*;
import com.example.pdamanager.Services.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ActiveteServlet", urlPatterns = {"/listActivetes" ,"/updateActivete","/profile"})
public class ActiveteServlet extends HttpServlet {

    TypeActivité typeActivité;
    InterfaceService activeteService = new ActiveteServiceImpl();
    InterfaceService responsableService = new ResponsableServiceImpl();
    InterfaceService adresseService=new AdresseServiceImpl();
    InterfaceService villeService = new VilleServiceImpl();
    InterfaceService paysService = new PaysServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();
    InterfaceService exrciceService = new ExerciceServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path = request.getServletPath();
    switch (path){
        case ("/updateActivete"):
            TypeActivité [] typeActivitesUp = TypeActivité.values();
            request.setAttribute("typeActiveteUp",typeActivitesUp);
            long id = Long.parseLong(request.getParameter("id"));
            Activité findActivite = (Activité) activeteService.findByID(id);
            List<Activité> activitess = activeteService.getAll();
            List<Responsable> responsabless = responsableService.getAll();
            for (Activité activite : activitess){
                for (Responsable responsable : responsabless){
                    if (activite.getResponsable().getId() == responsable.getId()) {
                        responsabless.removeAll(Arrays.asList(responsable));
                    }
                    if (responsabless.size() == 0){
                        break;
                    }
                }
            }
            request.setAttribute("responsables",responsabless);
            request.setAttribute("actevete",findActivite);
            request.getRequestDispatcher("updateActivete.jsp").forward(request,response);
            break;
        case ("/listActivetes"):
            TypeActivité [] typeActivites = TypeActivité.values();
            request.setAttribute("typeActivete",typeActivites);
            List<Activité> activites = activeteService.getAll();
            List<Responsable> responsables = responsableService.getAll();
            List<Exercice> exercices = exrciceService.getAll();
            request.setAttribute("exercices",exercices);
            for (Activité activite : activites){
                for (Responsable responsable : responsables){
                    if (activite.getResponsable().getId() == responsable.getId()){
                        responsables.removeAll(Arrays.asList(responsable));
                    }
                    if (responsables.size() == 0){
                        break;
                    }
                }
            }
            request.setAttribute("responsables",responsables);
            request.setAttribute("activetes",activites);
            request.getRequestDispatcher("/listeActivete.jsp").forward(request,response);
            break;
        case ("/profile"):
            request.getRequestDispatcher("adminProfile.jsp").forward(request,response);
            break;
    }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path = request.getServletPath();
    HttpSession session = request.getSession();
        switch (path){
            case ("/listActivetes") :
                String title = request.getParameter("title");
                LocalDate dateDInsc = LocalDate.parse(request.getParameter("dateDI"));
                LocalDate dateFInsc = LocalDate.parse(request.getParameter("dateFI"));
                LocalDate dateDebut = LocalDate.parse(request.getParameter("dateDebut"));
                LocalDate dateFin = LocalDate.parse(request.getParameter("dateFin"));
                String[] exerciceString = request.getParameterValues("exercices");
                String description = request.getParameter("desc");
                String type = request.getParameter("choixType");
                String  responsable = request.getParameter("responsable");
                Responsable responsable1 = new Responsable();
                Activité activité =   new Activité();
                List<Exercice> exercices = new ArrayList<>();
                for (String s : exerciceString) {
                    exercices.add(new Exercice( Long.parseLong(s) ));
                }
                activité.setExerciceList(exercices);
                if (responsable == null){
                    activité.setResponsable(null);
                }else {
                    responsable1.setId(Long.parseLong(responsable));
                    activité.setResponsable(responsable1);
                }
                activité.setTitle(title);
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
                response.sendRedirect("/PDAManager_war_exploded/listActivetes");
                          break;
            case ("/updateActivete") :
                LocalDate dateDInscUp = LocalDate.parse(request.getParameter("dateDIUp"));
                LocalDate dateFInscUp = LocalDate.parse(request.getParameter("dateFIUp"));
                LocalDate dateDebutUp = LocalDate.parse(request.getParameter("dateDebutUp"));
                LocalDate dateFinUp = LocalDate.parse(request.getParameter("dateFinUp"));
                String descriptionUp = request.getParameter("descUp");
                String typeUp = request.getParameter("choixTypeUp");
                String titleUp = request.getParameter("titleUp");
                Long idActivite = Long.parseLong(request.getParameter("id"));

                Activité activiteUp = (Activité) activeteService.findByID(idActivite);
                activiteUp.setTitle(titleUp);
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
                response.sendRedirect("/PDAManager_war_exploded/listActivetes");
                break;
            case ("/profile") :
                String nomUp=request.getParameter("nomUp");
                String prenomUp=request.getParameter("prenomUp");
                String emailUp=request.getParameter("emailUp");
                String phoneUp=request.getParameter("phoneUp");
                String passwordUp=request.getParameter("passwordUp");
                System.out.println(passwordUp);
                String paysUp=request.getParameter("paysUp");
                String villeUp=request.getParameter("villeUp");
                String adresseUp=request.getParameter("adresseUp");
                User user = (User) userService.findUserByEmail((String) session.getAttribute("email"));
                user.setEmail(emailUp);
                user.setPrenom(prenomUp);
                user.setNom(nomUp);
                user.setPassword(passwordUp);
                user.setPhone(phoneUp);
                Adresse adresse1 = (Adresse) adresseService.findByID((Long) session.getAttribute("idAdresse"));
                Ville ville1 = (Ville) villeService.findByID((Long) session.getAttribute("idVille"));
                Pays pays1 = (Pays) paysService.findByID((Long) session.getAttribute("idPays"));
                adresse1.setAdresse(adresseUp);
                pays1.setNom(paysUp);
                ville1.setNom(villeUp);
                paysService.update(pays1);
                villeService.update(ville1);
                adresseService.update(adresse1);
                ville1.setPays(pays1);
                adresse1.setVille(ville1);
                user.setAdresse(adresse1);
                userService.update(user);
                response.sendRedirect("/PDAManager_war_exploded/profile");
                break;
        }


    }
}
