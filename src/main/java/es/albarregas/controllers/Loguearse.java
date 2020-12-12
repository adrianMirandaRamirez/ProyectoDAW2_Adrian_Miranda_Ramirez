/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.DAO.IUsuariosDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Usuario;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Loguearse", urlPatterns = {"/Loguearse"})
public class Loguearse extends HttpServlet {

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
            throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
        response.setContentType("text/html;charset=UTF-8");

        String url = "";
        Usuario usuario=new Usuario();
        DAOFactory daof=DAOFactory.getDAOFactory(1);
        IUsuariosDAO usuarioDAO=daof.getUsuariosDAO();        
        boolean encontrado=false;
        HttpSession miSesion=request.getSession(false);

        if (request.getParameter("login") != null) {
            switch (request.getParameter("login").charAt(0)) {

                case 'R':
                    url = "JSP/login/Registrarse.jsp";
                    break;

                case 'I':
                    url = "JSP/login/iniciarSesion.jsp";
                    break;

            }
            
        }else if(request.getParameter("iniciarSesion")!=null){
            usuario.setCorreo(request.getParameter("correo"));
            usuario.setContrasenia(request.getParameter("contrasenia"));
            
            encontrado=usuarioDAO.comprobacionDeUsuario(usuario);
            
            if(encontrado){
                if(request.getParameter("correo").equals("adrian@gmail.com") && request.getParameter("contrasenia").equals("123")){
                    url="JSP/Admin/opcionesAdmin.jsp";
                }else{
                     usuario=usuarioDAO.getDatosUsuario(request.getParameter("correo")); 
                     miSesion.setAttribute("usuario", usuario);
                     url="JSP/usuariosNormales/paginaInicial.jsp";
                }
               
            }else{
                url="JSP/login/iniciarSesion.jsp";
            }
            
        }
        
        if(request.getParameter("cancelar")!=null){
            url="index.jsp";
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
        try {
            processRequest(request, response);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Loguearse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Loguearse.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Loguearse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Loguearse.class.getName()).log(Level.SEVERE, null, ex);
        }
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
