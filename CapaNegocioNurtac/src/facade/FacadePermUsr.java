/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.seguridad.IMenuDAO;
import dao.seguridad.IPermisoUsuarioDAO;
import dao.seguridad.IUsuarioDAO;
import dao.seguridad.MenuDAO;
import dao.seguridad.PermisoUsuarioDAO;
import dao.seguridad.UsuarioDAO;
import entities.seguridad.SegMenus;
import entities.seguridad.SegPermisosusuarios;
import entities.seguridad.SegUsuarios;
import java.util.ArrayList;
import java.util.List;
import mappers.seguridad.IPageMapper;
import mappers.seguridad.IUsuarioMapper;
import mappers.seguridad.PageMapper;
import mappers.seguridad.UsuarioMapper;
import modelo.seguridad.Page;
import modelo.seguridad.Usuario;

/**
 *
 * @author Ellet
 */
public class FacadePermUsr implements IFacadePermUsr {

    /*
    DAO's (Data Access Objects)
     */
    private final IUsuarioDAO usuarioDAO;
    private final IMenuDAO menuDAO;
    private final IPermisoUsuarioDAO permisoUsuarioDAO;
    /*
    DTO's (Data Transfer Objects)
     */
    private final IPageMapper pageMapper;
    private final IUsuarioMapper usuarioMapper;

    public FacadePermUsr() {
        usuarioDAO = new UsuarioDAO();
        menuDAO = new MenuDAO();
        permisoUsuarioDAO = new PermisoUsuarioDAO();

        pageMapper = new PageMapper();
        usuarioMapper = new UsuarioMapper();

    }

    @Override
    public List<Usuario> getAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        List<SegUsuarios> entities = usuarioDAO.findAll();
        for (SegUsuarios entity : entities) {
            Usuario usuario = usuarioMapper.entityToModel(entity);
            usuarios.add(usuario);
        }
        return usuarios;
    }

    @Override
    public List<Page> getAllPermisosUsuario(Usuario usuario) {
        List<Page> pages = new ArrayList<>();
        List<SegMenus> entities = menuDAO.findAll();
        List<SegPermisosusuarios> permisosEntities = permisoUsuarioDAO.findByUsuario(usuario.getId());
        for (SegMenus entity : entities) {
            Page page = pageMapper.entityToModelU(entity, permisosEntities);
            pages.add(page);
        }
        return pages;
    }

    @Override
    public void guardarPermisos(List<Page> pages, Usuario usuario) {
        List<SegPermisosusuarios> permisosUsuarios = new ArrayList<>();
        for (Page page : pages) {
            if (page.getPermiso().getAsignado()) {
                SegPermisosusuarios segPermisosusuarios = pageMapper.entityToModel(page, usuario);
                permisosUsuarios.add(segPermisosusuarios);
            }

        }

        permisoUsuarioDAO.create(permisosUsuarios, usuario.getId());

    }

}
