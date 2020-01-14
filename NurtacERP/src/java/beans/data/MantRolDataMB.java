/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.data;

import facade.FacadeRol;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.seguridad.Roles;

/**
 *
 * @author Henry
 */
@Named
@RequestScoped
public class MantRolDataMB implements Serializable {

    private List<Roles> lroles;
    private Roles sel_roles;
    
      
    public MantRolDataMB() {
        
        sel_roles = new Roles();
    }

    public List<Roles> getLroles() {
        return lroles;
    }

    public void setLroles(List<Roles> lroles) {
        this.lroles = lroles;
    }

    public Roles getSel_roles() {
        if (sel_roles==null){
            sel_roles=new Roles();
        }
        return sel_roles;
    }

    public void setSel_roles(Roles sel_roles) {
        this.sel_roles = sel_roles;
    }

}
