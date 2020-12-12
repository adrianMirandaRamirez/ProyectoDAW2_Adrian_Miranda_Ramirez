/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Usuario;
import es.albarregas.models.Sentencias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author adrian
 */
public class MySQLUsuariosDAO implements IUsuariosDAO{

    @Override
    public List<Usuario> getUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nuevoUsuario(Usuario usuario) {
        Sentencias sentenciasSql= new Sentencias();
        String sql = sentenciasSql.nuevoUsuario();
        ConnectionFactory obtener= new ConnectionFactory();
        PreparedStatement sentenciaPreparada = null;
         
         try{
             Connection conexion=obtener.obtenerConexionMySQL();
             sentenciaPreparada=conexion.prepareStatement(sql);
             
             sentenciaPreparada.setString(1, usuario.getNombre());
             sentenciaPreparada.setString(2, usuario.getApellidos());
             sentenciaPreparada.setString(3, usuario.getCorreo());
             sentenciaPreparada.setString(4, usuario.getContrasenia());
             sentenciaPreparada.setString(5, usuario.getNif());
             sentenciaPreparada.setInt(6, usuario.getTelefono());
             
             sentenciaPreparada.executeUpdate();
             
         }catch(SQLException ex){
             System.out.println("Error al ejecutar la sentecia o al obtener la conexion");
             ex.printStackTrace();
             
         }finally{
             this.closeConnection();
         }
        
    }

    
    /**
     * Este metodo sirve para poder saber si el correo que ha introducido el usuario al intentar registrarse en la pagina
     * ya se encuentra en la base de datos.
     * @param email
     * @return 
     */
    @Override
    public boolean buscarEmailUsuario(String email) {
        boolean encontrado=false;
        
        
        Sentencias sentenciaSQL = new Sentencias();
                       
        String sql = sentenciaSQL.obtenerEmailsUsuarios();
        ConnectionFactory obtener = new ConnectionFactory();

        try {
            Connection conexion = obtener.obtenerConexionMySQL();
            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
               
                if(email.equals(resultado.getString("correo"))){
                    encontrado=true;
                    break;
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error");
        }finally {
            this.closeConnection();
        }
        
        return encontrado;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConexion();
    }

    /**
     * La funcion de este metodo sera comprobar que el correo y la contraseña que el usuario ha introducio al intentar iniciar sesión se encuentra
     * en la base de datos. 
     * @param usuario
     * @return 
     */
    @Override
    public boolean comprobacionDeUsuario(Usuario usuario) {
        Sentencias sentenciasSQL = new Sentencias();
        DAOFactory daof = DAOFactory.getDAOFactory(1);
        IUsuariosDAO usuariosDAO= daof.getUsuariosDAO();
        boolean encontrado=false;
        
        String sql=sentenciasSQL.obtenerCorreosYContrasenias();
        ConnectionFactory obtener = new ConnectionFactory();

        try{
            
            Connection conexion = obtener.obtenerConexionMySQL();
            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery(sql);
            
            while(resultado.next()){
               if(usuario.getCorreo().equals(resultado.getString("correo")) && usuario.getContrasenia().equals(resultado.getString("contrasenia"))){
                   encontrado=true;
                   break;
               }else{
                   
               }
            }

        }catch (SQLException ex) {
            System.out.println("Error");
        }finally {
            this.closeConnection();
        }
        
        return encontrado;
    }

    @Override
    public Usuario getDatosUsuario(String correo) {
        Usuario usuario = null;
        
        Sentencias sentenciasSql=new Sentencias();
        String sql=sentenciasSql.obtenerDatosUsuarioPorCorreo();
        ConnectionFactory obtener = new ConnectionFactory();
        
        try{
            Connection conexion = obtener.obtenerConexionMySQL();
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(sql);

            sentenciaPreparada.setString(1, correo);
             ResultSet resultado=sentenciaPreparada.executeQuery();

             while(resultado.next()){
                 usuario=new Usuario();
                 usuario.setIdUsuario(resultado.getInt("idUsuario"));
                 usuario.setNombre(resultado.getString("nombre"));
                 usuario.setApellidos(resultado.getString("apellidos"));
                 usuario.setCorreo(resultado.getString("correo"));
                 usuario.setContrasenia(resultado.getString("contrasenia"));
                 usuario.setNif(resultado.getString("nif"));
                 usuario.setTelefono(resultado.getInt("telefono"));
                 
             }
            
            
        }catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentecia");
        } finally {
            this.closeConnection();
        }

        return usuario;
    }
    
}
