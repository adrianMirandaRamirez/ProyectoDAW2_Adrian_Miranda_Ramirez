/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.beans.Hotel;
import es.albarregas.models.Sentencias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adrian
 */
public class MySQLHotelesDAO implements IHotelesDAO {

    /**
     * Este metodo se encarga de crear un nuevo hotel en la base de datos con
     * los datos que ha introducido el admin
     *
     * @param hotel
     */
    @Override
    public void nuevoHotel(Hotel hotel) {
        Sentencias sentenciasSql = new Sentencias();
        String sql = sentenciasSql.nuevoHotel();
        ConnectionFactory obtener = new ConnectionFactory();
        PreparedStatement sentenciaPreparada = null;

        try {

            Connection conexion = obtener.obtenerConexionMySQL();
            if (hotel.getFotoHotel() == null) {
                sql = sentenciasSql.nuevoHotelSinFoto();
                sentenciaPreparada = conexion.prepareStatement(sql);
                sentenciaPreparada.setString(1, hotel.getNombreHotel());
                sentenciaPreparada.setString(2, hotel.getLugar());
                sentenciaPreparada.setInt(3, hotel.getTelefono());
                sentenciaPreparada.setString(4, hotel.getCorreo());
                sentenciaPreparada.setDouble(5, hotel.getPrecio());

            } else {
                sentenciaPreparada = conexion.prepareStatement(sql);

                sentenciaPreparada.setString(1, hotel.getNombreHotel());
                sentenciaPreparada.setString(2, hotel.getLugar());
                sentenciaPreparada.setInt(3, hotel.getTelefono());
                sentenciaPreparada.setString(4, hotel.getCorreo());
                sentenciaPreparada.setDouble(5, hotel.getPrecio());
                sentenciaPreparada.setString(6, hotel.getFotoHotel());

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
    public boolean buscarEmailHotel(String email) {
        boolean encontrado = false;

        Sentencias sentenciaSQL = new Sentencias();

        String sql = sentenciaSQL.obtenerEmailsHoteles();
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
    public List<Hotel> getHoteles() {
        List<Hotel> listaHoteles = new ArrayList<>();

        Sentencias sentenciasSql = new Sentencias();

        String sql = sentenciasSql.obtenerHoteles();
        ConnectionFactory obtener = new ConnectionFactory();

        try {
            Connection conexion = obtener.obtenerConexionMySQL();
            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                Hotel hotel = new Hotel();
                hotel.setIdHotel(resultado.getInt("idHotel"));
                hotel.setNombreHotel(resultado.getString("nombreHotel"));
                hotel.setLugar(resultado.getString("lugar"));
                hotel.setTelefono(resultado.getInt("telefono"));
                hotel.setCorreo(resultado.getString("correo"));
                hotel.setPrecio(resultado.getDouble("precio"));
                hotel.setFotoHotel(resultado.getString("fotoHotel"));

                listaHoteles.add(hotel);

            }

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentecia o al obtener la conexion");
        } finally {
            this.closeConnection();
        }

        return listaHoteles;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConexion();
    }

    @Override
    public void eliminarHotel(String[] ids) {
        Sentencias sentenciasSql = new Sentencias();
        String sql = sentenciasSql.eliminarHolel(ids);
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

    @Override
    public Hotel getDatosHotel(String id) {
        Hotel hotel = null;
        Sentencias sentenciaSql = new Sentencias();
        String sql = sentenciaSql.getDatosHotel(id);
        ConnectionFactory obtener = new ConnectionFactory();

        try {
            Connection conexion = obtener.obtenerConexionMySQL();
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(sql);

            sentenciaPreparada.setString(1, id);

            ResultSet resultado = sentenciaPreparada.executeQuery();

            while (resultado.next()) {
                hotel = new Hotel();
                hotel.setIdHotel(resultado.getInt("idHotel"));
                hotel.setNombreHotel(resultado.getString("nombreHotel"));
                hotel.setLugar(resultado.getString("lugar"));
                hotel.setCorreo(resultado.getString("correo"));
                hotel.setPrecio(resultado.getDouble("precio"));

            }

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentecia");
        } finally {
            this.closeConnection();
        }

        return hotel;

    }

    @Override
    public void modificarHotel(Hotel hotel) {

        Sentencias sentenciasSql = new Sentencias();
        String sql = "";

        ConnectionFactory obtener = new ConnectionFactory();
        Connection conexion = null;
        PreparedStatement sentenciaPreparada = null;

        try {
            conexion = obtener.obtenerConexionMySQL();
            conexion.setAutoCommit(false);

            if (hotel.getFotoHotel() == null) {
                sql = sentenciasSql.actualizarHotelSinFoto();
                sentenciaPreparada = conexion.prepareStatement(sql);
                sentenciaPreparada.setString(1, hotel.getNombreHotel());
                sentenciaPreparada.setString(2, hotel.getLugar());
                sentenciaPreparada.setInt(3, hotel.getTelefono());
                sentenciaPreparada.setString(4, hotel.getCorreo());
                sentenciaPreparada.setDouble(5, hotel.getPrecio());
                sentenciaPreparada.setInt(6, hotel.getIdHotel());

            } else {
                sql = sentenciasSql.actualizarHotel();
                sentenciaPreparada = conexion.prepareStatement(sql);
                sentenciaPreparada.setString(1, hotel.getNombreHotel());
                sentenciaPreparada.setString(2, hotel.getLugar());
                sentenciaPreparada.setInt(3, hotel.getTelefono());
                sentenciaPreparada.setString(4, hotel.getCorreo());
                sentenciaPreparada.setDouble(5, hotel.getPrecio());
                sentenciaPreparada.setString(6, hotel.getFotoHotel());
                sentenciaPreparada.setInt(7, hotel.getIdHotel());
            }

            sentenciaPreparada.executeUpdate();
            conexion.commit();

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentecia");
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
    public List<Hotel> getHotelesPorLugar(String lugar) {
        List<Hotel> listaHoteles = new ArrayList<>();

        Sentencias sentenciasSql = new Sentencias();

        String sql = sentenciasSql.obtenerHotelesPorLugar();
        ConnectionFactory obtener = new ConnectionFactory();

        try {
            Connection conexion = obtener.obtenerConexionMySQL();
            PreparedStatement sentenciaPreparada = conexion.prepareStatement(sql);

            sentenciaPreparada.setString(1, lugar);

            ResultSet resultado = sentenciaPreparada.executeQuery();

            while (resultado.next()) {
                Hotel hotel = new Hotel();
                hotel.setIdHotel(resultado.getInt("idHotel"));
                hotel.setNombreHotel(resultado.getString("nombreHotel"));
                hotel.setLugar(resultado.getString("lugar"));
                hotel.setTelefono(resultado.getInt("telefono"));
                hotel.setCorreo(resultado.getString("correo"));
                hotel.setPrecio(resultado.getDouble("precio"));
                hotel.setFotoHotel(resultado.getString("fotoHotel"));

                listaHoteles.add(hotel);
            }

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentecia o al obtener la conexion");
        } finally {
            this.closeConnection();
        }

        return listaHoteles;
    }

}
