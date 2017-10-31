/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeg.modelo;

import java.io.Serializable;

/**
 *
 * @author Ellet
 */
public class Page implements Serializable {

    private int codigo;
    private String nombre;
    private String modulo;
    private Permiso permiso;
    private Permiso permisosMenu;

    public Page() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public Permiso getPermisosMenu() {
        return permisosMenu;
    }

    public void setPermisosMenu(Permiso permisosMenu) {
        this.permisosMenu = permisosMenu;
    }

}
