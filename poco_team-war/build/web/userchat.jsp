<%-- 
    Document   : userchat
    Created on : 11 nov. 2021, 21:03:51
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>User Chat</h1>
        <p><b>Team id: </b>
            <% String id = request.getParameter("idequipe");%>
            <%= id %>
            <c:import url="/DisplayTeamMembers"/><br><hr>
            
    </body>
</html>
