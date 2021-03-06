/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.seguridad.GrupoUsuarioDAO;
import dao.seguridad.IGrupoUsuarioDAO;
import dao.seguridad.IMenuDAO;
import dao.seguridad.IPermisoGrupoDAO;
import dao.seguridad.IPermisoUsuarioDAO;
import dao.seguridad.MenuDAO;
import dao.seguridad.PermisoGrupoDAO;
import dao.seguridad.PermisoUsuarioDAO;
import entities.seguridad.SegGruposusuarios;
import entities.seguridad.SegMenus;
import entities.seguridad.SegPermisosgrupos;
import java.util.ArrayList;
import java.util.List;
import mappers.seguridad.GrupoUsuarioMapper;
import mappers.seguridad.IGrupoUsuarioMapper;
import mappers.seguridad.IPageMapper;
import mappers.seguridad.PageMapper;
import modelo.seguridad.GrupoUsuario;
import modelo.seguridad.Page;

/**
 *
 * @author Ellet
 */
public class FacadePermGrupo implements IFacadePermGrupo {

    /*
    Data Transfer Objects (DAO)
     */
    private final IGrupoUsuarioDAO grupoUsuarioDAO;
    private final IMenuDAO menuDAO;
    private final IPermisoGrupoDAO permisoGrupoDAO;
    /*
    DTO Mappers
     */
    private final IGrupoUsuarioMapper grupoUsuarioMapper;
    private final IPageMapper pageMapper;

    public FacadePermGrupo() {
        grupoUsuarioDAO = new GrupoUsuarioDAO();
        menuDAO = new MenuDAO();
        permisoGrupoDAO = new PermisoGrupoDAO();

        grupoUsuarioMapper = new GrupoUsuarioMapper();
        pageMapper = new PageMapper();
    }

    @Override

    public List<GrupoUsuario> getAllGruposUsuarios() {
        List<GrupoUsuario> gruposUsuarios = new ArrayList<>();
        List<SegGruposusuarios> entites = grupoUsuarioDAO.findAll();

        for (SegGruposusuarios entity : entites) {
            GrupoUsuario grupoUsuario = grupoUsuarioMapper.entityToModel(entity);
            gruposUsuarios.add(grupoUsuario);
        }

        return gruposUsuarios;
    }

    @Override
    public List<Page> getAllPermisosGrupo(GrupoUsuario grupoUsuario) {
        List<Page> pages = new ArrayList<>();
        List<SegMenus> entities = menuDAO.findAll();
        List<SegPermisosgrupos> permisosEntities = permisoGrupoDAO.findByGrupoUsuario(grupoUsuario.getId());
        for (SegMenus entity : entities) {
            Page page = pageMapper.entityToModel(entity, permisosEntities);
            pages.add(page);
        }

        return pages;
    }

    @Override
    public void guardarPermisos(List<Page> pages, GrupoUsuario grupoUsuario) {
        List<SegPermisosgrupos> permisosGrupos = new ArrayList<>();
        System.err.println("llego hasta aqui:" + pages.size() + " es el tamaño de la lista");
        for (Page page : pages) {
            System.err.println("Asignado:" + page.getPermiso().getAsignado());
            if (page.getPermiso().getAsignado()) {
                SegPermisosgrupos segPermisosgrupos = pageMapper.entityToModel(page, grupoUsuario);
                permisosGrupos.add(segPermisosgrupos);
            }

        }

        permisoGrupoDAO.create(permisosGrupos, grupoUsuario.getId());

    }

}
