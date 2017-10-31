/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloGen.modelo;

import ModuloGen.modelo.Empresa;
import java.io.Serializable;

/**
 *
 * @author Ellet
 */
public class Sucursal implements Serializable {

    private int id;
    private String direccion;
    private String email;
    private String estado;
    private String nombre;
    private String telefono;
    private Empresa empresa;
    private String ruc;

    public Sucursal() {
    }

    public Sucursal(int id, String direccion, String email, String estado, String nombre, String telefono, Empresa empresa, String ruc) {
        this.id = id;
        this.direccion = direccion;
        this.email = email;
        this.estado = estado;
        this.nombre = nombre;
        this.telefono = telefono;
        this.empresa = empresa;
        this.ruc = ruc;
    }

    public Sucursal(String direccion, String email, String estado, String nombre, String telefono, Empresa empresa, String ruc) {
        this.direccion = direccion;
        this.email = email;
        this.estado = estado;
        this.nombre = nombre;
        this.telefono = telefono;
        this.empresa = empresa;
        this.ruc = ruc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.id;
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
        final Sucursal other = (Sucursal) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Sucursal[%d, %s, %s, %s, %s, %s, %s]", id, direccion, email, estado, nombre, telefono, empresa);
    }

}
