package com.server;

import com.server.servers.JettyServer;
import com.server.servers.TomcatServer;

import java.util.Scanner;

public class StartServer {
    public static void main(String[] args) throws Exception {

        int decision;
        System.out.println("Ce server doriti sa rulati?");
        System.out.println("1.Tomcat Server");
        System.out.println("2.Jetty Server");
        System.out.println("Introduceti numarul specificat");
        Scanner keyboard = new Scanner(System.in);
        decision = keyboard.nextInt();
        if(decision == 1) {
            TomcatServer tomcatServer = new TomcatServer();
            tomcatServer.startServer();
        }
        else  {
            JettyServer jettyServer = new JettyServer();
            jettyServer.start();
        }

    }
}
