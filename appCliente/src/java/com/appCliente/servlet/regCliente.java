/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appCliente.servlet;

import com.appCliente.services.ClienteServices;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objVirtual.Cliente;
import objVirtual.Credenciales;

/**
 *
 * @author Gustavo Leites
 */
@WebServlet(name="regCliente", urlPatterns={"/regCliente"})
public class regCliente extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String nombre = request.getParameter("nombre");
            String dir = request.getParameter("direccion");
            String tel = request.getParameter("tel");
            String usr = request.getParameter("usr");
            String pwd = request.getParameter("pwd");


            if(!nombre.equals("") && !dir.equals("") && !tel.equals("") && !usr.equals("") && !pwd.equals("")){
                
                Cliente cliente = new Cliente();
                cliente.setNombre(nombre);
                cliente.setDireccion(dir);
                cliente.setTelefono(tel);

                Credenciales cred = new Credenciales();
                cred.setLogin(usr);
                cred.setPwd(pwd);
                cred.setRol("Clientes");
                cred = ClienteServices.salvarCredencial(cred);

                cliente.setCredenciales(cred);
                
                ClienteServices.salvarCliente(cliente);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/successSaveCliente.jsp");
                dispatcher.forward(request, response);

            }else{
                response.sendRedirect("dataError.jsp");
            }


        }catch(Exception ex){

            System.out.println(ex.getMessage());
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error al registrar el cliente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Se produjo un error al registrar el cliente</h2>");
            out.println("<h4>Intentelo mas tarde</h4>");
            out.println("<a href='regCliente.jsp' id='link1'>Volver</a><br/>");
            out.println("</body>");
            out.println("</html>");

        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
