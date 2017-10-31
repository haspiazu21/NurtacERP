/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeg.mappers;

import ModuloSeg.entities.SegMenus;
import ModuloSeg.modelo.MenuItem;

/**
 *
 * @author Ellet
 */
public class MenuItemMapper implements IMenuItemMapper {

    @Override
    public MenuItem entityToModel(SegMenus menuEntity) {
        if (menuEntity == null) {
            return null;
        }

        MenuItem menuItem = new MenuItem();
        menuItem.setId(menuEntity.getMenuid());
        menuItem.setImagen(menuEntity.getImagen());
        menuItem.setNombre(menuEntity.getNombre());
        menuItem.setVista(String.format("/%s/%s/%s", "Views", menuEntity.getTipomenuid().getNombre(), menuEntity.getFormulario()));

        return menuItem;

    }

}
