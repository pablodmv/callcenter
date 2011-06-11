/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appProveedor.servlet;

import com.appProveedor.persistencia.PersistentBroker;
import com.appProveedor.services.ProveedorServices;
import com.appProveedor.services.ServicioServices;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objVirtual.Proveedor;
import objVirtual.Servicio;

/**
 *
 * @author pablo
 */
public class regServicio extends HttpServlet {
   
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

            String descServicio = request.getParameter("servicio");
            String costoStr = request.getParameter("costo");

            //out.println(descServicio + "-" + costoStr + request.getRemoteUser());
            Double costo = Double.parseDouble(costoStr);

            if(!descServicio.equals("")){

                Proveedor prov = ProveedorServices.obtenerProveedor(request.getRemoteUser());
                //out.println(prov.getNombre());

                Servicio serv = new Servicio();
                serv.setDescripcion(descServicio);
                serv.setCosto(costo);
                serv.setEstado(true);
                serv.setIdProveedor(prov.getId());

                ServicioServices.salvarServicio(serv);
                request.setAttribute("prov", prov);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/successSaveServicio.jsp");
                dispatcher.forward(request, response);
            }else{
                response.sendRedirect("dataError.jsp");
            }


        }catch(NumberFormatException nFEx){
            response.sendRedirect("dataError.jsp");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Error al registrar el servicio</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Se produjo un error al registrar el servicio</h2>");
            out.println("<h4>Intentelo mas tarde</h4>");
            out.println("<a href='regServicio.jsp' id='link1'>Volver</a><br/>");
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
