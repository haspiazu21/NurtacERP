/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.seguridad;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author hac
 */
public class Bitacora implements Serializable {

    int codigo;
    String accion;
    String empresa;
    Date fecha;
    String grupousuario;
    String modulo;
    String sucursal;
    String usuario;

    public Bitacora() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getGrupousuario() {
        return grupousuario;
    }

    public void setGrupousuario(String grupousuario) {
        this.grupousuario = grupousuario;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Bitacora(int codigo, String accion, Date fecha, String usuario) {
        this.codigo = codigo;
        this.accion = accion;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public Bitacora(int codigo, String accion, String empresa, Date fecha, String grupousuario, String modulo, String sucursal, String usuario) {
        this.codigo = codigo;
        this.accion = accion;
        this.empresa = empresa;
        this.fecha = fecha;
        this.grupousuario = grupousuario;
        this.modulo = modulo;
        this.sucursal = sucursal;
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.codigo;
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
        final Bitacora other = (Bitacora) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bitacora{" + "codigo=" + codigo + ", accion=" + accion + ", empresa=" + empresa + ", fecha=" + fecha + ", grupousuario=" + grupousuario + ", modulo=" + modulo + ", sucursal=" + sucursal + ", usuario=" + usuario + '}';
    }

}
