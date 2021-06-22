package io.muic.ssc.webapp;

import io.muic.ssc.webapp.ServletProcesses.ServletRouter;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

public class WebApp {

    public static void main(String[] args) {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        File docBase = new File("src/main/webapp/");
        docBase.mkdirs();

        ServletRouter router = new ServletRouter();
        Context context;

        try {
            context = tomcat.addWebapp("", docBase.getAbsolutePath());
            router.initialize(context);
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException | ServletException e) {
            e.printStackTrace();
        }


    }

}
