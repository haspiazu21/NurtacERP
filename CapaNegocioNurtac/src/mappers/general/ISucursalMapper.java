/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers.general;

import entities.general.GenSucursales;
import modelo.general.Sucursal;

/**
 *
 * @author Ellet
 */
public interface ISucursalMapper {
    
    Sucursal entityToModel(GenSucursales sucursalEntity);
    
    GenSucursales modelToEntity(Sucursal sucursal);
    
    
}
