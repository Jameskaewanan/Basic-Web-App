package io.muic.ssc.webapp.ServletProcesses;

import io.muic.ssc.webapp.Servlets.HomeServlet;
import io.muic.ssc.webapp.Servlets.LoginServlet;
import io.muic.ssc.webapp.Servlets.RegisterServlet;

import java.util.ArrayList;
import java.util.List;

public class ServletFactory {

    private static List<AbstractServlet> servlets = new ArrayList<>();

    static {

        servlets.add(new HomeServlet());
        servlets.add(new LoginServlet());
        servlets.add(new RegisterServlet());

    }

    public static List<AbstractServlet> getServlets(){
        return servlets;
    }

}
