/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.beans.Actividad;
import es.albarregas.models.Sentencias;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adrian
 */
public class MySQLActividadesDAO implements IActividadesDAO {

    @Override
    public List<Actividad> getActividades() {
        List<Actividad> listaActividades = new ArrayList<>();

        Sentencias sentenciasSql = new Sentencias();

        String sql = sentenciasSql.obtenerActividades();
        ConnectionFactory obtener = new ConnectionFactory();

        try {
            Connection conexion = obtener.obtenerConexionMySQL();
            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                Actividad actividad = new Actividad();

                actividad.setIdActividad(resultado.getInt("idActividad"));
                actividad.setNombreActiv(resultado.getString("nombreActiv"));
                actividad.setDescripcion(resultado.getString("descripcion"));
                actividad.setLugar(resultado.getString("lugar"));
                actividad.setTelefono(resultado.getInt("telefono"));
                actividad.setCorreo(resultado.getString("correo"));
                actividad.setPrecio(resultado.getDouble("precio"));
                actividad.setFecha(resultado.getDate("fecha"));
                actividad.setFotoActiv(resultado.getString("fotoActiv"));

                listaActividades.add(actividad);

            }

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentecia o al obtener la conexion");
        } finally {
            this.closeConnection();
        }

        return listaActividades;
    }

    @Override
    public void nuevaActividad(Actividad actividad) {
        Sentencias sentenciasSql = new Sentencias();
        String sql = sentenciasSql.nuevaActividad();
        ConnectionFactory obtener = new ConnectionFactory();
        PreparedStatement sentenciaPreparada = null;

        try {
            Connection conexion = obtener.obtenerConexionMySQL();

            if (actividad.getFotoActiv() == null) {
                sql = sentenciasSql.nuevaActividadSinFoto();
                sentenciaPreparada = conexion.prepareStatement(sql);
                sentenciaPreparada.setString(1, actividad.getNombreActiv());
                sentenciaPreparada.setString(2, actividad.getDescripcion());
                sentenciaPreparada.setString(3, actividad.getLugar());
                sentenciaPreparada.setInt(4, actividad.getTelefono());
                sentenciaPreparada.setString(5, actividad.getCorreo());

                sentenciaPreparada.setDouble(6, actividad.getPrecio());
                sentenciaPreparada.setDate(7, Date.valueOf(actividad.getFecha().toString()));
            } else {
                sentenciaPreparada = conexion.prepareStatement(sql);

                sentenciaPreparada.setString(1, actividad.getNombreActiv());
                sentenciaPreparada.setString(2, actividad.getDescripcion());
                sentenciaPreparada.setString(3, actividad.getLugar());
                sentenciaPreparada.setInt(4, actividad.getTelefono());
                sentenciaPreparada.setString(5, actividad.getCorreo());

                sentenciaPreparada.setDouble(6, actividad.getPrecio());
                sentenciaPreparada.setDate(7, Date.valueOf(actividad.getFecha().toString()));
                sentenciaPreparada.setString(8, actividad.getFotoActiv());

            }

            sentenciaPreparada.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentecia o al obtener la conexion");
            ex.printStackTrace();

        } finally {
            this.closeConnection();
        }
    }

    /**
     * Con este metodo comprabaremos si el email introducido de la empresa que
     * realiza la actividad se encuentra ya en la base de datos
     *
     * @param email
     * @return
     */
    @Override
    public boolean buscarEmailActividad(String email) {
        boolean encontrado = false;

        Sentencias sentenciaSQL = new Sentencias();

        String sql = sentenciaSQL.obtenerEmailsActividad();
        ConnectionFactory obtener = new ConnectionFactory();

        try {
            Connection conexion = obtener.obtenerConexionMySQL();
            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {

                if (email.equals(resultado.getString("correo"))) {
                    encontrado = true;
                    break;
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error");
        } finally {
            this.closeConnection();
        }

        return encontrado;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConexion();
    }

    @Override
    public void eliminarActividad(String[] ids) {

        Sentencias sentenciasSql=new Sentencias();
        String sql=sentenciasSql.eliminarActividad(ids);
         ConnectionFactory obtener = new ConnectionFactory();
        Connection conexion = null;
        
        try{
            conexion=obtener.obtenerConexionMySQL();
             Statement sentencia = conexion.createStatement();

            conexion.setAutoCommit(false);
            sentencia.executeUpdate(sql);
            conexion.commit();
            
            
        }catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia");

            try {
                conexion.rollback();
            } catch (SQLException ex1) {

            }

        } finally {
            this.closeConnection();
        }
    }
    
    
    
    

    @Override
    public Actividad getDatosActividad(String id) {
        Actividad actividad = null;

        Sentencias sentenciasSql = new Sentencias();
        String sql = sentenciasSql.getDatosActividad(id);
        ConnectionFactory obtener = new ConnectionFactory();

        try {
            Connection conexion = obtener.obtenerConexionMySQL();
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(sql);
            
            sentenciaPreparada.setString(1, id);
            
            ResultSet resultado=sentenciaPreparada.executeQuery();
            
            while(resultado.next()){
                actividad=new Actividad();
                actividad.setIdActividad(resultado.getInt("idActividad"));
                actividad.setNombreActiv(resultado.getString("nombreActiv"));
                actividad.setDescripcion(resultado.getString("descripcion"));
                actividad.setLugar(resultado.getString("lugar"));
                actividad.setTelefono(resultado.getInt("telefono"));
                actividad.setCorreo(resultado.getString("correo"));
                actividad.setPrecio(resultado.getDouble("precio"));
                actividad.setFecha(resultado.getDate("fecha"));
                      
            }

            

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentecia");
        } finally {
            this.closeConnection();
        }
        
        return actividad;
    }

    @Override
    public void modificarActividad(Actividad actividad) {
        Sentencias sentenciasSql = new Sentencias();
        String sql = "";
        ConnectionFactory obtener = new ConnectionFactory();
        Connection conexion=null;
        PreparedStatement sentenciaPreparada = null;

        try {
             conexion = obtener.obtenerConexionMySQL();
             conexion.setAutoCommit(false);
             
            if (actividad.getFotoActiv() == null) {
                sql = sentenciasSql.actualizarActividadSinFoto();
                sentenciaPreparada = conexion.prepareStatement(sql);
                sentenciaPreparada.setString(1, actividad.getNombreActiv());
                sentenciaPreparada.setString(2, actividad.getDescripcion());
                sentenciaPreparada.setString(3, actividad.getLugar());
                sentenciaPreparada.setInt(4, actividad.getTelefono());
                sentenciaPreparada.setString(5, actividad.getCorreo());
                sentenciaPreparada.setDouble(6, actividad.getPrecio());
                sentenciaPreparada.setDate(7, Date.valueOf(actividad.getFecha().toString()));
                sentenciaPreparada.setInt(8, actividad.getIdActividad());
            } else {
                sql=sentenciasSql.actualizarActividad();
                sentenciaPreparada = conexion.prepareStatement(sql);

                sentenciaPreparada.setString(1, actividad.getNombreActiv());
                sentenciaPreparada.setString(2, actividad.getDescripcion());
                sentenciaPreparada.setString(3, actividad.getLugar());
                sentenciaPreparada.setInt(4, actividad.getTelefono());
                sentenciaPreparada.setString(5, actividad.getCorreo());

                sentenciaPreparada.setDouble(6, actividad.getPrecio());
                sentenciaPreparada.setDate(7, Date.valueOf(actividad.getFecha().toString()));
                sentenciaPreparada.setString(8, actividad.getFotoActiv());
                sentenciaPreparada.setInt(9, actividad.getIdActividad());


            }

            sentenciaPreparada.executeUpdate();
            conexion.commit();

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentecia o al obtener la conexion");
            ex.printStackTrace();

            try {
                conexion.rollback();
            } catch (SQLException ex1) {

            }
        } finally {
            this.closeConnection();
        }    
    
    }

    @Override
    public List<Actividad> getActividadesPorLugar(String lugar) {
        
        List<Actividad> listaActividades = new ArrayList<>();

        Sentencias sentenciasSql = new Sentencias();

        String sql = sentenciasSql.obtenerActividadesPorLugar();
        ConnectionFactory obtener = new ConnectionFactory();

        try {
            Connection conexion = obtener.obtenerConexionMySQL();
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(sql);


            sentenciaPreparada.setString(1, lugar);
            
            ResultSet resultado = sentenciaPreparada.executeQuery();

            
            while(resultado.next()){
                Actividad actividad=new Actividad();
                actividad.setIdActividad(resultado.getInt("idActividad"));
                actividad.setNombreActiv(resultado.getString("nombreActiv"));
                actividad.setDescripcion(resultado.getString("descripcion"));
                actividad.setLugar(resultado.getString("lugar"));
                actividad.setTelefono(resultado.getInt("telefono"));
                actividad.setCorreo(resultado.getString("correo"));
                actividad.setPrecio(resultado.getDouble("precio"));
                actividad.setFecha(resultado.getDate("fecha"));
                actividad.setFotoActiv(resultado.getString("fotoActiv"));
                
                listaActividades.add(actividad);
            }
           

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentecia o al obtener la conexion");
        } finally {
            this.closeConnection();
        }

        return listaActividades;
    }

}
