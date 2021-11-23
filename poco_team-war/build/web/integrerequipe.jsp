<%-- 
    Document   : Integrerequipe
    Created on : 11 nov. 2021, 19:02:47
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
        <h1>Integrer Equipe</h1>
        <form action="IntegrerEquipe" method="post">
            TEAM CODE : <input type="text" name="code" required>
            <input type="submit" value="Integrer">
        </form>
    </body>
</html>
