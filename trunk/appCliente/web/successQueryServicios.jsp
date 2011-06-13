<%-- 
    Document   : successQueryServicios
    Created on : 13/06/2011, 10:52:06 AM
    Author     : Gustavo Leites
--%>

<%@page import="objVirtual.Servicio"%>
<%@page import="java.util.List"%>
<%@page import="objVirtual.Proveedor"%>
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
            <h4>Servicios Disponibles</h4>
            <h4>Ususario: <%=request.getRemoteUser() %></h4>
        </div>
        <div id="central">
            <%
                Proveedor prov =(Proveedor)request.getAttribute("prov");
                String provNombre = prov.getNombre();
            %>

            <h4>Lista de Servicios de Proveedor: <%=provNombre %></h4>
            <table border="1" width="900px" >
                <tr>
                    <th>Id</th>
                    <th>Descripción</th>
                    <th>Costo</th>
                    <th>Estado</th>
                </tr>
                <%
                   List<Servicio> listServicios = (List<Servicio>)request.getAttribute("listServicios");
                   if(listServicios.size() > 0){
                        for(Servicio serv : listServicios){

                %>
                <tr>
                    <td align="center"><%=serv.getId() %></td>
                    <td align="center"><%=serv.getDescripcion() %></td>
                    <td align="center"><%=serv.getCosto() %></td>

                    <%
                       if(serv.isEstado()){
                    %>
                        <td align="center">Activo</td>
                    <% }else{ %>
                        <td align="center">Inactivo</td>
                    <% }%>
                </tr>


                        <%}%>
                <%}%>
            </table>
            <br/>
            <br/>
            <a href='index.jsp' id='link1'>Volver</a><br/>
        </div>
        <div id="foot">
            <br/>
            Arquitectura de Software
        </div>
    </body>
</html>
