package io.muic.ssc.webapp;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.sql.*;

public class DatabaseConnection {

    public Connection connect() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp", "root", "Surface7455");
        return connection;
    }

    public User getUserData(String username) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = connect();
        Statement statement = connection.createStatement();
        String query = "select * from user where username=?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = null;
        if (resultSet.next()) {
            if (resultSet.getNString("username").equals(username)) {
                user = new User(resultSet.getNString("name"), resultSet.getNString("username"), resultSet.getNString("password"));
            }
        }
        connection.close();
        return user;
    }

    public Boolean checkUser(String username) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = connect();

        String query = "select * from user where username=?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next(); //if have username then return true, if not then false
    }

    public void addUser(String name, String username, String password) throws SQLException, ClassNotFoundException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = connect();

        try {
            String query = "insert into user (id,name,username,password) values(DEFAULT,?,?,?)";
            String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt());
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, pw_hash);
            preparedStatement.executeUpdate();
            connection.close();
            System.out.printf("it ran pt2");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeUser(String username) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = connect();

        try {
            String query = "delete from user where username=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editUser(String username, String alter, String change) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = null;
        connection = connect();

        if(change.equals("password")){
            query = "update data set password=? where username=?";
            alter = BCrypt.hashpw(alter, BCrypt.gensalt());
        }

        if (change.equals("name")) {
            query = "update data set name=? where username=?";
        }
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,alter);
        preparedStatement.setString(2,username);
        preparedStatement.executeUpdate();
        connection.close();
    }

}

