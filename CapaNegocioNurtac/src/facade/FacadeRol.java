/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.seguridad.IMenuDAO;
import dao.seguridad.IModuloDAO;
import dao.seguridad.IRolesDAO;
import dao.seguridad.IUsuarioDAO;
import dao.seguridad.RolesDAO;
import entities.seguridad.SegGruposusuarios;
import entities.seguridad.SegRoles;
import entities.seguridad.SegUsuarios;
import java.util.ArrayList;
import java.util.List;
import mappers.seguridad.IMenuItemMapper;
import mappers.seguridad.IMenuMapper;
import mappers.seguridad.IRolMapper;
import mappers.seguridad.IUsuarioMapper;
import mappers.seguridad.RolMapper;
import modelo.seguridad.GrupoUsuario;
import modelo.seguridad.Roles;
import modelo.seguridad.Usuario;

/**
 *
 * @author Tia
 */
public class FacadeRol implements IFacadeRol {

    /*
    Data Transfer Objects (DAO)
     */
    private final IRolesDAO rolesDAO;
    /*
    DTO Mappers
     */
    private final IRolMapper rolesMapper;

    public FacadeRol() {

        rolesDAO = new RolesDAO();

        rolesMapper = new RolMapper();
    }

    @Override
    public List<Roles> getAllRoles() {

        List<Roles> roles = new ArrayList<>();
        List<SegRoles> entitiesrol = rolesDAO.findAll();

        for (SegRoles entity : entitiesrol) {
            Roles rol = rolesMapper.entityToModel(entity);
            roles.add(rol);
        }
        return roles;
    }

    public void guardarRol(Roles roles) {

        SegRoles segRoles = rolesMapper.modelToEntity(roles);

        if (segRoles.getIdRol() == 0) {
            rolesDAO.create(segRoles);
        } else {
            rolesDAO.create(segRoles);
        }

    }

}
