/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.transactions;

import beans.data.MantGrpUsrDataMB;
import beans.data.MantRolDataMB;
import entities.seguridad.SegRoles;
import facade.FacadeMantGrupoUsuario;
import facade.FacadeRol;
import facade.IFacadeMantGrupoUsuario;
import facade.IFacadeRol;
import modelo.seguridad.Roles;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import modelo.seguridad.GrupoUsuario;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Lenovo
 */
@ManagedBean
@RequestScoped
public class MantenimientoRolesMB implements Serializable {

    @Inject
    private MantRolDataMB mantRolDataMB;
    private IFacadeRol facadeMantRol;

    private List<Roles> lista_rol;
    private IFacadeRol frol;

    @PostConstruct
    public void init() {
        //mantRolDataMB.setLroles(new Roles());
        facadeMantRol = new FacadeRol();
        mantRolDataMB.setLroles(facadeMantRol.getAllRoles());
    }

    public void limpiar() {
        mantRolDataMB.setLroles(null);
        mantRolDataMB.setLroles(facadeMantRol.getAllRoles());
    }
    
        public void onRowSelect(SelectEvent event) {
        mantRolDataMB.setLroles(facadeMantRol.getAllRoles());
    }

    public MantRolDataMB getMantRolDataMB() {
        return mantRolDataMB;
    }

    public void setMantRolDataMB(MantRolDataMB mantRolDataMB) {
        this.mantRolDataMB = mantRolDataMB;
    }

    public IFacadeRol getFacadeMantRol() {
        return facadeMantRol;
    }

    public void setFacadeMantRol(IFacadeRol facadeMantRol) {
        this.facadeMantRol = facadeMantRol;
    }

    public MantenimientoRolesMB() {

        Roles rol1 = new Roles(1, "Administración de Usuarios", "Seguridad", "Mantenimiento", "Activo");
        Roles rol2 = new Roles(2, "Asignar permisos de Usuarios", "Seguridad", "Transacciones", "Activo");
        Roles rol3 = new Roles(3, "Mantenimiento de Productos", "inventario", "Mantenimiento", "Inactivo");
        Roles rol4 = new Roles(4, "Mantenimiento de Grupos", "Inventario", "Mantenimiento", "Activo");
        

//        init();

//        lista_rol = new ArrayList<>();
//        List<Roles> lrol = mantRolDataMB.getLroles();
//
//        System.out.println("Roles: " + lrol.get(0));
//        
//        for (Roles fcroles : lrol) {
//            lista_rol.add(fcroles);
//            //System.out.println("Roles: " + listrol.get(1));
//        }
        lista_rol.add(rol1);
        lista_rol.add(rol2);
        lista_rol.add(rol3);
        lista_rol.add(rol4);

    }

}
