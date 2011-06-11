<%-- 
    Document   : Login
    Created on : 27/11/2010, 06:59:54 PM
    Author     : Gustavo Leites
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/cssLayout.css" rel="stylesheet" type="text/css"/>
        <title>Aplicación Proveedor</title>
    </head>
    <body>
        <div id="central">
            <h3>Login</h3>
             <form action="j_security_check" method="POST">
                 <table>
                     <tr>
                         <td>Usuario:</td>
                         <td><input type="text" name="j_username"></td>
                     </tr>
                     <tr>
                         <td>Contrase&ntilde;a: </td>
                         <td><input type="password" name="j_password"> </td>
                     </tr>
                     <tr>
                         <td><input type="submit" value="Ingresar"></td>
                     </tr>

                 </table>
            </form>
        </div>
        

    </body>
</html>
