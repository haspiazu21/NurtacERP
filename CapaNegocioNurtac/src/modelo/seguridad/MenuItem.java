/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.seguridad;

import java.io.Serializable;

/**
 *
 * @author Ellet
 */
public class MenuItem implements Serializable {

    private int Id;
    private String nombre;
    private String vista;
    private String imagen;
    private String estado;

    public MenuItem() {
    }

    public MenuItem(int Id, String nombre, String vista, String imagen, String estado) {
        this.Id = Id;
        this.nombre = nombre;
        this.vista = vista;
        this.imagen = imagen;
        this.estado = estado;
    }

    public MenuItem(String nombre, String vista, String imagen, String estado) {
        this.nombre = nombre;
        this.vista = vista;
        this.imagen = imagen;
        this.estado = estado;
    }

    public MenuItem(int Id, String nombre, String vista) {
        this.Id = Id;
        this.nombre = nombre;
        this.vista = vista;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVista() {
        return vista;
    }

    public void setVista(String vista) {
        this.vista = vista;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
