/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.seguridad;

/**
 *
 * @author hac
 */
public class Roles {

    private int codigo;
    private String nombre;
    private String modulo;
    private String submodulo;
    private String Estado;

    public Roles() {
    }

    public Roles(int codigo, String nombre, String modulo, String submodulo, String Estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.modulo = modulo;
        this.submodulo = submodulo;
        this.Estado = Estado;
    }

    public Roles(String nombre, String modulo, String submodulo, String Estado) {

        this.nombre = nombre;
        this.modulo = modulo;
        this.submodulo = submodulo;
        this.Estado = Estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getSubmodulo() {
        return submodulo;
    }

    public void setSubmodulo(String submodulo) {
        this.submodulo = submodulo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.codigo;
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
        final Roles other = (Roles) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

}
