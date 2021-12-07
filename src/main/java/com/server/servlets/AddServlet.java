package com.server.servlets;

import com.server.model.Movie;
import com.server.repo.JSONTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String title = request.getParameter("title");
            int rating = Integer.parseInt(request.getParameter("rating"));
            String genre = request.getParameter("genre");
            JSONTemplate jsonTemplate = new JSONTemplate();
            int id = jsonTemplate.getMaxId();
            Movie movie = new Movie(id,title,rating,genre);
            jsonTemplate.addMovie(movie);
            System.out.println("New movie saved");
            request.getRequestDispatcher("/successMessage.html").forward(request, response);

        }catch (Exception e){
            request.getRequestDispatcher("/errorMessage.html").forward(request, response);
        }

    }
}
