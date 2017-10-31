package beans.transactions;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import beans.data.MantUsuarioDataMB;
import ModuloGen.facade.FacadeMantUsuario;
import ModuloGen.facade.IFacadeMantUsuario;
import ModuloGen.modelo.Empresa;
import ModuloSeg.modelo.Usuario;

/**
 *
 * @author Lenovo
 */
@Named
@ViewScoped
public class MantenimientoUsuarioMB implements Serializable {

    @Inject
    private MantUsuarioDataMB usuarioData;
    private IFacadeMantUsuario FacadeMantUsuario;

    @PostConstruct
    public void init() {
        usuarioData.setUsuario(new Usuario());
        FacadeMantUsuario = new FacadeMantUsuario();
        usuarioData.setEmpresas(FacadeMantUsuario.findAllEmpresas());
        usuarioData.setGruposUsuarios(FacadeMantUsuario.findAllGruposUsuarios());
        usuarioData.setUsuarios(FacadeMantUsuario.findAllUsuarios());

    }

    public MantenimientoUsuarioMB() {

    }

    public MantUsuarioDataMB getUsuarioData() {
        return usuarioData;
    }

    public void setUsuarioData(MantUsuarioDataMB usuarioData) {
        this.usuarioData = usuarioData;
    }

    public void onRowSelect(SelectEvent event) {

        Empresa empresa = usuarioData.getSeleccion().getEmpresa();
        if (empresa != null) {
            usuarioData.setSucursales(FacadeMantUsuario.findSucursalesByEmpresa(empresa.getId()));
        }
        usuarioData.setUsuario(usuarioData.getSeleccion());
        //System.out.println(usuarioData.getSeleccion().toString());

    }

    public void onEmpresaChange() {
        Empresa empresa = usuarioData.getUsuario().getEmpresa();
        if (empresa != null) {
            usuarioData.setSucursales(FacadeMantUsuario.findSucursalesByEmpresa(empresa.getId()));
        }
    }

    public void grabar() {
        try {
            FacadeMantUsuario.guardarUsuario(usuarioData.getUsuario());
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Operación Exitosa",
                    "Usuario " + (usuarioData.getUsuario().getId() == 0 ? "Guardado" : "Modificado") + " Exitosamente");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            limpiar();
        } catch (Exception exc) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Guardar Usuario", exc.getCause().getMessage());
            PrimeFaces.current().dialog().showMessageDynamic(message);
            throw exc;
        }
    }

    public void limpiar() {
        usuarioData.setSeleccion(null);
        usuarioData.setUsuario(null);
        usuarioData.setUsuarios(FacadeMantUsuario.findAllUsuarios());
    }

    public void anular() {
        try {
            usuarioData.getUsuario().setEstado("Inactivo");
            FacadeMantUsuario.guardarUsuario(usuarioData.getUsuario());
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Operación Exitosa",
                    "Usuario Anulado Exitosamente");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            limpiar();
        } catch (Exception exc) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al anular Usuario", exc.getCause().getMessage());
            PrimeFaces.current().dialog().showMessageDynamic(message);
            throw exc;
        }
    }

    public void eliminar() {
        try {
            FacadeMantUsuario.eliminarUsuario(usuarioData.getUsuario());
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Operación Exitosa",
                    "Usuario Eliminado Exitosamente");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            limpiar();
        } catch (Exception exc) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar Usuario", exc.getCause().getMessage());
            PrimeFaces.current().dialog().showMessageDynamic(message);
            throw exc;
        }
    }
    
    public void salir(){
        
    }

}
