/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeg.mappers;

import ModuloSeg.entities.SegModulos;
import ModuloSeg.modelo.Menu;

/**
 *
 * @author Ellet
 */
public interface IMenuMapper {
    
    Menu entityToModel(SegModulos entityModulo);
    
}
