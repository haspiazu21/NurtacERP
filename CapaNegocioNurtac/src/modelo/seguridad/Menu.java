/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.seguridad;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ellet
 */
public class Menu implements Serializable {
    
    
    private int id;
    private String nombre;
    private List<MenuItem> menuItems;

    public Menu(int id, String nombre, List<MenuItem> menuItems) {
        this.id = id;
        this.nombre = nombre;
        this.menuItems = menuItems;
    }

    public Menu(String nombre, List<MenuItem> menuItems) {
        this.nombre = nombre;
        this.menuItems = menuItems;
    }

    public Menu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    
    
}
