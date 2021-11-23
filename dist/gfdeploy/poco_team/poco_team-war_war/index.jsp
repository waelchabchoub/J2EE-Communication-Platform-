<%-- 
    Document   : index
    Created on : 5 nov. 2021, 19:41:58
    Author     : user
--%>




<%@page import="javax.ejb.EJB"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.util.Base64"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        <h1>Home</h1>
        
        <!-- check the session -->
        <!-- if session id set show user name -->
        <c:if test="${ !empty sessionScope.login}" >
            <h6>Hello: ${sessionScope.login} </h6>
            <img src="data:image/jpg;base64,${sessionScope['image']}" width="100" height="150" />

        </c:if>
            
        <!-- if session id is not set redirect to login page -->    
        <c:if test="${ empty sessionScope.login}" >
            <c:redirect url="signin.jsp"></c:redirect>
        </c:if>
        
        <hr><br><a href="/poco_team-war/creeequipe.jsp" >Creer equipe</a><hr><br>
        <a href="/poco_team-war/integrerequipe.jsp" >Integrer equipe</a><hr><br>
        
        <!-- display owned teams -->
        <h5>Owned Teams</h5><hr><br>
        <c:import url="/OwnedTeamServ"/><br><hr>
        
        
        <!-- display Integrated teams -->
        <hr><h5>Integrated Teams</h5><hr><br>
        <c:import url="/IntegratedTeamServ"/><br><hr>
        
        
            
        <!-- to unset session -->
       <form action="/poco_team-war/Logout">
            <input type="submit" value="Logout" />
        </form>
        
            
            
    </body>
</html>
