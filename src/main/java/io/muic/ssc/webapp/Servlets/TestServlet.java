package io.muic.ssc.webapp.Servlets;

import io.muic.ssc.webapp.ServletProcesses.AbstractServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/test.jsp");
        requestDispatcher.include(request, response);

    }

    @Override
    public String getMapping() {
        return "/test.jsp";
    }
}
