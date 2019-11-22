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
import modelo.seguridad.GrupoUsuario;

/**
 *
 * @author Ellet
 */
@Named
@ViewScoped
public class MantGrpUsrDataMB implements Serializable{

    private List<GrupoUsuario> gruposUsuarios;
    private GrupoUsuario grupoUsuario;
    private GrupoUsuario seleccion;

    public MantGrpUsrDataMB() {
    }

    public List<GrupoUsuario> getGruposUsuarios() {
        return gruposUsuarios;
    }

    public void setGruposUsuarios(List<GrupoUsuario> gruposUsuarios) {
        this.gruposUsuarios = gruposUsuarios;
    }

    public GrupoUsuario getGrupoUsuario() {
        return grupoUsuario;
    }

    public void setGrupoUsuario(GrupoUsuario grupoUsuario) {
        this.grupoUsuario = grupoUsuario;
    }

    public GrupoUsuario getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(GrupoUsuario seleccion) {
        this.seleccion = seleccion;
    }

   
    
    
    
    
}
