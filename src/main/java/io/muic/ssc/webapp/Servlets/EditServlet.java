package io.muic.ssc.webapp.Servlets;

import io.muic.ssc.webapp.ServletProcesses.AbstractServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // open front web
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/edit.jsp");
        requestDispatcher.include(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // after that we you can do
        String password = request.getParameter("password");
        if (request.getParameter("edit")!= null) {
            try {
                security.getUserService().editUser((String) request.getSession().getAttribute("username"),password,"password");
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/home");
        }
        if (request.getParameter("back")!= null) {
            response.sendRedirect("/home");
        }
    }

    @Override
    public String getMapping() {
        return "/edit";
    }
}

