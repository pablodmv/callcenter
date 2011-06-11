<%-- 
    Document   : successSaveServicio
    Created on : 10/06/2011, 11:01:54 AM
    Author     : Gustavo Leites
--%>

<%@page import="java.util.List"%>
<%@page import="objVirtual.Servicio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.appProveedor.services.ServicioServices"%>
<%@page import="objVirtual.Proveedor"%>
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
            <h4>Servicio guardado con exito</h4>
            <h4>Ususario: <%=request.getRemoteUser() %></h4>
        </div>
        <div id="central">
            <%
               Proveedor prov =  (Proveedor)request.getAttribute("prov");
            %>
            <h4>Lista de Servicios Proveedor: <%=prov.getNombre()%></h4>
            <table border="1" width="400px" >
                <tr>
                    <th>Id</th>
                    <th>Descripción</th>
                    <th>Costo</th>
                    <th>Estado</th>
                </tr>
                <% 
                   List<Servicio> listServ = ServicioServices.obtenerServiciosPorProveedor(prov);   
                   if(listServ.size() > 0){
                        for(Servicio serv : listServ){

                %>
                <tr>
                    <td><%=serv.getId() %></td>
                    <td><%=serv.getDescripcion() %></td>
                    <td><%=serv.getCosto() %></td>
                    <%
                       if(serv.isEstado()){
                    %>
                        <td>Activo</td>
                    <% }else{ %>
                        <td>Inactivo</td>
                    <% }%>
                </tr>


                        <%}%>
                <%}%>
            </table>
            <br/>
            <br/>
            <a href='regServicio.jsp' id='link1'>Volver</a><br/>
        </div>
        <div id="foot">
            <br/>
            Arquitectura de Software
        </div>
    </body>

</html>
