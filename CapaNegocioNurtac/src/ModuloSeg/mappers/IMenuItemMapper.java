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
public interface IMenuItemMapper {

    MenuItem entityToModel(SegMenus menuEntity);

}
