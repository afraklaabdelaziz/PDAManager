package com.example.pdamanager.Servlets;

import com.example.pdamanager.Entities.Activité;
import com.example.pdamanager.Services.ActiveteServiceImpl;
import com.example.pdamanager.Services.InterfaceService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ParticipantServlet", urlPatterns = {"/dashboard","/updateProfile"})
public class ParticipantServlet extends HttpServlet {
    InterfaceService activeteService = new ActiveteServiceImpl();
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

    }
}
