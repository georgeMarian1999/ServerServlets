package com.server.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class StatusServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        StringBuilder contentBuilder = new StringBuilder();

        try {
            String str;
            BufferedReader in;
            if (request.getRequestURL().toString().contains("server")) {
                URL index = new URL("http://localhost:8080/server/status.html");
                URLConnection yc = index.openConnection();
                in = new BufferedReader(new InputStreamReader(
                        yc.getInputStream()));
            }
            else {
                in = new BufferedReader(new FileReader("C:\\Work\\server\\src\\main\\webapp\\status.html"));
            }

            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e);
            request.getRequestDispatcher("/errorMessage.html").forward(request, response);
        }
        String content = contentBuilder.toString();
        out.println(content);
        out.flush();
    }
}
