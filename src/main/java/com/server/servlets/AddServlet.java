package com.server.servlets;

import com.server.model.Movie;
import com.server.repo.Repository;
import org.graalvm.compiler.lir.sparc.SPARCMove;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    private Repository repository = new Repository();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            int rating = Integer.parseInt(request.getParameter("rating"));
            String genre = request.getParameter("genre");
            Movie movie = new Movie(id,title,rating,genre);
            repository.addMovieToDB(movie);
            request.getRequestDispatcher("/").forward(request,response);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
