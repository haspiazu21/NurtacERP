/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloGen.mappers;

import ModuloGen.entities.GenSucursales;
import ModuloGen.modelo.Sucursal;

/**
 *
 * @author Ellet
 */
public interface ISucursalMapper {
    
    Sucursal entityToModel(GenSucursales sucursalEntity);
    
    GenSucursales modelToEntity(Sucursal sucursal);

}
