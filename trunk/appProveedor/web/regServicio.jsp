<%-- 
    Document   : regServicio
    Created on : 09/06/2011, 02:08:33 PM
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
        <div id="head">
            <h4>Registro de Servicios</h4>
            <h4>Ususario: <%=request.getRemoteUser() %></h4>
        </div>
        <div id="central">
            <form action="regServicio" method="POST">
                <table>
                    <tr>
                        <td><label id="lblservicio" for="servicio">Servicio:</label></td>
                        <td><input id="servicio" type="text" name="servicio"><br/></td>
                    </tr>
                    <tr>
                        <td><label id="lblcosto" for="costo">Costo:</label></td>
                        <td><input id="costo" type="text" name="costo"><br/><br/></td>
                    </tr>
                    <tr><td><input type="submit" value="Enviar" name="enviar" /></td></tr>
                </table>
                
            </form>
        </div>
        <div id="foot">
            <br/>
            Arquitectura de Software
        </div>
    </body>
</html>
