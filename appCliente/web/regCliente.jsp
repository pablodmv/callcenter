<%-- 
    Document   : regCliente
    Created on : 12/06/2011, 03:25:19 PM
    Author     : Gustavo Leites
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/cssLayout.css" rel="stylesheet" type="text/css"/>
        <title>Applicación Cliente</title>
    </head>
    <body>
        <div id="head">
            <h4>Registro de Cliente</h4>
        </div>
        <div id="central">
            <form action="regCliente" method="POST">
                <table>
                    <tr>
                        <td><label id="lblnombre" for="nombre">Nombre:</label></td>
                        <td><input id="nombre" type="text" name="nombre"><br/></td>
                    </tr>
                    <tr>
                        <td><label id="lbldir" for="direccion">Dirección:</label></td>
                        <td><input id="direccion" type="text" name="direccion"><br/></td>
                    </tr>
                    <tr>
                        <td><label id="lbltel" for="tel">Teléfono:</label></td>
                        <td><input id="tel" type="text" name="tel"><br/><br/></td>
                    </tr>
                    <tr>
                        <td><label id="lblusuario" for="usr">Usuario:</label></td>
                        <td><input id="usr" type="text" name="usr"></td>
                    </tr>
                    <tr>
                        <td><label id="lblpwd" for="pwd">Contraseña:</label></td>
                        <td><input id="pwd" type="password" name="pwd"></td>
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
