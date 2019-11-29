/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.seguridad;

import modelo.general.Sucursal;
import modelo.general.Empresa;
import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
public class Usuario implements Serializable{

    private int id;
    
    private String nombre;
    private GrupoUsuario grupousuario;
    private Sucursal sucursal;
    private String Usuario;
    private String contrasena;
    private String estado;
    private Empresa empresa;
    private Roles rol_usuario;

    public Usuario() {
    }

    public Usuario(int id, String nombre, GrupoUsuario grupousuario, Sucursal sucursal, String Usuario, String contrasena, String estado, Empresa empresa, Roles rol_user) {
        this.id = id;
        this.nombre = nombre;
        this.grupousuario = grupousuario;
        this.sucursal = sucursal;
        this.Usuario = Usuario;
        this.contrasena = contrasena;
        this.estado = estado;
        this.empresa = empresa;
        this.rol_usuario= rol_user;
    }

    public Usuario(String nombre, GrupoUsuario grupousuario, Sucursal sucursal, String Usuario, String contrasena, String estado, Empresa empresa, Roles rol_user) {
        this.nombre = nombre;
        this.grupousuario = grupousuario;
        this.sucursal = sucursal;
        this.Usuario = Usuario;
        this.contrasena = contrasena;
        this.estado = estado;
        this.empresa = empresa;
        this.rol_usuario= rol_user;
    }

    public Roles getRol_usuario() {
        return rol_usuario;
    }

    public void setRol_usuario(Roles rol_usuario) {
        this.rol_usuario = rol_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public GrupoUsuario getGrupousuario() {
        return grupousuario;
    }

    public void setGrupousuario(GrupoUsuario grupousuario) {
        this.grupousuario = grupousuario;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", grupousuario=" + grupousuario + ", sucursal=" + sucursal + ", Usuario=" + Usuario + ", contrasena=" + contrasena + ", estado=" + estado + ", empresa=" + empresa + ", rolusuario=" + rol_usuario + '}';
    }

   

}
