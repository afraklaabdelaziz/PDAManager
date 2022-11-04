package com.example.pdamanager.Servlets;


import com.example.pdamanager.Entities.*;
import com.example.pdamanager.Services.AdresseServiceImpl;

import com.example.pdamanager.Entities.Participant;
import com.example.pdamanager.Entities.Responsable;
import com.example.pdamanager.Entities.User;

import com.example.pdamanager.Services.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AuthServlet",urlPatterns ={"/login" ,"/register","/Choix"})
public class AuthServlet extends HttpServlet {

    UserServiceImpl userService=new UserServiceImpl();
    AdresseServiceImpl adresseService=new AdresseServiceImpl();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=request.getServletPath();
        HttpSession session = request.getSession();
        String role=request.getParameter("choose");
        session.setAttribute("choose",role);
        switch (path){
            case("/register"):
                Type [] types = Type.values();
                Genre[] genres = Genre.values();
                request.setAttribute("genre",genres);
                request.setAttribute("typeRes",types);
                request.getRequestDispatcher("register.jsp").forward(request, response);
                break;
            case("/login"):
                request.getRequestDispatcher("login.jsp").forward(request,response);
                break;
            case ("/Choix"):
                request.getRequestDispatcher("Choix.jsp").forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Role rolee = new Role();
        String path=request.getServletPath();
        HttpSession session = request.getSession();
        switch(path){
            case("/register"):
                String Nom=request.getParameter("nom");
                String Prenom=request.getParameter("prenom");
                String Email=request.getParameter("email");
                String Phone=request.getParameter("phone");
                String Password=request.getParameter("password");
                String pays=request.getParameter("pays");
                String Ville=request.getParameter("ville");
                String adresse=request.getParameter("adresse");
                String code=request.getParameter("code");
                String typeRes = request.getParameter("typeResponsable") ;
                String domaine=request.getParameter("domaine");
                String genre = request.getParameter("genre");
                Adresse addres=new Adresse();
                Pays payss=new Pays();
                Ville ville=new Ville();
                if(session.getAttribute("choose").equals("1")){
                    Responsable responsable=new Responsable();
                    responsable.setNom(Nom);
                    responsable.setPrenom(Prenom);
                    responsable.setEmail(Email);
                    responsable.setPhone(Phone);
                    responsable.setPassword(Password);
                    responsable.setDomaine(domaine);

                    switch (typeRes){
                        case "Formatteur" :
                            responsable.setType(Type.Formatteur);
                            break;
                        case "Interveneur" :
                            responsable.setType(Type.Interveneur);
                            break;
                    }

                    addres.setAdresse(adresse);
                    payss.setNom(pays);
                    ville.setNom(Ville);
                    ville.setPays(payss);
                    addres.setVille(ville);
                    addres.setCodePostal(code);
                    adresseService.Add(payss);
                    adresseService.Add(ville);
                    adresseService.Add(addres);
                    responsable.setAdresse(addres);
                    rolee.setId(2);
                    responsable.setRole(rolee);

                    userService.Add(responsable);
                    response.sendRedirect("/PDAManager_war_exploded/login");
                }else if (session.getAttribute("choose").equals("2")){
                    Participant participant=new Participant();
                    participant.setNom(Nom);
                    participant.setPrenom(Prenom);
                    participant.setEmail(Email);
                    participant.setPhone(Phone);
                    participant.setPassword(Password);

                    switch (genre){
                        case "Homme" :
                            participant.setGenre(Genre.Homme);
                            break;
                        case "Femme" :
                            participant.setGenre(Genre.Femme);
                            break;
                    }
                    addres.setAdresse(adresse);
                    payss.setNom(pays);
                    payss.setNom(pays);
                    ville.setNom(Ville);
                    ville.setPays(payss);
                    addres.setVille(ville);
                    addres.setCodePostal(code);
                    adresseService.Add(payss);
                    adresseService.Add(ville);
                    adresseService.Add(addres);
                    participant.setAdresse(addres);
                    rolee.setId(3);
                    participant.setRole(rolee);
                    userService.Add(participant);
                    response.sendRedirect("/login");
                }
                break;
            case ("/login"):
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                User  findEmail = (User) userService.findUserByEmail(email);

                HttpSession sessionn = request.getSession();
                if (findEmail.getEmail().equals(email) && findEmail.getPassword().equals(password)) {
                    sessionn.setAttribute("name", findEmail.getNom());
                    sessionn.setAttribute("prenom", findEmail.getPrenom());
                    request.setAttribute("user", findEmail);
                    Role roleUser = (Role) userService.findByID(findEmail.getRole().getId());
                    sessionn.setAttribute("roleUser",roleUser.getNom());
                    request.getRequestDispatcher("connect.jsp").forward(request, response);
                }else{
                    session.setAttribute("error","mot de passe ou email incorrect");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                break;
        }
    }
}
