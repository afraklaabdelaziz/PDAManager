package com.example.pdamanager.Servlets;

import com.example.pdamanager.Services.ExerciceServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ExerciceServlet", urlPatterns = {"/addExercice","/updateExercice","/listExercice"})
public class ExerciceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExerciceServiceImpl exerciceService = new ExerciceServiceImpl();
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

    }
}
