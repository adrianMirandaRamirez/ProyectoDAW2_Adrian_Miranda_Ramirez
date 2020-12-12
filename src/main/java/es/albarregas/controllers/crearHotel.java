/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.DAO.IHotelesDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Hotel;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "crearHotel", urlPatterns = {"/crearHotel"})
public class crearHotel extends HttpServlet {

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
        IHotelesDAO hotelDAO = daof.getHotelesDAO();
        HttpSession miSesion = request.getSession(true);
        
        if (request.getParameter("boton") != null) {

            switch (request.getParameter("boton").charAt(0)) {

                case '1':
                    url = "JSP/Admin/crear/nuevoHotel.jsp";
                    break;

                case '2':
                    url = "JSP/Admin/crear/nuevaActividad.jsp";
                    break;

                case '3':
                    url = "JSP/Admin/opcionesAdmin.jsp";
                    break;
            }

        } else {
            Hotel hotel = new Hotel();
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            //Crear una pagina jsp donde se muestre la informacion del hotel que se ha creado

            List<FileItem> items = null;
            try {
                items = upload.parseRequest(request);
            } catch (FileUploadException ex) {
                System.out.println("Error al obtener los campos del formulario");
            }

            for (FileItem item : items) {
                if (item.isFormField()) {

                    switch (item.getFieldName()) {

                        case "nombreH":
                            hotel.setNombreHotel(item.getString("UTF-8"));
                            break;

                        case "lugar":
                            hotel.setLugar(item.getString("UTF-8"));
                            break;

                        case "telefono":
                            hotel.setTelefono(Integer.parseInt(item.getString("UTF-8")));
                            break;

                        case "correo":
                            hotel.setCorreo(item.getString("UTF-8"));
                            break;

                        case "precio":
                            hotel.setPrecio(Double.parseDouble(item.getString("UTF-8")));
                            break;

                    }

                } else {
                    if (item.getContentType().equals("image/png") || item.getContentType().equals("image/jpeg")) {

                        String dirImagen = request.getServletContext().getRealPath("/Imagenes/hoteles/");
                        String filePath = dirImagen + item.getName();
                        File fichero = new File(filePath);

                        try {

                            item.write(fichero);
                            hotel.setFotoHotel(item.getName());
                            url = "JSP/Admin/crear/infoHotel.jsp";
                            miSesion.setAttribute("hotel", hotel);
                        } catch (Exception ex) {
                            System.out.println("Error al escribir el fichero en el disco");
                            ex.printStackTrace();
                        }

                    } else {
                        url = "JSP/Admin/crear/infoHotel.jsp";
                        miSesion.setAttribute("hotel", hotel);
                    }

                }
            }

            //hotelDAO.nuevoHotel(hotel);
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
