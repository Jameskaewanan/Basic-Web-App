package io.muic.ssc.webapp;

import org.springframework.security.crypto.bcrypt.BCrypt;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class SecurityService {


    private UserService userService;

    public SecurityService(UserService userService){
        this.userService = userService;
    }

    public boolean isAuthorized(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String username = (String) request.getSession().getAttribute("username");
        return (username != null);
    }

    public Boolean authenticate(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.getUsername(username);
        if (userService.doesExist(username)) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("username", username);
            return true;
        } else {
            return false;
        }
    }

    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.invalidate();
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public UserService getUserService() { return userService; }

}