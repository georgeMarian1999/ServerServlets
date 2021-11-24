package com.server.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "Dispatcher", value = "/dispatcher")
public class DispatcherServlet extends HttpServlet {
    //@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    //@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination = request.getParameter("destination");

        if (destination == null){
            request.getRequestDispatcher("/default").forward(request, response);
        }
        else if (destination.equals("st")) {
            request.getRequestDispatcher("/status").forward(request, response);
        }
        else if (destination.equals("mv")) {
            request.getRequestDispatcher("/movies").forward(request, response);
        }
    }
}
