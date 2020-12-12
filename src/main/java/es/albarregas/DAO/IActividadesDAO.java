/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.beans.Actividad;
import java.util.List;

/**
 *
 * @author adrian
 */
public interface IActividadesDAO {
    
    public List<Actividad> getActividades();
    
     public void nuevaActividad(Actividad actividad);

    public boolean buscarEmailActividad(String email);
    
    public void eliminarActividad(String[] ids);
    
    public void modificarActividad(Actividad actividad);
    
    public Actividad getDatosActividad(String id);
    
     public void closeConnection();
     
     public List<Actividad> getActividadesPorLugar(String lugar);
     
     
}
