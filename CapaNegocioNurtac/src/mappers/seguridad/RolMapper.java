/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers.seguridad;

import entities.general.GenEmpresas;
import entities.seguridad.SegRoles;
import entities.seguridad.SegUsuarios;
import modelo.seguridad.Roles;
import modelo.seguridad.Usuario;

/**
 *
 * @author Tia
 */
public class RolMapper implements IRolMapper {

    @Override
    public Roles entityToModel(SegRoles rolesEntity) {

        Roles eroles = new Roles();
        eroles.setCodigo(rolesEntity.getIdRol());
        eroles.setNombre(rolesEntity.getNombreRol());
        eroles.setModulo(rolesEntity.getModulo());
        eroles.setSubmodulo(rolesEntity.getSubmodulo());
        eroles.setEstado(rolesEntity.getEstadoRol());

        return eroles;

    }

    @Override
    public SegRoles modelToEntity(Roles uroles) {

        SegRoles segRoles = new SegRoles();
        segRoles.setIdRol(uroles.getCodigo());
        segRoles.setNombreRol(uroles.getNombre());
        segRoles.setModulo(uroles.getModulo());
        segRoles.setSubmodulo(uroles.getSubmodulo());
        segRoles.setEstadoRol(uroles.getEstado());

        return segRoles;
    }

}
