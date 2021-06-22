package io.muic.ssc.webapp.Servlets;

import io.muic.ssc.webapp.ServletProcesses.AbstractServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(security.isAuthorized(request)){
            String username = (String) request.getSession().getAttribute("username");
            request.setAttribute("username", username);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/home.jsp");
            requestDispatcher.include(request, response);
        }
        else{
            response.sendRedirect("/login");
        }

    }

    @Override
    public String getMapping() {
        return "/index.jsp";
    }
}
