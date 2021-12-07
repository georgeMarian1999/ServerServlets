package com.server.servers;

import com.server.servlets.*;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import java.io.File;
import java.net.URI;
import java.net.URL;

public class JettyServer {
    private Server server;

    public JettyServer(){
        server = new Server();
    }

    public void start() throws Exception {

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[] {connector});



        ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.setContextPath("/server");


        servletContextHandler.setResourceBase("C:\\Work\\server\\src\\main\\webapp");
        server.setHandler(servletContextHandler);
        servletContextHandler.setWelcomeFiles(new String[]{"index.html"});


        ServletHolder holderPwd = new ServletHolder("default", DefaultServlet.class);
        holderPwd.setInitParameter("resourceBase","C:\\Work\\server\\src\\main\\webapp");
        holderPwd.setInitParameter("dirAllowed","true");
        servletContextHandler.addServlet(holderPwd,"/");

        servletContextHandler.addServlet(StatusServlet.class,"/status");
        servletContextHandler.addServlet(MoviesServlet.class,"/movies");
        servletContextHandler.addServlet(DispatcherServlet.class, "/dispatcher");
        servletContextHandler.addServlet(AddMovieFormServlet.class, "/addMovie");
        servletContextHandler.addServlet(AddServlet.class, "/add");

        server.start();
        System.out.println("Jetty server started on port 8080");
}
}
