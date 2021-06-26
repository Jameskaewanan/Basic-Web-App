package io.muic.ssc.webapp.ServletProcesses;

import io.muic.ssc.webapp.DatabaseConnection;
import io.muic.ssc.webapp.SecurityService;
import io.muic.ssc.webapp.UserService;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Context;

public class ServletRouter {

    private DatabaseConnection database;

    public void initialize(Context context){

        database = new DatabaseConnection();
        UserService userService = new UserService(database);
        SecurityService security = new SecurityService(userService);
        security.setUserService(userService);

        for (AbstractServlet servlet : ServletFactory.getServlets()) {
            try{
                AbstractServlet httpServlet = servlet;
                httpServlet.AbstractServlet(security);
                String name = servlet.getClass().getSimpleName();
                Tomcat.addServlet(context, name, httpServlet);
                context.addServletMapping(httpServlet.getMapping(), name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
