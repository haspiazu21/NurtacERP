/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.data;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.general.Empresa;
import modelo.general.Sucursal;
import modelo.seguridad.GrupoUsuario;
import modelo.seguridad.Roles;
import modelo.seguridad.Usuario;

/**
 *
 * @author Henry
 */
@Named
@ViewScoped
public class MantRolDataMB implements Serializable {

    private List<Roles> lroles;
    private Roles sel_roles;
    private Roles rol;

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }
    

    public MantRolDataMB() {
    }

    
    public Roles getSel_roles() {
        return sel_roles;
    }

    public void setSel_roles(Roles sel_roles) {
        this.sel_roles = sel_roles;
    }

    public List<Roles> getLroles() {
        return lroles;
    }

    public void setLroles(List<Roles> lroles) {
        this.lroles = lroles;
    }

    
    
    
}
