package com.example.pdamanager.Servlets;

import com.example.pdamanager.Entities.*;
import com.example.pdamanager.Services.AdresseServiceImpl;
import com.example.pdamanager.Services.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AuthServlet",urlPatterns ={"/login" ,"/register"})
public class AuthServlet extends HttpServlet {
    UserServiceImpl userService=new UserServiceImpl();
    AdresseServiceImpl adresseService=new AdresseServiceImpl();

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
                String pays=request.getParameter("pays");
                String Ville=request.getParameter("ville");
                String adresse=request.getParameter("adresse");
                String code=request.getParameter("code");
                Adresse addres=new Adresse();
                Pays payss=new Pays();
                Ville ville=new Ville();
                if(role.equals("1")){
                    Responsable responsable=new Responsable();
                    responsable.setNom(Nom);
                    responsable.setPrenom(Prenom);
                    responsable.setEmail(Email);
                    responsable.setPhone(Phone);
                    responsable.setPassword(Password);
                    userService.Add(responsable);
                    addres.setAdresse(adresse);
                    payss.setNom(pays);
                    ville.setNom(Ville);
                    ville.setPays(payss);
                    addres.setVille(ville);
                    addres.setCodePostal(code);
                    adresseService.AddPays(payss);
                    adresseService.AddVille(ville);
                    adresseService.Add(addres);


                }else if (role.equals("2")){
                    Participant participant=new Participant();
                    participant.setNom(Nom);
                    participant.setPrenom(Prenom);
                    participant.setEmail(Email);
                    participant.setPhone(Phone);
                    participant.setPassword(Password);
                    userService.Add(participant);
                    addres.setAdresse(adresse);
                    payss.setNom(pays);
                    payss.setNom(pays);
                    ville.setNom(Ville);
                    ville.setPays(payss);
                    addres.setVille(ville);
                    addres.setCodePostal(code);
                    adresseService.AddPays(payss);
                    adresseService.AddVille(ville);
                    adresseService.Add(addres);
                }
                break;
            case("/AddEditt"):
                String Action=request.getParameter("choose");
                if(Action.equals("1")){

                }
                break;

        }
    }
}
