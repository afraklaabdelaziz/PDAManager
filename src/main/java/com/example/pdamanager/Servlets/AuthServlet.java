package com.example.pdamanager.Servlets;

import com.example.pdamanager.Entities.Participant;
import com.example.pdamanager.Entities.Responsable;
import com.example.pdamanager.Services.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AuthServlet",urlPatterns ={"/login" ,"/register"})
public class AuthServlet extends HttpServlet {
    UserServiceImpl userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=request.getServletPath();
        switch (path){
            case("/register"):
                request.getRequestDispatcher("register.jsp").forward(request,response);
                break;
            case("/login"):
                request.getRequestDispatcher("login.jsp").forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=request.getServletPath();
        switch(path){
            case("/register"):
                String role=request.getParameter("choix");
                String Nom=request.getParameter("nom");
                String Prenom=request.getParameter("prenom");
                String Email=request.getParameter("email");
                String Phone=request.getParameter("phone");
                String Password=request.getParameter("password");
                System.out.println(role);
                if(role.equals("1")){
                    Responsable responsable=new Responsable();
                    responsable.setNom(Nom);
                    responsable.setPrenom(Prenom);
                    responsable.setEmail(Email);
                    responsable.setPhone(Phone);
                    responsable.setPassword(Password);
                    userService.AddUser(responsable);
                }else if (role.equals("2")){
                    Participant participant=new Participant();
                    participant.setNom(Nom);
                    participant.setPrenom(Prenom);
                    participant.setEmail(Email);
                    participant.setPhone(Phone);
                    participant.setPassword(Password);
                    userService.AddUser(participant);
                }
        }
    }
}
