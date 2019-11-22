/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import modelo.seguridad.GrupoUsuario;
import modelo.seguridad.Page;

/**
 *
 * @author Ellet
 */
public interface IFacadePermGrupo {
    
    List<GrupoUsuario> getAllGruposUsuarios();
    
    List<Page> getAllPermisosGrupo(GrupoUsuario grupoUsuario);
    
    void guardarPermisos(List<Page> pages, GrupoUsuario grupoUsuario);
}
