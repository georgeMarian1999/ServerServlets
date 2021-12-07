package com.server.servers;

import com.server.servlets.*;
import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;
import org.apache.catalina.core.StandardContext;
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
        String webappDirLocation = "C:\\Work\\server\\src\\main\\webapp";

        StandardContext ctx = (StandardContext) server.addWebapp("/server", new File(webappDirLocation).getAbsolutePath());

        server.start();
        System.out.println("Start server Tomcat embedded");
        server.getServer().await();
    }
}
