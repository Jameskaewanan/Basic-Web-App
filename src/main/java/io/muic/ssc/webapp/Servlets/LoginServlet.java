package io.muzoo.ooc.webapp.basic.servlets;

import io.muic.ssc.webapp.ServletProcesses.AbstractServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
        requestDispatcher.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // authentication
        if (security.authenticate(username, password, request)) {
            response.sendRedirect("/");
        } else {
            error = "Username or Password incorrect. Please try again.";
            request.setAttribute("message", error);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
            requestDispatcher.include(request, response);
        }
    }

    @Override
    public String getMapping() {
        return "/login";
    }
}