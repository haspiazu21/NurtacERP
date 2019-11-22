/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.seguridad.IMenuDAO;
import dao.seguridad.IModuloDAO;
import dao.seguridad.IUsuarioDAO;
import dao.seguridad.MenuDAO;
import dao.seguridad.ModuloDAO;
import dao.seguridad.UsuarioDAO;
import entities.seguridad.SegMenus;
import entities.seguridad.SegModulos;
import entities.seguridad.SegUsuarios;
import java.util.ArrayList;
import java.util.List;
import mappers.seguridad.IMenuItemMapper;
import mappers.seguridad.IMenuMapper;
import mappers.seguridad.IUsuarioMapper;
import mappers.seguridad.MenuItemMapper;
import mappers.seguridad.MenuMapper;
import mappers.seguridad.UsuarioMapper;
import modelo.seguridad.Menu;
import modelo.seguridad.MenuItem;
import modelo.seguridad.Modulo;
import modelo.seguridad.Usuario;

/**
 *
 * @author Ellet
 */
public class FacadeSeguridad implements IFacadeSeguridad {

    /*
    Data Transfer Objects (DAO)
     */
    private final IModuloDAO moduloDAO;
    private final IMenuDAO menuDAO;
    private final IUsuarioDAO usuarioDAO;
    /*
    DTO Mappers
     */
    private final IMenuMapper menuMapper;
    private final IMenuItemMapper menuItemMapper;
    private final IUsuarioMapper usuarioMapper;

    public FacadeSeguridad() {
        moduloDAO = new ModuloDAO();
        menuDAO = new MenuDAO();
        usuarioDAO = new UsuarioDAO();

        menuMapper = new MenuMapper();
        menuItemMapper = new MenuItemMapper();
        usuarioMapper = new UsuarioMapper();
    }

    @Override
    public List<Menu> getMenus(Usuario usuario) {

        List<Menu> menus = new ArrayList<>();
        List<SegModulos> menuEntities = moduloDAO.findAll();

        for (SegModulos menuEntity : menuEntities) {

            Menu menu = menuMapper.entityToModel(menuEntity);
            List<MenuItem> menuItems = new ArrayList<>();
            List<SegMenus> menuItemEntites = usuario.getGrupousuario() == null
                    ? menuDAO.findAllByPermisosUsuario(menuEntity.getModuloid(), usuario.getId())
                    : menuDAO.findAllByPermisosGrupo(menuEntity.getModuloid(), usuario.getGrupousuario().getId());

            for (SegMenus menuItemEntity : menuItemEntites) {
                MenuItem menuItem = menuItemMapper.entityToModel(menuItemEntity);
                menuItems.add(menuItem);
            }

            menu.setMenuItems(menuItems);

            if (menu.getMenuItems().size() > 0) {
                menus.add(menu);
            }

        }

        return menus;

    }

    @Override
    public Usuario getLoggedUser(String username, String password) {
        Usuario loggedUser = null;
        SegUsuarios userEntity = usuarioDAO.findByUsernamePassword(username, password);
        loggedUser = usuarioMapper.entityToModel(userEntity);
        return loggedUser;
    }

}
