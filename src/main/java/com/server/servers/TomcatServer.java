package com.server.servers;

import com.server.servlets.ClientServlet;
import com.server.servlets.DispatcherServlet;
import com.server.servlets.MoviesServlet;
import com.server.servlets.StatusServlet;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class TomcatServer {
    private final int PORT = 8080;
    private Tomcat server;

    public TomcatServer() {
        server = new Tomcat();
    }

    public void startServer() throws Exception{
        server.setPort(PORT);

        Context ctx = server.addContext("",(new File(".")).getAbsolutePath());


        Tomcat.addServlet(ctx,"Status", new StatusServlet());
        Tomcat.addServlet(ctx,"Movies",new MoviesServlet());
        Tomcat.addServlet(ctx, "Dispatcher", new DispatcherServlet());
        Tomcat.addServlet(ctx, "Client", new ClientServlet());

        ctx.addServletMappingDecoded("/status","Status");
        ctx.addServletMappingDecoded("/movies","Movies");
        ctx.addServletMappingDecoded("/dispatcher", "Dispatcher");
        ctx.addServletMappingDecoded("/","Client");

        server.start();
        System.out.println("Start server Tomcat embedded");
        server.getServer().await();
    }
}
