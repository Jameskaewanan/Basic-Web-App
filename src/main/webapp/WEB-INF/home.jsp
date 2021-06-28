<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="java.sql.*"%>

<html>

<head>
<title>User List Page</title>
</head>

<body>

<h1>Welcome to the User List Page</h1>
<h2>Hello ${name}</h2>
<h2>Current user: ${username}</h2>

<form method="post">
    <button type="submit" name="logout">Logout</button>
</form>

<form method="post">
<table border="2">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Username</td>
        <td>Options</td>
    </tr>

    <%
        try {
            String url = "jdbc:mysql://localhost:3306/webapp";
            String username = "root";
            String password = "Surface7455";
            Integer num = 0;
            String query = "select * from user";
            ResultSet resultSet = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
    %>

    <tr>
            <% num++; %>
            <td> <%= resultSet.getString("id")%> </td>
            <td> <%= resultSet.getString("name")%> </td>
            <td> <%= resultSet.getString("username")%> </td>
            <td> <button type="submit" name="remove" value=<%=resultSet.getNString("username")%>>Remove</button> </td>

    </tr>

    <%  }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    %>
</table>
</form>

</body>

</html>
