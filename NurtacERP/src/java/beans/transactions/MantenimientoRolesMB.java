/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.transactions;

import beans.data.MantRolDataMB;
import facade.FacadeRol;
import facade.IFacadeRol;
import modelo.seguridad.Roles;
import modelo.seguridad.Page;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.seguridad.Roles;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Henry
 */
@Named
@ManagedBean
@javax.faces.bean.RequestScoped
public class MantenimientoRolesMB implements Serializable {

    @Inject
    private MantRolDataMB mantRolDataMB;
    private IFacadeRol facadeMantRol;

    @PostConstruct
    public void init() {

        mantRolDataMB.setSel_roles(new Roles());
        facadeMantRol = new FacadeRol();
        mantRolDataMB.setLroles(facadeMantRol.getAllRoles());

    }

    public MantenimientoRolesMB() {

    }

    public MantRolDataMB getMantRolDataMB() {
        return mantRolDataMB;
    }

    public void setMantRolDataMB(MantRolDataMB mantRolDataMB) {
        this.mantRolDataMB = mantRolDataMB;
    }

    public void onRowSelect(SelectEvent event) {

        //mantRolDataMB.setSel_roles((Roles) event.getObject());
        mantRolDataMB.setSel_roles(mantRolDataMB.getSel_roles());

    }

    public void limpiar() {
        mantRolDataMB.setSel_roles(null);
        mantRolDataMB.setSel_roles(new Roles());
        mantRolDataMB.setLroles(facadeMantRol.getAllRoles());
    }

    public void grabar() {
        try {
            System.out.println("Llegó Aquí");
            mantRolDataMB.getSel_roles().toString();
            System.out.println("Llegó Acá");
            facadeMantRol.guardarRol(mantRolDataMB.getSel_roles());
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Operación Exitosa",
                    "Rol fue " + (mantRolDataMB.getSel_roles().getCodigo() == 0 ? "Guardado" : "Modificado") + " Exitosamente");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            limpiar();
        } catch (Exception exc) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Guardar Roles de Usuario", exc.getCause().getMessage());
            PrimeFaces.current().dialog().showMessageDynamic(message);
            throw exc;
        }
    }

    public void eliminar() {
        try {
            facadeMantRol.eliminaRol(mantRolDataMB.getSel_roles());
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Operación Exitosa",
                    "Rol Eliminado Exitosamente");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            limpiar();
        } catch (Exception exc) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar Rol", exc.getCause().getMessage());
            PrimeFaces.current().dialog().showMessageDynamic(message);
            throw exc;
        }
    }

    public void salir() {

    }

}
