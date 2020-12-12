/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.beans.Hotel;
import java.util.List;

/**
 *
 * @author adrian
 */
public interface IHotelesDAO {

    public List<Hotel> getHoteles();

    public void nuevoHotel(Hotel hotel);

    public boolean buscarEmailHotel(String email);

    public void eliminarHotel(String[] ids);
    
    public Hotel getDatosHotel(String id);
    
    public void modificarHotel(Hotel hotel);
    
    public void closeConnection();
    
    public List<Hotel> getHotelesPorLugar(String lugar);

}
