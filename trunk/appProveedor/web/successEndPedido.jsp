<%-- 
    Document   : successSaveServicio
    Created on : 10/06/2011, 11:01:54 AM
    Author     : Gustavo Leites
--%>

<%@page import="java.util.List"%>
<%@page import="vo.Servicio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.appProveedor.services.ServicioServices"%>
<%@page import="vo.Proveedor"%>
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
            <h4>Pedido terminado con exito</h4>
            <h4>Ususario: <%=request.getRemoteUser() %></h4>
        </div>
        <div id="central">
            
            <a href='index.jsp' id='link1'>Volver</a><br/>
        </div>
        <div id="foot">
            <br/>
            Arquitectura de Software
        </div>
    </body>

</html>
