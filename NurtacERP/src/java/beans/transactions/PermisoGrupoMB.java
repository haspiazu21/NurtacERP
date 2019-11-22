/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.transactions;

import beans.data.PermGrpDataMB;
import facade.FacadePermGrupo;
import facade.IFacadePermGrupo;
import modelo.seguridad.Page;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.seguridad.GrupoUsuario;
import modelo.seguridad.Permiso;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Lenovo
 */
@Named
@RequestScoped
public class PermisoGrupoMB implements Serializable {

    @Inject
    private PermGrpDataMB permGrpDataMB;
    private IFacadePermGrupo facadePermGrupo;

    @PostConstruct
    public void init() {

        facadePermGrupo = new FacadePermGrupo();

        permGrpDataMB.setGruposUsuarios(facadePermGrupo.getAllGruposUsuarios());
    }

    public PermisoGrupoMB() {
    }

    public PermGrpDataMB getPermGrpDataMB() {
        return permGrpDataMB;
    }

    public void setPermGrpDataMB(PermGrpDataMB permGrpDataMB) {
        this.permGrpDataMB = permGrpDataMB;
    }

    public void onRowSelect(SelectEvent event) {
        permGrpDataMB.setSeleccion((GrupoUsuario) event.getObject());
        permGrpDataMB.setPaginas(facadePermGrupo.getAllPermisosGrupo(permGrpDataMB.getSeleccion()));

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
        facadePermGrupo.guardarPermisos(permGrpDataMB.getPaginas(), permGrpDataMB.getSeleccion());
//        for(Page page : permGrpDataMB.getPaginas()){
//            System.err.println(page.getNombre().toUpperCase());
//            System.err.println("Asignado:" + page.getPermiso().getAsignado());
//            System.err.println("Anular:" + page.getPermiso().getAnular());
//            System.err.println("Buscar:" + page.getPermiso().getBuscar());
//            System.err.println("Eliminar:" + page.getPermiso().getEliminar());
//            System.err.println("Guardar:" + page.getPermiso().getGuardar());
//            System.err.println("Imprimir:" + page.getPermiso().getImprimir());
//            System.err.println("Modificar:" + page.getPermiso().getModificar());
//        }
        permGrpDataMB.setSeleccion(null);
        permGrpDataMB.setPaginas(new ArrayList<>());
    }

}
