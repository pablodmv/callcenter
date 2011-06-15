<%-- 
    Document   : index
    Created on : 05/06/2011, 10:38:11 PM
    Author     : pablo
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
            <h4>Bienvenido al Aplicativo de Proveedores</h4>
            <h4>Ususario: <%=request.getRemoteUser() %></h4>
        </div>
        
        <div id="central">
            <a href="regServicio.jsp" id="link1">Ingresar a registro de servicios</a><br/>
            <a href="verPedidos" id="link2">Ingresar a consulta de pedidos</a><br/>
             <a href="verServicios" id="link2">Ingresar a consulta de Servicios ingresados</a><br/>
        </div>
        <div id="foot">
            <br/>
            Arquitectura de Software
        </div>
        
    </body>
</html>
