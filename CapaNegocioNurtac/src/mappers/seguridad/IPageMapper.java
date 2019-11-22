/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers.seguridad;

import entities.seguridad.SegMenus;
import entities.seguridad.SegPermisosgrupos;
import entities.seguridad.SegPermisosusuarios;
import java.util.List;
import modelo.seguridad.GrupoUsuario;
import modelo.seguridad.Page;
import modelo.seguridad.Usuario;

/**
 *
 * @author Ellet
 */
public interface IPageMapper {

    Page entityToModel(SegMenus menuEntity, List<SegPermisosgrupos> permisosEntities);
    
    Page entityToModelU(SegMenus menuEntity, List<SegPermisosusuarios> permisosEntities);

    SegPermisosgrupos entityToModel(Page page, GrupoUsuario grupoUsuario);
    
    SegPermisosusuarios entityToModel(Page page, Usuario usuario);

}
