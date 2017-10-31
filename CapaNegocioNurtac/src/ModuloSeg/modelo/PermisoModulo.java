/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeg.modelo;

import java.util.List;

/**
 *
 * @author Ellet
 */
public class PermisoModulo {
    
    private String modulo;
    private List<Permiso> permisos;

    public PermisoModulo() {
    }

    public PermisoModulo(String modulo, List<Permiso> permisos) {
        this.modulo = modulo;
        this.permisos = permisos;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }
    
    
    
    
}
