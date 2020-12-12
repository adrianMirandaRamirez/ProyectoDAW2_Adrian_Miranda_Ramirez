/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Actividad;
import es.albarregas.beans.Hotel;
import es.albarregas.beans.Reservas;
import es.albarregas.models.Sentencias;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import java.util.List;

/**
 *
 *    ssa@author adrian
 */
public class MySQLReservasDAO implements IReservasDAO {

    //Obtener todas las reservas quitar lo de reservas fecha pasada
    @Override
    public List<Reservas> getReservas() {
        List<Reservas> listaReservas = new ArrayList<>();
        
        
        Sentencias sentenciasSql = new Sentencias();

        String sql = sentenciasSql.obtenerReservas();
        ConnectionFactory obtener = new ConnectionFactory();
        DAOFactory daof = DAOFactory.getDAOFactory(1);
        
        IHotelesDAO hotelesDAO = daof.getHotelesDAO();
        IActividadesDAO actividadesDAO = daof.getActividadesDAO();
        
        
        
        
        
        try {
            Connection conexion = obtener.obtenerConexionMySQL();
            Statement sentencia = conexion.createStatement();
            
            

            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
               Hotel hotel = new Hotel();
               Actividad actividad = new Actividad();
               Reservas reserva = new Reservas();
               
               reserva.setIdReserva(resultado.getInt("idReserva"));
               reserva.setIdHotel(hotelesDAO.getDatosHotel(String.valueOf(resultado.getInt("idHotel"))));
               reserva.setIdActividad(actividadesDAO.getDatosActividad(String.valueOf(resultado.getInt("idActividad"))));
               reserva.setFechaReserva(resultado.getDate("fechaReserva"));
               reserva.setIdUsuario(resultado.getInt("idUsuario"));
               
               listaReservas.add(reserva);

            }

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentecia o al obtener la conexion");
        } finally {
            this.closeConnection();
        }
        
        return listaReservas;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConexion();
    }

    @Override
    public void nuevaReserva(Reservas reservas) {
        Sentencias sentenciasSql = new Sentencias();
        String sql = "";
        ConnectionFactory obtener = new ConnectionFactory();
        PreparedStatement sentenciaPreparada = null;

        try {
            Connection conexion = obtener.obtenerConexionMySQL();
            if (reservas.getIdActividad() == null) {
                sql = sentenciasSql.nuevoReservaHotel();
                sentenciaPreparada = conexion.prepareStatement(sql);
                sentenciaPreparada.setInt(1, reservas.getIdHotel().getIdHotel());
                sentenciaPreparada.setDate(2, Date.valueOf(reservas.getFechaReserva().toString()));
                sentenciaPreparada.setInt(3, reservas.getIdUsuario());

            } else {
                sql = sentenciasSql.nuevaReservaActividad();
                sentenciaPreparada = conexion.prepareStatement(sql);
                sentenciaPreparada.setInt(1, reservas.getIdActividad().getIdActividad());
                sentenciaPreparada.setDate(2, Date.valueOf(reservas.getFechaReserva().toString()));
                sentenciaPreparada.setInt(3, reservas.getIdUsuario());

            }

            sentenciaPreparada.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentecia o al obtener la conexion");
            ex.printStackTrace();

        } finally {
            this.closeConnection();
        }

    }

    @Override
    public List<Reservas> getReservasPorUsuario(String idUsuario) {
         List<Reservas> listaReservas = new ArrayList<>();
        
        
        Sentencias sentenciasSql = new Sentencias();

        String sql = sentenciasSql.obtenerReservasUsuario();
        ConnectionFactory obtener = new ConnectionFactory();
        DAOFactory daof = DAOFactory.getDAOFactory(1);
        
        IHotelesDAO hotelesDAO = daof.getHotelesDAO();
        IActividadesDAO actividadesDAO = daof.getActividadesDAO();
        
        
        
        
        
        try {
            Connection conexion = obtener.obtenerConexionMySQL();
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(sql);
            
            sentenciaPreparada.setString(1, idUsuario);
            

            ResultSet resultado = sentenciaPreparada.executeQuery();

            while (resultado.next()) {
               Hotel hotel = new Hotel();
               Actividad actividad = new Actividad();
               Reservas reserva = new Reservas();
               
               reserva.setIdReserva(resultado.getInt("idReserva"));
               reserva.setIdHotel(hotelesDAO.getDatosHotel(String.valueOf(resultado.getInt("idHotel"))));
               reserva.setIdActividad(actividadesDAO.getDatosActividad(String.valueOf(resultado.getInt("idActividad"))));
               reserva.setFechaReserva(resultado.getDate("fechaReserva"));
               reserva.setIdUsuario(resultado.getInt("idUsuario"));
               
               listaReservas.add(reserva);

            }

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentecia o al obtener la conexion");
        } finally {
            this.closeConnection();
        }
        
        return listaReservas;
    }

    @Override
    public Reservas getDatosReserva(String idReserva) {
        
        
        
        
        Sentencias sentenciasSql = new Sentencias();

        String sql = sentenciasSql.obtenerDatosReserva();
        ConnectionFactory obtener = new ConnectionFactory();
        DAOFactory daof = DAOFactory.getDAOFactory(1);
        
        IHotelesDAO hotelesDAO = daof.getHotelesDAO();
        IActividadesDAO actividadesDAO = daof.getActividadesDAO();
        
        Reservas reserva = new Reservas();
               
        
        
        
        try {
            Connection conexion = obtener.obtenerConexionMySQL();
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(sql);
            
            sentenciaPreparada.setString(1, idReserva);
            

            ResultSet resultado = sentenciaPreparada.executeQuery();

            while (resultado.next()) {
               Hotel hotel = new Hotel();
               Actividad actividad = new Actividad();
              
               reserva.setIdReserva(resultado.getInt("idReserva"));
               reserva.setIdHotel(hotelesDAO.getDatosHotel(String.valueOf(resultado.getInt("idHotel"))));
               reserva.setIdActividad(actividadesDAO.getDatosActividad(String.valueOf(resultado.getInt("idActividad"))));
               reserva.setFechaReserva(resultado.getDate("fechaReserva"));
               reserva.setIdUsuario(resultado.getInt("idUsuario"));
               
              

            }

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentecia o al obtener la conexion");
        } finally {
            this.closeConnection();
        }
        
        return reserva;
    }

    @Override
    public void eliminarReserva(String[] ids) {
       Sentencias sentenciasSql = new Sentencias();
        String sql = sentenciasSql.eliminarReserva(ids);
        ConnectionFactory obtener = new ConnectionFactory();
        Connection conexion = null;

        try {
            conexion = obtener.obtenerConexionMySQL();
            Statement sentencia = conexion.createStatement();

            conexion.setAutoCommit(false);
            sentencia.executeUpdate(sql);
            conexion.commit();

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia");

            try {
                conexion.rollback();
            } catch (SQLException ex1) {

            }

        } finally {
            this.closeConnection();
        }
    }

}
