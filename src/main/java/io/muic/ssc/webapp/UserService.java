package io.muic.ssc.webapp;

import java.sql.SQLException;

public class UserService {

    private DatabaseConnection database;

    public UserService(DatabaseConnection database){
        this.database = database;
    }

    public User getUsername(String username) throws SQLException, ClassNotFoundException {
        return database.getUserData(username);
    }

    public Boolean doesExist(String username) throws SQLException, ClassNotFoundException {
        if(database.checkUser(username)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void addUser(String name, String username, String password) throws SQLException, ClassNotFoundException {
        database.addUser(name, username, password);
    }

    public void removeUser(String username) throws SQLException, ClassNotFoundException {
        database.removeUser(username);
    }
}
