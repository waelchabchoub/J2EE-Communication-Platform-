<%-- 
    Document   : signin
    Created on : 5 nov. 2021, 22:18:25
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>Signin</div>
        <form action="/poco_team-war/Signin_serv" method="post">
            login : <input type="text" name="login" required>
            password : <input type="password" name="password" required>
            <input type="checkbox" name="remember-me" id="remember-me" />
            <label for="remember-me"><span><span></span></span>Remember me</label>
            <input type="submit" value="signin">
        </form>
        already have an account : <a href="signup.html">signup</a>
    </body>
</html>
