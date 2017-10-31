/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloGen.facade;

import java.util.List;
import ModuloSeg.modelo.GrupoUsuario;
import ModuloSeg.modelo.Page;
import ModuloSeg.modelo.Usuario;

/**
 *
 * @author Ellet
 */
public interface IFacadePermUsr {

    List<Usuario> getAllUsuarios();
    
    List<Page> getAllPermisosUsuario(Usuario usuario);
    
    void guardarPermisos(List<Page> pages, Usuario usuario);
    
}
