/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.transactions;

import ModuloGen.modelo.Empresa;
import ModuloGen.modelo.Sucursal;
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
public class MantenimientoSucursalMB {

    private List<Sucursal> listsucursal;
    private Sucursal sucursal;

    public MantenimientoSucursalMB() {

        //Sucursal sucur1 = new Sucursal(new Empresa(1, "Nurtac", "Norte", "0001", "0000", "A"),1, "Sur", "Callejon A entre la 43 y 44", "097845678", "nurtac@gmail.com", "A");

        listsucursal = new ArrayList<>();

        //listsucursal.add(sucur1);
    }

    public List<Sucursal> getListsucursal() {
        return listsucursal;
    }

    public void setListsucursal(List<Sucursal> listsucursal) {
        this.listsucursal = listsucursal;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public void onRowSelect(SelectEvent event) {
        sucursal = (Sucursal) event.getObject();
    }

}
