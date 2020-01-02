package beans.transactions;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import beans.data.MantUsuarioDataMB;
import facade.FacadeMantUsuario;
import modelo.general.Empresa;
import modelo.seguridad.Usuario;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.primefaces.event.SelectEvent;
import facade.IFacadeMantUsuario;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import listeners.seguridad.SegUsuariosListener;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Lenovo
 */
@Named
@ViewScoped
public class MantenimientoUsuarioMB implements Serializable {

    @Inject
    private MantUsuarioDataMB usuarioData;
    private IFacadeMantUsuario facadeMantUsuario;

    @PostConstruct
    public void init() {
        usuarioData.setUsuario(new Usuario());
        facadeMantUsuario = new FacadeMantUsuario();
        usuarioData.setEmpresas(facadeMantUsuario.findAllEmpresas());
        usuarioData.setGruposUsuarios(facadeMantUsuario.findAllGruposUsuarios());
        usuarioData.setUsuarios(facadeMantUsuario.findAllUsuarios());

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
            usuarioData.setSucursales(facadeMantUsuario.findSucursalesByEmpresa(empresa.getId()));
        }
        usuarioData.setUsuario(usuarioData.getSeleccion());
        //System.out.println(usuarioData.getSeleccion().toString());

    }

    public void onEmpresaChange() {
        Empresa empresa = usuarioData.getUsuario().getEmpresa();
        if (empresa != null) {
            usuarioData.setSucursales(facadeMantUsuario.findSucursalesByEmpresa(empresa.getId()));
        }
    }

    public void grabar() {

        try {

//            SegUsuariosListener usuario_ex = new SegUsuariosListener();
//            usuario_ex.usuarioExiste(usuarioData.getUsuario().getNombre());

            facadeMantUsuario.guardarUsuario(usuarioData.getUsuario());
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Operación Exitosa",
                    "Usuario " + (usuarioData.getUsuario().getId() == 0 ? "Guardado" : "Modificado") + " Exitosamente");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            limpiar();
        } catch (Exception exc) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Guardar Usuario", exc.getCause().getMessage());
            PrimeFaces.current().dialog().showMessageDynamic(message);
           
        }
    }

    public void limpiar() {
        usuarioData.setSeleccion(null);
        usuarioData.setUsuario(null);
        usuarioData.setUsuarios(facadeMantUsuario.findAllUsuarios());
    }

    public void anular() {
        try {
            usuarioData.getUsuario().setEstado("Inactivo");
            facadeMantUsuario.guardarUsuario(usuarioData.getUsuario());
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
            facadeMantUsuario.eliminarUsuario(usuarioData.getUsuario());
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

    public void salir() {

    }

}
