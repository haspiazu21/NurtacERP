/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeg.mappers;

import ModuloSeg.entities.SegMenus;
import ModuloSeg.entities.SegPermisosgrupos;
import ModuloSeg.entities.SegPermisosusuarios;
import java.util.List;
import ModuloSeg.modelo.GrupoUsuario;
import ModuloSeg.modelo.Page;
import ModuloSeg.modelo.Usuario;

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
