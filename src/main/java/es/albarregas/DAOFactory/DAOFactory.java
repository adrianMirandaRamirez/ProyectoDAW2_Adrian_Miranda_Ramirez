/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAOFactory;

import es.albarregas.DAO.IActividadesDAO;
import es.albarregas.DAO.IHotelesDAO;
import es.albarregas.DAO.IReservasDAO;
import es.albarregas.DAO.IUsuariosDAO;

/**
 *
 * @author adrian
 */
public abstract class DAOFactory {
    
    public abstract IUsuariosDAO getUsuariosDAO();
    public abstract IHotelesDAO getHotelesDAO();
    public abstract IActividadesDAO getActividadesDAO();
    public abstract IReservasDAO getReservasDAO(); 
    
    public static DAOFactory getDAOFactory(int tipo){
        DAOFactory daof=null;
        
        switch(tipo){
            case 1:
                daof=new MySQLDAOFactory();
              break;
           
        }
        
        return daof;
        
    }
}
