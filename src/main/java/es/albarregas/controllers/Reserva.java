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
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adrian
 */
@WebServlet(name = "Reserva", urlPatterns = {"/Reserva"})
public class Reserva extends HttpServlet {

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
        IReservasDAO reservasDAO = daof.getReservasDAO();
        IHotelesDAO hotelesDAO = daof.getHotelesDAO();
        IActividadesDAO actividadesDAO = daof.getActividadesDAO();
        Reservas reservas = new Reservas();
        Hotel hotel = new Hotel();
        Actividad actividad = new Actividad();
        String idHotel="";
        String idActividad="";
       
        
        
        if(request.getParameter("reservarHotel")!=null){
            idHotel = request.getParameter("idHotel");
            hotel = hotelesDAO.getDatosHotel(idHotel);
            reservas.setIdHotel(hotel);                      
            reservas.setFechaReserva(Date.valueOf(request.getParameter("fecha")));
            reservas.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
            
            
        }else if(request.getParameter("reservarActiv")!=null){
            idActividad = request.getParameter("idActividad");
            actividad = actividadesDAO.getDatosActividad(idActividad);
            reservas.setIdActividad(actividad);        
            System.out.println(actividad.getFecha());
            reservas.setFechaReserva(actividad.getFecha());
            reservas.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
            //request.getParameter("fecha")
        }
        
        reservasDAO.nuevaReserva(reservas);
        url="JSP/usuariosNormales/paginaInicial.jsp";
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
