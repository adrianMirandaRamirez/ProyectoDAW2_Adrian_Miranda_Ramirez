/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.DAO.IActividadesDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Actividad;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author adrian
 */
@WebServlet(name = "crearActividad", urlPatterns = {"/crearActividad"})
public class crearActividad extends HttpServlet {

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
        IActividadesDAO actividadDAO=daof.getActividadesDAO();
        
        Actividad actividad=new Actividad();
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        HttpSession miSesion = request.getSession(true);
        
         List<FileItem>items=null;
            try{
                items=upload.parseRequest(request);
            }catch(FileUploadException ex){
                System.out.println("Error al obtener los campos del formulario");
            }
            
            
            for(FileItem item:items){
                if(item.isFormField()){
                    
                        switch(item.getFieldName()){
                            
                            case "nombreA":
                                actividad.setNombreActiv(item.getString("UTF-8"));
                                break;
                                
                            case "descripcion":
                                actividad.setDescripcion(item.getString("UTF-8"));
                                break;
                                
                            case "telefono":
                                actividad.setTelefono(Integer.parseInt(item.getString("UTF-8")));
                                break;
                                
                            case "lugar":
                                 actividad.setLugar(item.getString("UTF-8"));
                                 break;
                                 
                            case "precio":
                                actividad.setPrecio(Double.parseDouble(item.getString("UTF-8")));
                                break;
                                
                            case "correo":
                                actividad.setCorreo(item.getString("UTF-8"));
                                break;
                                
                            case "fecha":
                                 actividad.setFecha(Date.valueOf(item.getString("UTF-8")));
                                 break;
                                 
                           
                             
                        }
                        
                }else{
                    if(item.getContentType().equals("image/png") || item.getContentType().equals("image/jpeg")){
                        
                            String dirImagen=request.getServletContext().getRealPath("/Imagenes/actividades/");
                            String filePath=dirImagen+item.getName();
                            File fichero=new File(filePath);
                            
                            try{
                                
                                item.write(fichero);
                                actividad.setFotoActiv(item.getName());
                                
                            }catch (Exception ex) {
                                System.out.println("Error al escribir el fichero en el disco");
                                ex.printStackTrace();
                            }
                            
                        
                        
                    }else{
                        
                    }
                    
                }
            }
            
            
            
            url = "JSP/Admin/crear/infoActividad.jsp";
            miSesion.setAttribute("actividad", actividad);
            //actividadDAO.nuevaActividad(actividad);
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
