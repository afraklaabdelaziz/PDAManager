package com.example.pdamanager.Servlets;

import com.example.pdamanager.Entities.Activité;
import com.example.pdamanager.Entities.EtatExercice;
import com.example.pdamanager.Entities.Exercice;
import com.example.pdamanager.Services.ExerciceServiceImpl;
import com.example.pdamanager.Services.InterfaceService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "ExerciceServlet", urlPatterns = {"/addExercice","/updateExercice","/listExercice"})
public class ExerciceServlet extends HttpServlet {
    InterfaceService exerciceService = new ExerciceServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case ("/listExercice"):
                request.getRequestDispatcher("listExercice.jsp").forward(request, response);
                break;
            case ("/updateExercice"):
                request.getRequestDispatcher("updateExercice.jsp").forward(request, response);
                break;
            case ("/addExercice"):
                request.getRequestDispatcher("addExercice.jsp").forward(request, response);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDate an=LocalDate.parse( request.getParameter("anne"));
        LocalDate debut=LocalDate.parse(request.getParameter("debut"));
        LocalDate fin=LocalDate.parse(request.getParameter("fin"));
        //EtatExercice etat= EtatExercice.valueOf(request.getParameter(""));
        String choice=request.getParameter("choix");
        Exercice exercice=new Exercice();
        if(choice.equals("2")){
            exercice.setEtatExercice(EtatExercice.EnCours);
        } else if (choice.equals("1")) {
            exercice.setEtatExercice(EtatExercice.Terminé);
        }
        exercice.setAnnée(an);
        exercice.setDate_debut(debut);
        exercice.setDate_fin(fin);
        exerciceService.Add(exercice);
    }
}
