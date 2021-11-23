<%-- 
    Document   : adminchat
    Created on : 10 nov. 2021, 21:50:47
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
        <h1>Admin Chat</h1>
        <p><b>Team id: </b>
            <%= request.getParameter("idequipe")%>
            <c:import url="/DisplayAdminChat"/><br><hr>
        
        
        
    </body>
</html>
