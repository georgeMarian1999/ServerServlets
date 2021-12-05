package com.server.servlets;

import com.google.gson.Gson;
import com.server.model.Movie;
import com.server.repo.Repository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MoviesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        Repository repository = new Repository();
        PrintWriter out = response.getWriter();
        List<Movie> movies = repository.getAllMovies();
        out.println(new Gson().toJson(movies));
        out.close();
    }
}
