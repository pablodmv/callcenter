<%-- 
    Document   : successSaveServicio
    Created on : 10/06/2011, 11:01:54 AM
    Author     : Gustavo Leites
--%>

<%@page import="objVirtual.Cliente"%>
<%@page import="com.appProveedor.services.ClienteServices"%>
<%@page import="objVirtual.Pedido"%>
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
            <h4>Pedidos pendientes</h4>
            <h4>Ususario: <%=request.getRemoteUser() %></h4>
        </div>
        <div id="central">
            
            <h4>Lista de Pedidos Pendientes</h4>
            <table border="1" width="900px" >
                <tr>
                    <th>Id</th>
                    <th>Nom.Cliente</th>
                    <th>Tel.Cliente</th>
                    <th>Pedido</th>
                    <th>Estado</th>
                    <th>Acción</th>
                </tr>
                <% 
                   List<Pedido> listPedidos = (List<Pedido>)request.getAttribute("listPedido");
                   if(listPedidos.size() > 0){
                        for(Pedido p : listPedidos){

                            Cliente cli = ClienteServices.obtenerClienteByPedido(p);

                %>
                <tr>
                    <td align="center"><%=p.getId() %></td>
                    <td align="center"><%=cli.getNombre() %></td>
                    <td align="center"><%=cli.getTelefono() %></td>
                    <td><%=p.getMensaje() %></td>
                    <%
                       if(p.isEstado()){
                    %>
                        <td align="center">Activo</td>
                    <% }else{ %>
                        <td align="center">Inactivo</td>
                    <% }%>

                    <td align="center">
                        <form id="buscarForm" action="terminarPedido" method="get">
                            <input id="action" type="hidden" value="edit" name="action"/>
                            <input id="idContacto" value="<%=p.getId()%>" type="hidden" name="idPedido"/>
                            <button type="submit">Entregar</button>
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
