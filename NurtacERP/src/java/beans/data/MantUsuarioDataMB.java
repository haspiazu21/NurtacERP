/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.data;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import ModuloGen.modelo.Empresa;
import ModuloGen.modelo.Sucursal;
import ModuloSeg.modelo.GrupoUsuario;
import ModuloSeg.modelo.Usuario;

/**
 *
 * @author Ellet
 */
@Named
@ViewScoped
public class MantUsuarioDataMB implements Serializable {

    private List<Usuario> usuarios;
    private Usuario usuario;
    private Usuario seleccion;
    private List<GrupoUsuario> gruposUsuarios;
    private List<Empresa> empresas;
    private List<Sucursal> sucursales;

    public MantUsuarioDataMB() {
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Usuario seleccion) {
        this.seleccion = seleccion;
    }

    public List<GrupoUsuario> getGruposUsuarios() {
        return gruposUsuarios;
    }

    public void setGruposUsuarios(List<GrupoUsuario> gruposUsuarios) {
        this.gruposUsuarios = gruposUsuarios;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

}
