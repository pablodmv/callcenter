/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appProveedor.servlet;

import com.appProveedor.services.BusinessException;
import com.appProveedor.services.ProveedorServices;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.Proveedor;

/**
 *
 * @author pablo
 */
public class verServicios extends HttpServlet {
   
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
            try {
                /* TODO output your page here
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet verServicios</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet verServicios at " + request.getContextPath () + "</h1>");
                out.println("</body>");
                out.println("</html>");
                 */
                Proveedor prov = ProveedorServices.obtenerProveedor(request.getRemoteUser());
                request.setAttribute("prov", prov);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewServicio.jsp");
            dispatcher.forward(request, response);
            } catch (BusinessException ex) {
                Logger.getLogger(verServicios.class.getName()).log(Level.SEVERE, null, ex);
            }
             
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
