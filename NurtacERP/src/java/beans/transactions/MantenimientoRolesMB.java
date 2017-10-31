/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.transactions;

import ModuloSeg.modelo.Roles;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Lenovo
 */
@ManagedBean
@RequestScoped
public class MantenimientoRolesMB implements Serializable {
    private List<Roles> listrol;
    private Roles roles;

    public MantenimientoRolesMB() {
        
        Roles rol1= new Roles(1,"Administración de Usuarios" ,"Seguridad", "Mantenimiento", "Activo");
        Roles rol2= new Roles(2,"Asignar permisos de Usuarios" ,"Seguridad", "Transacciones", "Activo");
        Roles rol3= new Roles(3,"Mantenimiento de Productos" ,"inventario", "Mantenimiento", "Inactivo");
        Roles rol4= new Roles(4,"Mantenimiento de Grupos" ,"Inventario", "Mantenimiento", "Activo");

        listrol = new ArrayList<>();

        listrol.add(rol1);
        listrol.add(rol2);
        listrol.add(rol3);
        listrol.add(rol4);
    }


    public List<Roles> getListrol() {
        return listrol;
    }

    public void setListrol(List<Roles> listrol) {
        this.listrol = listrol;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
    
      public void onRowSelect(SelectEvent event) {
        roles = (Roles) event.getObject();
    }

}
