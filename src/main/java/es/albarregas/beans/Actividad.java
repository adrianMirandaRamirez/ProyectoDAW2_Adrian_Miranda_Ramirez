/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author adrian
 */
public class Actividad implements Serializable{
    
    private int idActividad;
    private String nombreActiv;
    private String descripcion;
    private String lugar;
    private int telefono;
    private String correo;
    private double precio;
    private Date fecha;
    private String fotoActiv;
    
    public Actividad() {
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombreActiv() {
        return nombreActiv;
    }

    public void setNombreActiv(String nombreActiv) {
        this.nombreActiv = nombreActiv;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFotoActiv() {
        return fotoActiv;
    }

    public void setFotoActiv(String fotoActiv) {
        this.fotoActiv = fotoActiv;
    }
    
    
    
}
