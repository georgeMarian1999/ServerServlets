package com.server.servers;

import com.server.servlets.ClientServlet;
import com.server.servlets.DispatcherServlet;
import com.server.servlets.MoviesServlet;
import com.server.servlets.StatusServlet;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;

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
        servletContextHandler.setContextPath("/");
        server.setHandler(servletContextHandler);

        servletContextHandler.addServlet(StatusServlet.class,"/status");
        servletContextHandler.addServlet(MoviesServlet.class,"/movies");
        servletContextHandler.addServlet(DispatcherServlet.class, "/dispatcher");
        servletContextHandler.addServlet(ClientServlet.class, "/");
        server.start();
        System.out.println("Jetty server started on port 8080" );
}
}
