package io.muic.ssc.webapp.ServletProcesses;

import io.muic.ssc.webapp.SecurityService;

import javax.servlet.http.HttpServlet;

public abstract class AbstractServlet extends HttpServlet implements Routable {

    protected SecurityService security;

    public void AbstractServlet(SecurityService security) {
        this.security = security;
    }

}
