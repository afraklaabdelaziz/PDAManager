package com.example.pdamanager.Servlets;

import com.example.pdamanager.Entities.Activité;
import com.example.pdamanager.Entities.EtatExercice;
import com.example.pdamanager.Entities.Exercice;
import com.example.pdamanager.Entities.TypeActivité;
import com.example.pdamanager.Services.ExerciceServiceImpl;
import com.example.pdamanager.Services.InterfaceService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "ExerciceServlet", urlPatterns = {"/Exercice","/addExercice","/updateExercice"})
public class ExerciceServlet extends HttpServlet {
    InterfaceService exerciceService = new ExerciceServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case ("/updateExercice"):
                EtatExercice[] etatExercices = EtatExercice.values();
                request.setAttribute("etatExercices",etatExercices);
                Long id = Long.parseLong(request.getParameter("id"));
                Exercice execice1= (Exercice) exerciceService.findByID(id);
                request.setAttribute("exercice",execice1);
                request.getRequestDispatcher("updateExercice.jsp").forward(request, response);
                break;
            case ("/addExercice"):
                request.getRequestDispatcher("addExercice.jsp").forward(request, response);
                break;
            case ("/Exercice"):
                System.out.println(request.getParameter("id"));
                List<Exercice> exercices = exerciceService.getAll();
                request.setAttribute("exercices",exercices);
                request.getRequestDispatcher("/listExercice.jsp").forward(request,response);
                System.out.println(exerciceService.getAll());
                System.out.println(request.getAttribute("id"));
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
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
        }


    }
}
