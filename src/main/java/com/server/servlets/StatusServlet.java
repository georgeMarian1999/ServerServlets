package com.server.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class StatusServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/status.html");
        rd.forward(request,response);
        //response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        StringBuilder contentBuilder = new StringBuilder();
//        try {
//            BufferedReader in = new BufferedReader(new FileReader("server/status.html"));
//            String str;
//            while ((str = in.readLine()) != null) {
//                contentBuilder.append(str);
//            }
//            in.close();
//        } catch (IOException e) {
//            System.out.println(e);
//            out.println(e);
//            out.flush();
//        }
//        String content = contentBuilder.toString();
//        System.out.println(content);
//        out.println(content);
//        out.flush();
    }
}
