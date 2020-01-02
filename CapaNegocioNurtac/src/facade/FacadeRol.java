/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.seguridad.IRolesDAO;
import dao.seguridad.RolesDAO;
import entities.seguridad.SegRoles;
import java.util.ArrayList;
import java.util.List;
import mappers.seguridad.IRolMapper;
import mappers.seguridad.RolMapper;
import modelo.seguridad.Page;
import modelo.seguridad.Roles;

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

        entitiesrol.stream().map((entity) -> rolesMapper.entityToModel(entity)).forEachOrdered((rol) -> {
            roles.add(rol);
        });
        return roles;
    }

    public void guardarRol(Roles roles) {

        SegRoles segRoles = rolesMapper.modelToEntity(roles);

        if (segRoles.getIdRol() == 0) {
            rolesDAO.create(segRoles);
        } else {
            rolesDAO.merge(segRoles);
        }

    }

    public void eliminaRol(Roles roles) {

        SegRoles segRoles = rolesMapper.modelToEntity(roles);
        rolesDAO.delete(segRoles.getIdRol());

    }

    @Override
    public List<Page> getAllRoles(Roles sel_roles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
