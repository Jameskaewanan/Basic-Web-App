package io.muic.ssc.webapp.ServletProcesses;

import io.muic.ssc.webapp.Servlets.HomeServlet;
import io.muic.ssc.webapp.Servlets.TestServlet;
import io.muzoo.ooc.webapp.basic.servlets.LoginServlet;

import java.util.ArrayList;
import java.util.List;

public class ServletFactory {

    private static List<AbstractServlet> servlets = new ArrayList<>();

    static {

        servlets.add(new HomeServlet());
        servlets.add(new TestServlet());
        servlets.add(new LoginServlet());

    }

    public static List<AbstractServlet> getServlets(){
        return servlets;
    }

}
