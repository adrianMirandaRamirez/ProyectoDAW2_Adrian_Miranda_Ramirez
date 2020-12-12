/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.DAO.IActividadesDAO;
import es.albarregas.DAO.IHotelesDAO;
import es.albarregas.DAO.IReservasDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Actividad;
import es.albarregas.beans.Hotel;
import es.albarregas.beans.Reservas;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adrian
 */
@WebServlet(name = "OpcionesEliminar", urlPatterns = {"/OpcionEliminar"})
public class OpcionEliminar extends HttpServlet {

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
      
        String url = "";
        DAOFactory daof = DAOFactory.getDAOFactory(1);
        IHotelesDAO hotelesDAO = daof.getHotelesDAO();
        IActividadesDAO actividadesDAO = daof.getActividadesDAO();
        IReservasDAO reservasDAO = daof.getReservasDAO();
         HttpSession miSesion=request.getSession(false);
        List<Hotel> hoteles = null;
        List<Actividad> actividades = null;
        List<Reservas> reservas = null;

        switch (request.getParameter("boton").charAt(0)) {
            case '1':
                
                hoteles=hotelesDAO.getHoteles();
                if(!hoteles.isEmpty()){
                    miSesion.setAttribute("hoteles", hoteles);
                    url="JSP/Admin/eliminar/eliminarHoteles.jsp";
                }
                break;

            case '2':
                actividades=actividadesDAO.getActividades();
                if(!actividades.isEmpty()){
                    miSesion.setAttribute("actividades", actividades);
                    url="JSP/Admin/eliminar/eliminarActividades.jsp";
                }
                break;
                
                
            case '3':
                url="JSP/Admin/opcionesAdmin.jsp";
                break;
                
                
            case '4':
                reservas = reservasDAO.getReservas();
                if(!reservas.isEmpty()){
                    miSesion.setAttribute("reservas", reservas);
                    url="JSP/Admin/eliminar/eliminarReserva.jsp";
                }else{
                    
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
