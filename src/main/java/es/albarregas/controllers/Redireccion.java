/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

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
@WebServlet(name = "Redireccion", urlPatterns = {"/Redireccion"})
public class Redireccion extends HttpServlet {

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
        
        if(request.getParameter("menuInicial")!=null){
            url="index.jsp";
        }
        
        if(request.getParameter("menuPaginaInicial")!=null){
            url="JSP/usuariosNormales/paginaInicial.jsp";
        }
        
        if(request.getParameter("cancelarCrear")!=null){
            url="JSP/Admin/crear/opcionesCreate.jsp";
        }
        
        if(request.getParameter("menuListados")!=null){
            url="JSP/Admin/visualizar/opcionesListar.jsp";
        }
        
          if(request.getParameter("menuEliminar")!=null){
            url="JSP/Admin/eliminar/opcionesEliminar.jsp";
        }
        
         if(request.getParameter("menuAdmin")!=null){
            url="JSP/Admin/opcionesAdmin.jsp";
        }
          
        if(request.getParameter("menuCarrito") !=null){
            url="JSP/usuariosNormales/paginaInicial.jsp";
        }
         
       
        if(request.getParameter("menuHotelActividad")!=null){
            url="JSP/usuariosNormales/paginaInicial.jsp";
        }
        
        if(request.getParameter("cerrarSesion")!=null){
            url="index.jsp";
        }
        /**
         * switch (request.getParameter("boton").charAt(0)) {

            case 'R':
                url = "JSP/Admin/opcionesAdmin.jsp";
                break;

        }*/

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
