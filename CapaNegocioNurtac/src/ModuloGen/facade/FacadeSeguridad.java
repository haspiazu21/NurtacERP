/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloGen.facade;

import ModuloSeg.Dao.IMenuDAO;
import ModuloSeg.Dao.IModuloDAO;
import ModuloSeg.Dao.IUsuarioDAO;
import ModuloSeg.Dao.MenuDAO;
import ModuloSeg.Dao.ModuloDAO;
import ModuloSeg.Dao.UsuarioDAO;
import ModuloSeg.entities.SegMenus;
import ModuloSeg.entities.SegModulos;
import ModuloSeg.entities.SegUsuarios;
import java.util.ArrayList;
import java.util.List;
import ModuloSeg.mappers.IMenuItemMapper;
import ModuloSeg.mappers.IMenuMapper;
import ModuloSeg.mappers.IUsuarioMapper;
import ModuloSeg.mappers.MenuItemMapper;
import ModuloSeg.mappers.MenuMapper;
import ModuloSeg.mappers.UsuarioMapper;
import ModuloSeg.modelo.Menu;
import ModuloSeg.modelo.MenuItem;
import ModuloSeg.modelo.Modulo;
import ModuloSeg.modelo.Usuario;

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
        SegUsuarios userEntity;
        userEntity = usuarioDAO.findByUsernamePassword(username, password);
        loggedUser = usuarioMapper.entityToModel(userEntity);
        return loggedUser;
    }

}
