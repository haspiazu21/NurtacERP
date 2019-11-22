/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.transactions;

import beans.data.MantGrpUsrDataMB;
import facade.FacadeMantGrupoUsuario;
import facade.IFacadeMantGrupoUsuario;
import modelo.seguridad.GrupoUsuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Ellet
 */
@Named
@ViewScoped
public class MantenimientoGrupoMB implements Serializable {

    @Inject
    private MantGrpUsrDataMB mantGrpUsrDataMB;
    private IFacadeMantGrupoUsuario facadeMantGrupoUsuario;

    public MantenimientoGrupoMB() {

    }

    @PostConstruct
    public void init() {
        mantGrpUsrDataMB.setGrupoUsuario(new GrupoUsuario());
        facadeMantGrupoUsuario = new FacadeMantGrupoUsuario();
        mantGrpUsrDataMB.setGruposUsuarios(facadeMantGrupoUsuario.getAllGruposUsuarios());
    }

    public MantGrpUsrDataMB getMantGrpUsrDataMB() {
        return mantGrpUsrDataMB;
    }

    public void setMantGrpUsrDataMB(MantGrpUsrDataMB mantGrpUsrDataMB) {
        this.mantGrpUsrDataMB = mantGrpUsrDataMB;
    }

    public IFacadeMantGrupoUsuario getFacadeMantGrupoUsuario() {
        return facadeMantGrupoUsuario;
    }

    public void setFacadeMantGrupoUsuario(IFacadeMantGrupoUsuario facadeMantGrupoUsuario) {
        this.facadeMantGrupoUsuario = facadeMantGrupoUsuario;
    }

    public void onRowSelect(SelectEvent event) {
        mantGrpUsrDataMB.setGrupoUsuario(mantGrpUsrDataMB.getSeleccion());
    }

    public void grabar() {
        try {
            System.out.println("Llegó Aquí");
            mantGrpUsrDataMB.getGrupoUsuario().toString();
            System.out.println("Llegó Acá");
            facadeMantGrupoUsuario.guardarGrupoUsuario(mantGrpUsrDataMB.getGrupoUsuario());
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Operación Exitosa",
                    "Grupo de Usuario " + (mantGrpUsrDataMB.getGrupoUsuario().getId() == 0 ? "Guardado" : "Modificado") + " Exitosamente");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            limpiar();
        } catch (Exception exc) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Guardar Grupo de Usuario", exc.getCause().getMessage());
            PrimeFaces.current().dialog().showMessageDynamic(message);
            throw exc;
        }
    }

    public void limpiar() {
        mantGrpUsrDataMB.setSeleccion(null);
        mantGrpUsrDataMB.setGrupoUsuario(null);
        mantGrpUsrDataMB.setGruposUsuarios(facadeMantGrupoUsuario.getAllGruposUsuarios());
    }

    public void anular() {
        try {
            mantGrpUsrDataMB.getGrupoUsuario().setEstado("Inactivo");
            facadeMantGrupoUsuario.guardarGrupoUsuario(mantGrpUsrDataMB.getGrupoUsuario());
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Operación Exitosa",
                    "Grupo de Usuario Anulado Exitosamente");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            limpiar();
        } catch (Exception exc) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al anular Grupo de Usuario", exc.getCause().getMessage());
            PrimeFaces.current().dialog().showMessageDynamic(message);
            throw exc;
        }
    }

    public void eliminar() {
        try {
            facadeMantGrupoUsuario.eliminarGrupoUsuario(mantGrpUsrDataMB.getGrupoUsuario().getId());
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Operación Exitosa",
                    "Grupo de Usuario Eliminado Exitosamente");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            limpiar();
        } catch (Exception exc) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar Grupo de Usuario", exc.getCause().getMessage());
            PrimeFaces.current().dialog().showMessageDynamic(message);
            throw exc;
        }
    }

}
