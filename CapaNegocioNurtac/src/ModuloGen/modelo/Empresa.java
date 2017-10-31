/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloGen.modelo;

import java.io.Serializable;

/**
 *
 * @author Ellet
 */
public class Empresa implements Serializable{

    private int id;
    private String cedRepLegal;
    private String comercial;
    private String estado;
    private String nombre;
    private String repLegal;

    public Empresa(int id, String cedRepLegal, String comercial, String estado, String nombre, String repLegal) {
        this.id = id;
        this.cedRepLegal = cedRepLegal;
        this.comercial = comercial;
        this.estado = estado;
        this.nombre = nombre;
        this.repLegal = repLegal;
    }

    public Empresa() {
    }

    public Empresa(String cedRepLegal, String comercial, String estado, String nombre, String repLegal) {
        this.cedRepLegal = cedRepLegal;
        this.comercial = comercial;
        this.estado = estado;
        this.nombre = nombre;
        this.repLegal = repLegal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedRepLegal() {
        return cedRepLegal;
    }

    public void setCedRepLegal(String cedRepLegal) {
        this.cedRepLegal = cedRepLegal;
    }

    public String getComercial() {
        return comercial;
    }

    public void setComercial(String comercial) {
        this.comercial = comercial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRepLegal() {
        return repLegal;
    }

    public void setRepLegal(String repLegal) {
        this.repLegal = repLegal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empresa other = (Empresa) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Empresa[%d, %s, %s, %s, %s, %s]", id, cedRepLegal, comercial, estado, nombre, repLegal);
    }

}
