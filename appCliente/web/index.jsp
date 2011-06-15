<%-- 
    Document   : index
    Created on : 12/06/2011, 03:01:18 PM
    Author     : Gustavo Leites
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/cssLayout.css" rel="stylesheet" type="text/css"/>
        <title>Aplicación Cliente</title>
    </head>
    <body>
        <div id="head">
           <h4>Bienvenido al Aplicativo de Clientes</h4>
           <h4>Usuario: <%=request.getRemoteUser() %></h4>
        </div>
        <div id="central">
            <a href="verProveedores" id="link2">Consultar proveedores</a><br/>
        </div>
        <br/>
        <div id="foot">
            
            Arquitectura de Software
        </div>
    </body>
</html>
