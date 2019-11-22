/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import modelo.seguridad.GrupoUsuario;
import modelo.seguridad.Page;
import modelo.seguridad.Usuario;

/**
 *
 * @author Ellet
 */
public interface IFacadePermUsr {

    List<Usuario> getAllUsuarios();
    
    List<Page> getAllPermisosUsuario(Usuario usuario);
    
    void guardarPermisos(List<Page> pages, Usuario usuario);
    
}
