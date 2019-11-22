/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers.seguridad;

import entities.seguridad.SegModulos;
import modelo.seguridad.Menu;

/**
 *
 * @author Ellet
 */
public class MenuMapper implements IMenuMapper {
    
    @Override
    public Menu entityToModel(SegModulos moduloEntity) {
        
        if (moduloEntity == null) {
            return null;
        }        
        
        Menu menu = new Menu();
        menu.setId(moduloEntity.getModuloid());
        menu.setNombre(moduloEntity.getNombre());
        
        return menu;
    }
    
}
