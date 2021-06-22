package io.muic.ssc.webapp.ServletProcesses;

import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Context;

public class ServletRouter {

    public void initialize(Context context){
        for (AbstractServlet servlet : ServletFactory.getServlets()) {
            try{
                String name = servlet.getClass().getSimpleName();
                Tomcat.addServlet(context, name, servlet);
                context.addServletMapping(servlet.getMapping(), name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
