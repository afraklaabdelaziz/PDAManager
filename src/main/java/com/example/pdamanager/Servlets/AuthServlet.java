package com.example.pdamanager.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AuthServlet",urlPatterns ={"/login" ,"/register"})
public class AuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=request.getServletPath();
        switch (path){
            case("register"):
                request.getRequestDispatcher("register.jsp").forward(request,response);
                break;
            case("login"):
                request.getRequestDispatcher("login.jsp").forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String path = request.getServletPath();
      switch (path){
          case ("/login"):
              if()
              break;
      }
    }
}
