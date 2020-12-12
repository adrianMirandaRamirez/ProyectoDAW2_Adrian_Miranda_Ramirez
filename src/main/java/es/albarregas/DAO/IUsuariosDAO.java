/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.beans.Usuario;
import java.util.List;

/**
 *
 * @author adrian
 */
public interface IUsuariosDAO {
    
    public List<Usuario> getUsuarios();
    
    public void nuevoUsuario(Usuario usuario);
    
    public Usuario getDatosUsuario(String correo);
    
    public boolean buscarEmailUsuario(String email);
     
    public boolean comprobacionDeUsuario(Usuario usuario); 
     
      public void closeConnection();
}
