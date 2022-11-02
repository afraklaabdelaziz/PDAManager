package com.example.pdamanager.Servlets;

import com.example.pdamanager.Entities.Activité;
import com.example.pdamanager.Entities.Etat;
import com.example.pdamanager.Entities.TypeActivité;
import com.example.pdamanager.Services.ActiveteServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "ActiveteServlet", urlPatterns = {"/listActivetes" ,"/updateActivete","/addActivete"})
public class ActiveteServlet extends HttpServlet {
    ActiveteServiceImpl activeteService = new ActiveteServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path = request.getServletPath();
    switch (path){
        case ("/listActivetes"):
            request.getRequestDispatcher("listActivetes.jsp").forward(request,response);
            break;
        case ("/updateActivete"):
            request.getRequestDispatcher("updateActivete.jsp").forward(request,response);
            break;
        case ("/addActivete") :
            request.getRequestDispatcher("addActivete.jsp").forward(request,response);
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

       Activité activité =   new Activité();
        activité.setDate_debut(dateDebut);
        activité.setDate_de_participation(dateDInsc);
        activité.setDate_fin_participation(dateFInsc);
        activité.setDate_fin(dateFin);
        activité.setDescription(description);

        activeteService.Add(activité);

    }
}
