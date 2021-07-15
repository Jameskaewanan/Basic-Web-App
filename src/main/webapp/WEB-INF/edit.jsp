<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<h2>
    Please Enter Your New Password
</h2>
<body>
<p>
    ${error}
</p>
<p>
<form method="post">
    <%--@declare id="password"--%><label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
    <br>
    <br>
    <button type="submit" name="alter">Submit</button>
</form>
<form method="post">
    <button type="submit" name="back">Back</button>
</form>
</p>
</body>
</html>