<%-- 
    Document   : creeequipe
    Created on : 9 nov. 2021, 21:40:29
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
       
        <h1>creer equipe</h1>
        <form name="form"  action ="/poco_team-war/CreerEquipe" method="post" enctype="multipart/form-data">
            Nom : <input type="text" name="nom" required><br>
            <input type="text" name="code" hidden><br>
            Icon : <input type="file" id="image" name="image" accept="image/jpeg" required><br>
            <input type="submit" value="creer" >
        </form>
         <script>
              function makeid(length) {
                    var result           = '';
                    var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
                    var charactersLength = characters.length;
                    for ( var i = 0; i < length; i++ ) {
                      result += characters.charAt(Math.floor(Math.random() * 
                 charactersLength));
                   }
                   return result;
                }
            document.forms["form"]["code"].value=makeid(6);
        </script>
    </body>
</html>
