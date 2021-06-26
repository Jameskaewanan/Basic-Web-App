package io.muic.ssc.webapp.Servlets;

import io.muic.ssc.webapp.ServletProcesses.AbstractServlet;
import io.muic.ssc.webapp.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class HomeServlet extends AbstractServlet { // User List page (home page for when you successfully logged in)

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if(security.isAuthorized(request)){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/home.jsp");
                requestDispatcher.include(request, response);
            }
            else{
                response.sendRedirect("/login");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = null;

        if (request.getParameter("logout") != null) {
            security.logout(request);
            response.sendRedirect("/login");
        }

        /*

        if (request.getParameter("remove") != null) {
            try {
                if (!user.getUsername().equals(session.getAttribute("username"))) {
                    authentication.getUserService().removeUser(user.getUsername());
                    String warning = "You have now deleted the user";
                    request.setAttribute("warning", warning);
                    response.sendRedirect("/index.jsp");
                } else {
                    String warning = "you can't delete your own account";
                    request.setAttribute("warning", warning);
                    response.sendRedirect("/index.jsp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

         */
    }

    @Override
    public String getMapping() {
        return "/index.jsp";
    }
}
