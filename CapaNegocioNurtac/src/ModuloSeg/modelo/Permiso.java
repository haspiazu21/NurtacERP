/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeg.modelo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ellet
 */
public class Permiso implements Serializable {
    
    private boolean asignado;
    private boolean guardar;
    private boolean buscar;
    private boolean modificar;
    private boolean imprimir;
    private boolean anular;
    private boolean eliminar;

    public Permiso() {
    }

    public Permiso(boolean asignado, boolean guardar, boolean buscar, boolean modificar, boolean imprimir, boolean anular, boolean eliminar) {
        this.asignado = asignado;
        this.guardar = guardar;
        this.buscar = buscar;
        this.modificar = modificar;
        this.imprimir = imprimir;
        this.anular = anular;
        this.eliminar = eliminar;
    }

    public boolean getAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    public boolean getGuardar() {
        return guardar;
    }

    public void setGuardar(boolean guardar) {
        this.guardar = guardar;
    }

    public boolean getBuscar() {
        return buscar;
    }

    public void setBuscar(boolean buscar) {
        this.buscar = buscar;
    }

    public boolean getModificar() {
        return modificar;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    public boolean getImprimir() {
        return imprimir;
    }

    public void setImprimir(boolean imprimir) {
        this.imprimir = imprimir;
    }

    public boolean getAnular() {
        return anular;
    }

    public void setAnular(boolean anular) {
        this.anular = anular;
    }

    public boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    
    
}
