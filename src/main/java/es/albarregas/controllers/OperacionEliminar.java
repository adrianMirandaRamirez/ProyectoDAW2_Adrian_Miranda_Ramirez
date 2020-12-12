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
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "OperacionEliminar", urlPatterns = {"/OperacionEliminar"})
public class OperacionEliminar extends HttpServlet {

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
        
        IHotelesDAO hotelesDAO=daof.getHotelesDAO();
        IActividadesDAO actividadesDAO=daof.getActividadesDAO();
        IReservasDAO reservasDAO = daof.getReservasDAO();
        
        StringBuilder mensaje = new StringBuilder();
        HttpSession miSesion=request.getSession();
        
        List<Hotel> hoteles=new ArrayList<>();
        Hotel hotel=null;
        String[] hotelesSeleccionados=null;
        
        
        List<Actividad> actividades=new ArrayList<>();
        Actividad actividad=null;
        String[] actividadesSeleccionados=null;
        
        
        
        List<Reservas> reservas = new ArrayList<>();
        Reservas reserva = null; 
        String[] reservasSeleccionados=null;
        /**
         * Esta parte seria la parte de eliminar un hotel
         */
        if(request.getParameter("elimHotel")!=null){
            hotelesSeleccionados=request.getParameterValues("hotel");
            
            /**
             * Comprobamos si hay seleccionado algun hotel
             */
            if(hotelesSeleccionados!=null && hotelesSeleccionados.length !=0){
                for(int i=0; i < hotelesSeleccionados.length; i++){
                    hotel=hotelesDAO.getDatosHotel(hotelesSeleccionados[i]);
                    hoteles.add(hotel);
                }
                
                request.setAttribute("hoteles", hoteles);
                miSesion.setAttribute("idsHoteles", hotelesSeleccionados);
                url="JSP/Admin/eliminar/infoHotelEliminacion.jsp";
                
            }else{
                mensaje.append("No has seleccionado ningun hotel");
                url="JSP/Admin/eliminar/eliminarHoteles.jsp";
                request.setAttribute("mensaje", mensaje);
            }
            
        }
        
        if(request.getParameter("eliminarH")!=null){
            hotelesDAO.eliminarHotel((String[]) miSesion.getAttribute("idsHoteles"));
            mensaje.append("Se ha realizado con exito su consulta");
            url="JSP/Admin/eliminar/resultadoEliminacion.jsp";
            request.setAttribute("mensaje", mensaje);
        }
        
        
        /**
         * Esta parte seria la parte que explica como eliminar una actividad
         */
        
        if(request.getParameter("elimActiv") !=null){
            actividadesSeleccionados=request.getParameterValues("actividad");
            
            /**
             * Comprobamos si el usuario ha seleccionado alguna actividad
             */
            
            if(actividadesSeleccionados !=null && actividadesSeleccionados.length !=0){
                
                for(int i=0; i < actividadesSeleccionados.length; i++){
                    actividad=actividadesDAO.getDatosActividad(actividadesSeleccionados[i]);
                    actividades.add(actividad);
                    
                }
                
                request.setAttribute("actividades", actividades);
                miSesion.setAttribute("idsActividades", actividadesSeleccionados);
                url="JSP/Admin/eliminar/infoActivEliminacion.jsp";
            }else{
                mensaje.append("No has seleccionado ninguna actividad");
                url="JSP/Admin/eliminar/eliminarActividades.jsp";
                request.setAttribute("mensaje", mensaje);
            }
        }
        
        
        if(request.getParameter("eliminarA")!=null){
            actividadesDAO.eliminarActividad((String[]) miSesion.getAttribute("idsActividades"));
            mensaje.append("Se ha realizado con exito su consulta");
            url="JSP/Admin/eliminar/resultadoEliminacion.jsp";
            request.setAttribute("mensaje", mensaje);
        
        }
        
        
         
        /**
         * Esta parte seria la parte que explica como eliminar una reserva
         */
        
         if(request.getParameter("elimReserva") != null){
             reservasSeleccionados = request.getParameterValues("reserva");
             
             
             if(reservasSeleccionados!=null && reservasSeleccionados.length !=0){
                for(int i=0; i < reservasSeleccionados.length; i++){
                    reserva=reservasDAO.getDatosReserva(reservasSeleccionados[i]);
                    reservas.add(reserva);
                }
                
                request.setAttribute("reservas", reservas);
                miSesion.setAttribute("idsReservas", reservasSeleccionados);
                url="JSP/Admin/eliminar/infoReserEliminacion.jsp";
                
            }else{
                mensaje.append("No has seleccionado ninguna reserva");
                url="JSP/Admin/eliminar/eliminarReserva.jsp";
                request.setAttribute("mensaje", mensaje);
            }
         }
         
            if(request.getParameter("eliminarR")!=null){
            //actividadesDAO.eliminarActividad((String[]) miSesion.getAttribute("idsActividades"));
            reservasDAO.eliminarReserva((String[]) miSesion.getAttribute("idsReservas"));
            mensaje.append("Se ha realizado con exito su consulta");
            url="JSP/Admin/eliminar/resultadoEliminacion.jsp";
            request.setAttribute("mensaje", mensaje);
        
        }
        
        
        
        if(request.getParameter("cancelar") !=null){
            url="JSP/Admin/eliminar/opcionesEliminar.jsp";
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
