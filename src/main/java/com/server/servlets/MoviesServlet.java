package com.server.servlets;

import com.server.model.Movie;
import com.server.jsontemplate.JSONTemplate;

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
        response.setContentType("text/html");
        JSONTemplate jsonTemplate = new JSONTemplate();
        PrintWriter out = response.getWriter();
        List<Movie> movies = jsonTemplate.getMovies();
        out.println("<!DOCTYPE html>");
        out.println("");
        out.println("<html lang=\"en\">");
        out.println("<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Movies</title>");
        out.println("<style>" +
                "table {\n" +
                "            font-family: arial, sans-serif;\n" +
                "            border-collapse: collapse;\n" +
                "            width: 100%;\n" +
                "        }\n" +
                ".button {\n" +
                        "            background: #e14e4e;\n" +
                        "            border-radius: 7px;\n" +
                        "            padding: 10px;\n" +
                        "            border-width: 0;\n" +
                        "            width: 130px;\n" +
                        "            color: white;\n" +
                        "            cursor: pointer;\n" +
                        "        }"+
                "\n" +
                "        .hidden { display: none;}   "+
                "        td, th {\n" +
                "            border: 1px solid #dddddd;\n" +
                "            text-align: left;\n" +
                "            padding: 8px;\n" +
                "        }\n" +
                "\n" +
                "        tr:nth-child(even) {\n" +
                "            background-color: #45a3ff;\n" +
                "        }\n" +
                "        .home-button {\n" +
                "            \n" +
                "            padding: 10px;\n" +
                "            cursor: pointer;\n" +
                "            border-width: 0;\n" +
                "            width: 150px;\n   "+
                "            color:white;\n     "+
                "            border-radius: 7px;\n" +
                "            background: #45a3ff;\n" +
                "            margin-bottom: 15px;\n" +
                "            text-transform: capitalize;\n" +
                "        }\n" +
                "        .home-input {\n" +
                "            display: none;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>");
       out.println("<div>\n" +
               "        <h2>Movies DataBase</h2>\n" +
               "            <form method=\"post\" action=\"dispatcher\">\n" +
               "                <input class=\"home-input\" type=\"text\" name=\"destination\" value=\"home\"/>\n" +
               "                <input class=\"home-button\" type=\"submit\" value=\"HOME\"/>\n" +
               "            </form>\n" +
               "        <table>");
        out.println("<tr>");
        out.println("<td>ID</td>");
        out.println("<td>Title</td>");
        out.println("<td>Rating</td>");
        out.println("<td>Genre</td>");
        out.println("<td>Delete action</td>");

        for (Movie mov:movies
            ) {
            out.println("<tr>");
            out.println("<td>"+mov.getId()+"</td>");
            out.println("<td>"+mov.getTitle()+"</td>");
            out.println("<td>"+mov.getRating()+"/10</td>");
            out.println("<td>"+mov.getGenre()+"</td>");
            out.println("<td>\n" +
                    "                    <form action=\"dispatcher\" method=\"post\">\n" +
                    "                        <input type=\"text\" name=\"deleteId\" class=\"hidden\" value=\""+mov.getId()+"\" />\n" +
                    "                        <input class=\"button\" type=\"submit\" value=\"Delete\">\n" +
                    "                    </form>\n" +
                    "                </td>");
            out.println("</tr>");
            }

        out.println("</table>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>");
        out.flush();
    }
}
