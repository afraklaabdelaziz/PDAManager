package com.example.pdamanager.Servlets;

import com.example.pdamanager.Entities.Activité;
import com.example.pdamanager.Services.ActiveteServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ActiveteServlet", value = "/ActiveteServlet")
public class ActiveteServlet extends HttpServlet {
    ActiveteServiceImpl activeteService = new ActiveteServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String dateDInsc = request.getParameter("dateDI");
       String dateFInsc = request.getParameter("dateFI");
       String dateDebut = request.getParameter("dateDebut");
       String dateFin = request.getParameter("dateFin");

        Activité activité =   new Activité();
        
    }
}
