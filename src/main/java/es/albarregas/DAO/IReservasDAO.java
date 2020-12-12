/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.beans.Reservas;
import java.util.List;

/**
 *
 * @author adrian
 */
public interface IReservasDAO {
    
     public List<Reservas> getReservas();
     
      public List<Reservas> getReservasPorUsuario(String idUsuario);
     
     public Reservas getDatosReserva(String idReserva);
     
     public void eliminarReserva(String[] ids);
      
     public void nuevaReserva(Reservas reservas);
    
    public void closeConnection();
}
