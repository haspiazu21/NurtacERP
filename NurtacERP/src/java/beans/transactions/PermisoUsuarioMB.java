/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.transactions;

import beans.data.PermUsrDataMB;
import ModuloGen.facade.FacadePermUsr;
import ModuloGen.facade.IFacadePermUsr;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ModuloSeg.modelo.Page;
import ModuloSeg.modelo.Usuario;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Ellet
 */
@Named
@RequestScoped
public class PermisoUsuarioMB implements Serializable {

    @Inject
    private PermUsrDataMB permUsrDataMB;
    private IFacadePermUsr FacadePermUsr;

    @PostConstruct
    public void init() {
        FacadePermUsr = new FacadePermUsr();
        permUsrDataMB.setUsuarios(FacadePermUsr.getAllUsuarios());
    }

    public PermisoUsuarioMB() {
    }

    public PermUsrDataMB getPermUsrDataMB() {
        return permUsrDataMB;
    }

    public void setPermUsrDataMB(PermUsrDataMB permUsrDataMB) {
        this.permUsrDataMB = permUsrDataMB;
    }

    public IFacadePermUsr getFacadePermUsr() {
        return FacadePermUsr;
    }

    public void setFacadePermUsr(IFacadePermUsr FacadePermUsr) {
        this.FacadePermUsr = FacadePermUsr;
    }

    public void onRowSelect(SelectEvent event) {
        permUsrDataMB.setSeleccion((Usuario) event.getObject());
        permUsrDataMB.setPaginas(FacadePermUsr.getAllPermisosUsuario(permUsrDataMB.getSeleccion()));
    }

    public void resetearChecks(Page page) {
        if (!page.getPermiso().getAsignado()) {
            page.getPermiso().setAnular(false);
            page.getPermiso().setBuscar(false);
            page.getPermiso().setEliminar(false);
            page.getPermiso().setGuardar(false);
            page.getPermiso().setImprimir(false);
            page.getPermiso().setModificar(false);
        }
    }

    public boolean getState(Page page, int rowNum) {

        switch (rowNum) {
            case 3:
                if (!page.getPermisosMenu().getGuardar()) {
                    return true;
                }
                break;
            case 4:
                if (!page.getPermisosMenu().getBuscar()) {
                    return true;
                }
                break;
            case 5:
                if (!page.getPermisosMenu().getModificar()) {
                    return true;
                }
                break;
            case 6:
                if (!page.getPermisosMenu().getImprimir()) {
                    return true;
                }
                break;
            case 7:
                if (!page.getPermisosMenu().getAnular()) {
                    return true;
                }
                break;
            case 8:
                if (!page.getPermisosMenu().getEliminar()) {
                    return true;
                }
                break;
        }

        return !page.getPermiso().getAsignado();
    }

    public void guardar() {
        FacadePermUsr.guardarPermisos(permUsrDataMB.getPaginas(), permUsrDataMB.getSeleccion());
        permUsrDataMB.setSeleccion(null);
        permUsrDataMB.setPaginas(new ArrayList<>());
    }

}
