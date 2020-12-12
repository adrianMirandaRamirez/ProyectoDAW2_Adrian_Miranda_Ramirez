/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.DAO.IActividadesDAO;
import es.albarregas.DAO.IHotelesDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Actividad;
import es.albarregas.beans.Hotel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adrian
 */
@WebServlet(name = "OperacionActualizar", urlPatterns = {"/OperacionActualizar"})
public class OperacionActualizar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        String url="";
        DAOFactory daof = DAOFactory.getDAOFactory(1);
        String idHotel="";
        String idActividad="";
        IActividadesDAO actividadeDAO=daof.getActividadesDAO();
        IHotelesDAO hotelesDAO=daof.getHotelesDAO();
        
        Actividad actividad=new Actividad();
        Hotel hotel=new Hotel();
        StringBuilder mensaje = new StringBuilder();
        
        if(request.getParameter("cancelar")!=null){
            url="JSP/Admin/modificar/opcionesUpdate.jsp";
        }
        
        if(request.getParameter("modHotel")!=null){
            idHotel=request.getParameter("hotel");
            
            
            if(idHotel==null){
                mensaje.append("No has seleccionado ningun hotel");
                url="JSP/Admin/modificar/actualizarHotel.jsp";
                request.setAttribute("mensaje", mensaje);
                
            }else{
                url="JSP/Admin/modificar/modificarHotel.jsp";
                hotel=hotelesDAO.getDatosHotel(idHotel);
                request.setAttribute("hotel", hotel);
            }
        }
        
        
        if(request.getParameter("modActiv")!=null){
            idActividad=request.getParameter("actividad");
            
            if(idActividad==null){
                mensaje.append("No has seleccionado ninguna actividad");
                url="JSP/Admin/modificar/actualizarActividad.jsp";
                request.setAttribute("mensaje", mensaje);
            }else{
                url="JSP/Admin/modificar/modificarActividad.jsp";
                actividad=actividadeDAO.getDatosActividad(idActividad);
                request.setAttribute("actividad", actividad);
            }
        }
        
       request.getRequestDispatcher(url).forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
