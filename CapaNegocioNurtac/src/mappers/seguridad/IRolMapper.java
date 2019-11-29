/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers.seguridad;

import entities.seguridad.SegRoles;
import entities.seguridad.SegUsuarios;
import modelo.seguridad.Roles;
import modelo.seguridad.Usuario;

/**
 *
 * @author Tia
 */
public interface IRolMapper {

    Roles entityToModel(SegRoles rolesEntity);
    
    SegRoles modelToEntity(Roles uroles);
    

}
