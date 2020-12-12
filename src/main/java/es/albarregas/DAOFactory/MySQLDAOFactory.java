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
import es.albarregas.DAO.MySQLActividadesDAO;
import es.albarregas.DAO.MySQLHotelesDAO;
import es.albarregas.DAO.MySQLReservasDAO;
import es.albarregas.DAO.MySQLUsuariosDAO;

/**
 *
 * @author adrian
 */
public class MySQLDAOFactory extends DAOFactory{

    @Override
    public IUsuariosDAO getUsuariosDAO() {
        
        return new MySQLUsuariosDAO();
    }

    @Override
    public IHotelesDAO getHotelesDAO() {
        
        return new MySQLHotelesDAO();
    }

    @Override
    public IActividadesDAO getActividadesDAO() {

        return new MySQLActividadesDAO();
    }

    @Override
    public IReservasDAO getReservasDAO() {
         return new MySQLReservasDAO();
    }
    
}
