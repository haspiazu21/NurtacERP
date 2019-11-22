/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.seguridad;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public class AsignacionPermisos {

    Usuario usuario;
    private List<Permiso> permisos;

    public AsignacionPermisos() {
    }

    public AsignacionPermisos(Usuario usuario, List<Permiso> permisos) {
        this.usuario = usuario;
        this.permisos = permisos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    
}
