<%-- 
    Document   : SuccesQueryProveedores
    Created on : 13/06/2011, 10:06:50 AM
    Author     : Gustavo Leites
--%>

<%@page import="objVirtual.Proveedor"%>
<%@page import="java.util.List"%>
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
            <h4>Proveedores Disponibles</h4>
            <h4>Ususario: <%=request.getRemoteUser() %></h4>
        </div>
        <div id="central">

            <h4>Lista de Proveedores Disponibles</h4>
            <table border="1" width="900px" >
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Dirección</th>
                    <th>Teléfono</th>
                    <th>Servicios</th>
                </tr>
                <%
                   List<Proveedor> listProveedores = (List<Proveedor>)request.getAttribute("listProveedores");
                   if(listProveedores.size() > 0){
                        for(Proveedor prov : listProveedores){

                %>
                <tr>
                    <td align="center"><%=prov.getId() %></td>
                    <td align="center"><%=prov.getNombre() %></td>
                    <td align="center"><%=prov.getDireccion() %></td>
                    <td align="center"><%=prov.getTelefono() %></td>
                    <td align="center">
                        <form id="buscarForm" action="buscarServicios" method="get">
                            <input id="action" type="hidden" value="edit" name="action"/>
                            <input id="idContacto" value="<%=prov.getId()%>" type="hidden" name="idProv"/>
                            <button type="submit">Servicios</button>
                        </form>
                    </td>
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
