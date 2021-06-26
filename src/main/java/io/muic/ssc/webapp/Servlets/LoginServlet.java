package io.muic.ssc.webapp.Servlets;

import io.muic.ssc.webapp.ServletProcesses.AbstractServlet;
import org.apache.commons.lang.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
        requestDispatcher.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error;

        try {
            if (security.authenticate(request)) {
                response.sendRedirect("/");
            }
            else {
                error = "Please try again, Password or Username is invalid";
                request.setAttribute("error",error);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
                requestDispatcher.include(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (request.getParameter("register")!=null) {
            response.sendRedirect("/register");
        }

    }

    @Override
    public String getMapping() {
        return "/login";
    }
}