/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers.seguridad;

import entities.seguridad.SegRoles;
import modelo.seguridad.Roles;

/**
 *
 * @author hac
 */
public interface IRolMapper {

    Roles entityToModel(SegRoles rolesEntity);

    SegRoles modelToEntity(Roles uroles);

}
