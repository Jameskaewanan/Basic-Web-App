package io.muic.ssc.webapp;


import org.apache.tomcat.util.codec.binary.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class SecurityService {

    private Map<String, String> userCredentials = new HashMap<String, String>() {{
        put("admin", "123456");
        put("muic", "1111");
    }};

    public boolean isAuthorized(HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");
        // do checking
        return (username != null && userCredentials.containsKey(username));
    }

    public boolean authenticate(String username, String password, HttpServletRequest request) {
        String passwordInDB = userCredentials.get(username);
        if (password.equals(passwordInDB)) {
            request.getSession().setAttribute("username", username);
            return true;
        } else {
            return false;
        }
    }

    public void logout(HttpServletRequest request) {
        request.getSession().invalidate();
    }

}