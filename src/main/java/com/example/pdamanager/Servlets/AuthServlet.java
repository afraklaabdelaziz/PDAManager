package com.example.pdamanager.Servlets;

import com.example.pdamanager.Services.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AuthServlet", urlPatterns = {"/login","/register"})
public class AuthServlet extends HttpServlet {
    UserServiceImpl userServece = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path){
            case ("/login"):
                request.getRequestDispatcher("login.jsp").forward(request,response);
                break;
            case ("/register"):
                request.getRequestDispatcher("login.jsp").forward(request,response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String email = request.getParameter("email");
      String password = request.getParameter("password");
      HttpSession session = request.getSession();
        String path = request.getServletPath();

             if (userServece.findByEmail(email).getEmail().equals(email) && userServece.findByEmail(email).getPassword().equals(password)) {
                 session.setAttribute("fname", userServece.findByEmail(email).getNom());
                 session.setAttribute("lname", userServece.findByEmail(email).getPrenom());
                 session.setAttribute("phone", userServece.findByEmail(email).getPhone());
                 session.setAttribute("email", email);
                 session.setAttribute("id", userServece.findByEmail(email).getId());
                 request.getRequestDispatcher("connect.jsp").forward(request, response);
             }
    }
}
