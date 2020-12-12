/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.models;

/**
 *
 * @author adrian
 */
public class Sentencias {

    String sql = "";
    StringBuilder sentenciaSQL = new StringBuilder();
    
    
    public String obtenerReservasUsuario(){
        sql = " select * from reservas where idUsuario = ?";
        
        return sql;
    }

    public String obtenerDatosReserva(){
        sql = "select * from reservas where idReserva = ?";
        
        return sql;
    }
    public String obtenerUsuarios() {
        sql = "select * from usuarios";

        return sql;
    }

    public String obtenerHoteles() {
        sql = "select * from hoteles";

        return sql;
    }

    public String obtenerActividades() {
        sql = "select * from actividades";

        return sql;
    }
    
    public String obtenerReservas(){
        sql= "select * from reservas";
        
        return sql;
    }
    
     /**
      * Este metodo devuelve la sentencia que nos devolvera las reservas cuya fecha de reserva sea menos a la fecha actual
      * @return 
      */
      public String obtenerReservasFechaPasada(){
        sql= "select * from reservas where fechaReserva between 2020-01-01 and ? ";
        
        return sql;
    }
    
    

    /**
     * Con este metodo obtendremos la sentencia que nos devolvera todos los
     * emails de todos los usuarios que tengamos en la tabla usuarios
     *
     * @return
     */
    public String obtenerEmailsUsuarios() {
        sql = "select correo from usuarios";

        return sql;
    }

    /**
     * Con este metodo obtendremos la sentencia que nos devolvera todos los
     * emails de todos los hoteles que tengamos en la tabla hoteles
     *
     * @return
     */
    public String obtenerEmailsHoteles() {
        sql = "select correo from hoteles";

        return sql;
    }

    /**
     * Con este metodo obtendremos la sentencia que nos devolvera todos los
     * emails de todos las empresas que llevan acabo las actividades
     *
     * @return
     */
    public String obtenerEmailsActividad() {
        sql = "select correo from actividades";

        return sql;
    }

    /**
     * Con este metodo obtendremos la sentencia para crear un nuevo usuario en
     * la tabla usuarios de la base de datos
     *
     * @return
     */
    public String nuevoUsuario() {
        sql = "insert into usuarios(nombre,apellidos,correo,contrasenia,nif,telefono) values(?,?,?,?,?,?)";

        return sql;
    }

    /**
     * Con este metodo obtendremos la sentencia para crear un nuevo hotel en la
     * base de datos
     *
     * @return
     */
    public String nuevoHotel() {
        sql = "insert into hoteles(nombreHotel,lugar,telefono,correo,precio,fotoHotel) values(?,?,?,?,?,?)";

        return sql;
    }

    public String nuevaActividad() {
        sql = "insert into actividades(nombreActiv,descripcion,lugar,telefono,correo,precio,fecha,fotoActiv) values(?,?,?,?,?,?,?,?)";

        return sql;
    }

    /**
     * HACER DOS SENTENCIAS PARA DAR DE ALTA UNA RESERVA, UNA SIN EL ID ACTIVIDAD Y OTRA SIN EL ID HOTEL
     * @return 
     */
    public String nuevoReservaHotel(){
        sql="insert into reservas(idHotel,FechaReserva,idUsuario) values(?,?,?)";
        
        return sql;
    }
    
    
    public String nuevaReservaActividad(){
         sql="insert into reservas(idActividad,FechaReserva,idUsuario) values(?,?,?)";

         return sql;
    }
    /**
     * Con este metodo obtendremos la sentencia para crear un nuevo hotel en la
     * base de datos
     *
     * @return
     */
    public String nuevoHotelSinFoto() {
        sql = "insert into hoteles(nombreHotel,lugar,telefono,correo,precio) values(?,?,?,?,?)";

        return sql;
    }

    public String nuevaActividadSinFoto() {
        sql = "insert into actividades(nombreActiv,descripcion,lugar,telefono,correo,precio,fecha) values(?,?,?,?,?,?,?)";

        return sql;
    }

    /**
     * Con este metodo obtendremos todos los correos y contraseñas de los
     * usuarios que se encuentren en la base de datos
     *
     * @return
     */
    public String obtenerCorreosYContrasenias() {
        sql = "select correo,contrasenia from usuarios";

        return sql;
    }

    /**
     * Este metodo nos devolvera la sentencia para poder un borrar uno o varios registros de la tabla hoteles
     * @param ids
     * @return 
     */
    public String eliminarHolel(String[] ids) {

        StringBuilder where = new StringBuilder(" where idHotel in (");
        for (int i = 0; i < ids.length; i++) {
            where.append("'");
            where.append(ids[i]);
            where.append("',");
        }
        where.replace(where.length() - 1, where.length(), ")");

        sql = "delete from hoteles " + where.toString();

        return sql;
    }

    
    /**
     * Este metodo nos devolvera la sentencia para poder un borrar uno o varios registros de la tabla actividades
     * @param ids
     * @return 
     */
    public String eliminarActividad(String[] ids) {
        StringBuilder where = new StringBuilder(" where idActividad in (");
        for (int i = 0; i < ids.length; i++) {
            where.append("'");
            where.append(ids[i]);
            where.append("',");
        }
        where.replace(where.length() - 1, where.length(), ")");

        sql = "delete from actividades " + where.toString();

        return sql;
    }

    
     /**
     * Este metodo nos devolvera la sentencia para poder un borrar uno o varios registros de la tabla actividades
     * @param ids
     * @return 
     */
    public String eliminarReserva(String[] ids) {
        StringBuilder where = new StringBuilder(" where idReserva in (");
        for (int i = 0; i < ids.length; i++) {
            where.append("'");
            where.append(ids[i]);
            where.append("',");
        }
        where.replace(where.length() - 1, where.length(), ")");

        sql = "delete from reservas " + where.toString();

        return sql;
    }
    
    public String getDatosHotel(String id){
        sql="select * from hoteles where idHotel=?";
                
        return sql;
    }
    
    
      public String getDatosActividad(String id){
          sql="select * from actividades where idActividad=?";
          
          return sql;
    }
      
      
      public String actualizarHotel(){
          sql="update hoteles set nombreHotel=?, lugar=?, telefono=?, correo=?, precio=?, fotoHotel=? where idHotel=?";
          
          return sql;
          
      }
    
      
      public String actualizarHotelSinFoto(){
          sql="update hoteles set nombreHotel=?, lugar=?, telefono=?, correo=?, precio=? where idHotel=?";

          return sql;
      }
      
      //nombreActiv, descripcion ,lugar, telefono, correo ,precio, fecha, fotoActiv 

      public String actualizarActividad(){
          sql="update actividades set nombreActiv=?, descripcion=?, lugar=?, telefono=?, correo=?, precio=?, fecha=?, fotoActiv=? where idActividad=?; ";
          
          return sql;
      }
      
      
      
      public String actualizarActividadSinFoto(){
          
          sql="update actividades set nombreActiv=?, descripcion=?, lugar=?, telefono=?, correo=?, precio=?, fecha=? where idActividad=?; ";

     
          return sql;
      }
    
      
      public String obtenerHotelesPorLugar(){
          sql="select * from hoteles where lugar=?";
          
          return sql;
      }
      
       public String obtenerActividadesPorLugar(){
          
           sql="select * from actividades where lugar=?";
           
           
           return sql;
      }
       
      public String obtenerDatosUsuarioPorCorreo(){
          sql= "select * from usuarios where correo=?";
          
          return sql;
      }
      
      
}
