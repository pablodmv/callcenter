/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appCliente.servlet;

import com.appCliente.services.ProveedorServices;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.Proveedor;

/**
 *
 * @author Gustavo Leites
 */
@WebServlet(name="verProveedores", urlPatterns={"/verProveedores"})
public class verProveedores extends HttpServlet {
   
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

            List<Proveedor> listaProveedores = ProveedorServices.obtenerTodosProveedores();

            request.setAttribute("listProveedores", listaProveedores);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/successQueryProveedores.jsp");
            dispatcher.forward(request, response);


        }catch(Exception ex){

            System.out.println(ex.getMessage());
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error al consultar los proveedores</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Se produjo un error en la consulta de proveedores</h2>");
            out.println("<h4>Intentelo mas tarde</h4>");
            out.println("<a href='index.jsp' id='link1'>Volver</a><br/>");
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
