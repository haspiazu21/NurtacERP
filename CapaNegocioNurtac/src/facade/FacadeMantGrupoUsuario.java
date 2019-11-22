
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.seguridad.GrupoUsuarioDAO;
import dao.seguridad.IGrupoUsuarioDAO;
import entities.seguridad.SegGruposusuarios;
import java.util.ArrayList;
import java.util.List;
import mappers.seguridad.GrupoUsuarioMapper;
import mappers.seguridad.IGrupoUsuarioMapper;
import modelo.seguridad.GrupoUsuario;

/**
 *
 * @author Ellet
 */
public class FacadeMantGrupoUsuario implements IFacadeMantGrupoUsuario {

    /*
    Data Transfer Objects (DAO)
     */
    private final IGrupoUsuarioDAO grupoUsuarioDAO;
    /*
    DTO Mappers
     */
    private final IGrupoUsuarioMapper grupoUsuarioMapper;

    public FacadeMantGrupoUsuario() {
        grupoUsuarioDAO = new GrupoUsuarioDAO();
        grupoUsuarioMapper = new GrupoUsuarioMapper();
    }

    @Override
    public List<GrupoUsuario> getAllGruposUsuarios() {
        List<GrupoUsuario> gruposUsuarios = new ArrayList<>();
        List<SegGruposusuarios> entities = grupoUsuarioDAO.findAll();
        for (SegGruposusuarios entity : entities) {
            GrupoUsuario grupoUsuario = grupoUsuarioMapper.entityToModel(entity);
            gruposUsuarios.add(grupoUsuario);
        }
        return gruposUsuarios;
    }

    @Override
    public void guardarGrupoUsuario(GrupoUsuario grupoUsuario) {
        grupoUsuario.setEstado(grupoUsuario.getEstado() == null ? "Activo" : grupoUsuario.getEstado());
        SegGruposusuarios segGrupoUsuario = grupoUsuarioMapper.modelToEntity(grupoUsuario);
        if (grupoUsuario.getId() == 0) {
            grupoUsuarioDAO.create(segGrupoUsuario);
        } else {
            grupoUsuarioDAO.merge(segGrupoUsuario);
        }
    }

    @Override
    public void eliminarGrupoUsuario(int grupoUsuarioId) {
        grupoUsuarioDAO.delete(grupoUsuarioId);
    }

}
