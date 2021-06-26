<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head><title>Registration Page</title></head>

<h2>Please register your username and password</h2>

<body>
<p>
    ${error}
</p>
<p>

<form method="post">
    <label for="name"><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="name" required>
    <br>
    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>
    <br>
    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
    <br>
    <br>
    <button type="submit" name="register">Register</button>
</form>

<form method="post">
<button type="submit" name="Back">Back</button>
</form>

</p>
</body>
</html>