/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.data;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ModuloSeg.modelo.Page;
import ModuloSeg.modelo.Usuario;

/**
 *
 * @author Ellet
 */
@Named
@ViewScoped
public class PermUsrDataMB implements Serializable {

    private List<Usuario> usuarios;
    private Usuario seleccion;
    private List<Page> paginas;

    public PermUsrDataMB() {
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Usuario seleccion) {
        this.seleccion = seleccion;
    }

    public List<Page> getPaginas() {
        return paginas;
    }

    public void setPaginas(List<Page> paginas) {
        this.paginas = paginas;
    }
    
    
    
    
    
}
