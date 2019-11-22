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
import modelo.seguridad.Page;

/**
 *
 * @author Ellet
 */
@Named
@ViewScoped
public class PermGrpDataMB implements Serializable {

    private List<GrupoUsuario> gruposUsuarios;
    private GrupoUsuario seleccion;
    private List<Page> paginas;

    public PermGrpDataMB() {
    }

    public List<GrupoUsuario> getGruposUsuarios() {
        return gruposUsuarios;
    }

    public void setGruposUsuarios(List<GrupoUsuario> gruposUsuarios) {
        this.gruposUsuarios = gruposUsuarios;
    }

    public GrupoUsuario getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(GrupoUsuario seleccion) {
        this.seleccion = seleccion;
    }

    public List<Page> getPaginas() {
        return paginas;
    }

    public void setPaginas(List<Page> paginas) {
        this.paginas = paginas;
    }

}
