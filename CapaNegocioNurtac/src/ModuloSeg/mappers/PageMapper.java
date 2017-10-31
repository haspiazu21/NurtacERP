/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeg.mappers;

import ModuloGen.entities.GenEmpresas;
import ModuloGen.entities.GenSucursales;
import ModuloSeg.entities.SegMenus;
import ModuloSeg.entities.SegPermisosgrupos;
import ModuloSeg.entities.SegPermisosgruposPK;
import ModuloSeg.entities.SegPermisosusuarios;
import ModuloSeg.entities.SegPermisosusuariosPK;
import java.util.List;
import ModuloSeg.modelo.GrupoUsuario;
import ModuloSeg.modelo.Page;
import ModuloSeg.modelo.Permiso;
import ModuloSeg.modelo.Usuario;

/**
 *
 * @author Ellet
 */
public class PageMapper implements IPageMapper {

    @Override
    public Page entityToModel(SegMenus menuEntity, List<SegPermisosgrupos> permisosEntities) {

        if (menuEntity == null) {
            return null;
        }

        Permiso permiso = new Permiso();

        for (SegPermisosgrupos permisosEntity : permisosEntities) {
            if (permisosEntity.getSegPermisosgruposPK().getMenuid() == menuEntity.getMenuid()) {
                permiso.setAnular(permisosEntity.getAnular());
                permiso.setAsignado(true);
                permiso.setBuscar(permisosEntity.getBuscar());
                permiso.setEliminar(permisosEntity.getEliminar());
                permiso.setGuardar(permisosEntity.getGuardar());
                permiso.setImprimir(permisosEntity.getImprimir());
                permiso.setModificar(permisosEntity.getModificar());
            }
        }

        Permiso permisoMenu = new Permiso(
                true,
                menuEntity.isGuardar(),
                menuEntity.isBuscar(),
                menuEntity.isModificar(),
                menuEntity.isImprimir(),
                menuEntity.isAnular(),
                menuEntity.isEliminar()
        );

        Page page = new Page();
        page.setCodigo(menuEntity.getMenuid());
        page.setModulo(menuEntity.getModuloid().getNombre());
        page.setNombre(menuEntity.getNombre());
        page.setPermiso(permiso);
        page.setPermisosMenu(permisoMenu);
        return page;
    }

    @Override
    public SegPermisosgrupos entityToModel(Page page, GrupoUsuario grupoUsuario) {

        if (page == null) {
            return null;
        }

        SegPermisosgruposPK pk = new SegPermisosgruposPK();
        pk.setGrupousuarioid(grupoUsuario.getId());
        pk.setMenuid(page.getCodigo());

        SegPermisosgrupos permisos = new SegPermisosgrupos();
        permisos.setAnular(page.getPermiso().getAnular());
        permisos.setBuscar(page.getPermiso().getBuscar());
        permisos.setEliminar(page.getPermiso().getEliminar());
        permisos.setGuardar(page.getPermiso().getGuardar());
        permisos.setImprimir(page.getPermiso().getImprimir());
        permisos.setModificar(page.getPermiso().getModificar());
        permisos.setSegPermisosgruposPK(pk);

        return permisos;

    }

    @Override
    public Page entityToModelU(SegMenus menuEntity, List<SegPermisosusuarios> permisosEntities) {
        if (menuEntity == null) {
            return null;
        }

        Permiso permiso = new Permiso();

        for (SegPermisosusuarios permisosEntity : permisosEntities) {
            if (permisosEntity.getSegPermisosusuariosPK().getMenuid() == menuEntity.getMenuid()) {
                permiso.setAnular(permisosEntity.getAnular());
                permiso.setAsignado(true);
                permiso.setBuscar(permisosEntity.getBuscar());
                permiso.setEliminar(permisosEntity.getEliminar());
                permiso.setGuardar(permisosEntity.getGuardar());
                permiso.setImprimir(permisosEntity.getImprimir());
                permiso.setModificar(permisosEntity.getModificar());
            }
        }

        Permiso permisoMenu = new Permiso(
                true,
                menuEntity.isGuardar(),
                menuEntity.isBuscar(),
                menuEntity.isModificar(),
                menuEntity.isImprimir(),
                menuEntity.isAnular(),
                menuEntity.isEliminar()
        );

        Page page = new Page();
        page.setCodigo(menuEntity.getMenuid());
        page.setModulo(menuEntity.getModuloid().getNombre());
        page.setNombre(menuEntity.getNombre());
        page.setPermiso(permiso);
        page.setPermisosMenu(permisoMenu);
        return page;
    }

    @Override
    public SegPermisosusuarios entityToModel(Page page, Usuario usuario) {
        if (page == null) {
            return null;
        }

        SegPermisosusuariosPK pk = new SegPermisosusuariosPK();
        pk.setUsuarioid(usuario.getId());
        pk.setMenuid(page.getCodigo());

        SegPermisosusuarios permisos = new SegPermisosusuarios();
        permisos.setAnular(page.getPermiso().getAnular());
        permisos.setBuscar(page.getPermiso().getBuscar());
        permisos.setEliminar(page.getPermiso().getEliminar());
        permisos.setGuardar(page.getPermiso().getGuardar());
        permisos.setImprimir(page.getPermiso().getImprimir());
        permisos.setModificar(page.getPermiso().getModificar());
        permisos.setSegPermisosusuariosPK(pk);

        return permisos;
    }

}
