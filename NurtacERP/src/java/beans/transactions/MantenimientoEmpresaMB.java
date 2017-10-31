/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.transactions;

import ModuloGen.modelo.Empresa;
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
public class MantenimientoEmpresaMB {

    private List<Empresa> listempresa;
    private Empresa empresa;

    public MantenimientoEmpresaMB() {

        Empresa emp1 = new Empresa(1, "Nurtac", "Centro-Sur", "00000", "00000", "A");
        Empresa emp2 = new Empresa(2, "Asesoral", "Sur", "0001", "00002", "A");

        listempresa = new ArrayList<>();

        listempresa.add(emp1);
        listempresa.add(emp2);

    }

    public List<Empresa> getListempresa() {
        return listempresa;
    }

    public void setListempresa(List<Empresa> listempresa) {
        this.listempresa = listempresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void onRowSelect(SelectEvent event) {
        empresa = (Empresa) event.getObject();
    }

}
