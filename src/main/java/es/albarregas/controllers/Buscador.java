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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adrian
 */
@WebServlet(name = "Buscador", urlPatterns = {"/Buscador"})
public class Buscador extends HttpServlet {

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
        IHotelesDAO hotelesDAO = daof.getHotelesDAO();
        IActividadesDAO actividadesDAO = daof.getActividadesDAO();
        List<Hotel> hoteles = null;
        List<Actividad> actividades = null;
        String destino="";
        StringBuilder mensajeHotel=new StringBuilder();
        StringBuilder mensajeActividad=new StringBuilder();

        
        
            if(request.getParameter("destino").equals("")){
                
            }else{
                destino=request.getParameter("destino");
                hoteles=hotelesDAO.getHotelesPorLugar(destino);
                actividades=actividadesDAO.getActividadesPorLugar(destino);
                
                if(!hoteles.isEmpty()){
                    request.setAttribute("hoteles", hoteles);
                }else{
                    mensajeHotel.append("No hay datos de ningun hotel en el destino que ha escrito");
                }
                
                if(!actividades.isEmpty()){
                    request.setAttribute("actividades", actividades);
                }else{
                   mensajeActividad.append("No hay datos de ninguna actividad en el destino que ha escrito");
                   
                }
                request.setAttribute("mensajeHotel", mensajeHotel);
                request.setAttribute("mensajeActividad", mensajeActividad);
                           
            }
            
            if(request.getParameter("buscar")!=null){
                url="JSP/usuariosNormales/Buscador.jsp"; 
            }else{
                url="JSP/usuariosNormales/buscadorPagInicial.jsp";
            }
        
        
            
            if(request.getParameter("buscarHot")!=null){
                url= "JSP/usuariosNormales/Hoteles.jsp";
            }else if (request.getParameter("buscarAct")!=null){
                url = "JSP/usuariosNormales/Actividades.jsp";
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
