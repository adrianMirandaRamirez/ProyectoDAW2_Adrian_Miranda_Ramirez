/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author adrian
 */
public class ConnectionFactory {
    
     public static DataSource datasource=null;
    public static Connection conexion=null;

    public ConnectionFactory() {
    }
    
    
    public  Connection obtenerConexionMySQL() throws SQLException{
            try {
            Context contextoInicial = new InitialContext();
            datasource = (DataSource) contextoInicial.lookup("java:comp/env/jdbc/proyecto");
                System.err.println(datasource);
            conexion=datasource.getConnection();
            
        } catch (NamingException ex) {
            System.out.println("Problemas en el acceso al recurso... en mysql");
            ex.printStackTrace();

        }
           return conexion;
    }
    
    
    
    
     public static void closeConexion() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            System.out.println("Problemas al cerrar la conexion");
        }

        
    }
    
}
