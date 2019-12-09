/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.transactions;

import beans.data.MantRolDataMB;
import facade.FacadeMantUsuario;
import facade.FacadeRol;
import facade.IFacadeRol;
import modelo.seguridad.Roles;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.general.Empresa;
import modelo.seguridad.Usuario;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Henry
 */
@Named
@ViewScoped
public class MantenimientoRolesMB implements Serializable {

    @Inject
    private MantRolDataMB mantRolDataMB;
    private IFacadeRol facadeMantRol;

    @PostConstruct
    public void init() {
        mantRolDataMB.setRol(new Roles());
        facadeMantRol = new FacadeRol();
        mantRolDataMB.setLroles(facadeMantRol.getAllRoles());
    }

    public MantRolDataMB getMantRolDataMB() {
        return mantRolDataMB;
    }

    public void setMantRolDataMB(MantRolDataMB mantRolDataMB) {
        this.mantRolDataMB = mantRolDataMB;
    }

    public MantenimientoRolesMB() {
    }

    public void onRowSelect(SelectEvent event) {

        IFacadeRol roles = new FacadeRol();

        if (roles != null) {
            mantRolDataMB.setLroles(facadeMantRol.getAllRoles());
        }
        //mantRolDataMB.setUsuario(usuarioData.getSeleccion());
        System.out.println(mantRolDataMB.getLroles().toString());

    }

    public void limpiar() {
        mantRolDataMB.setLroles(null);
        mantRolDataMB.setSel_roles(null);
        mantRolDataMB.setLroles(facadeMantRol.getAllRoles());
    }

    public void salir() {

    }

}
