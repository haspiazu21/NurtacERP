/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers.seguridad;

import entities.seguridad.SegGruposusuarios;
import modelo.seguridad.GrupoUsuario;

/**
 *
 * @author Ellet
 */
public class GrupoUsuarioMapper implements IGrupoUsuarioMapper {

    @Override
    public GrupoUsuario entityToModel(SegGruposusuarios grupoUsuarioEntity) {

        if (grupoUsuarioEntity == null) {
            return null;
        }

        GrupoUsuario grupoUsuario = new GrupoUsuario();
        grupoUsuario.setDescripcion(grupoUsuarioEntity.getDescripcion());
        grupoUsuario.setEstado(grupoUsuarioEntity.getEstado().equals("A") ? "Activo" : "Inactivo");
        grupoUsuario.setId(grupoUsuarioEntity.getGrupousuarioid());
        grupoUsuario.setNombre(grupoUsuarioEntity.getNombre());

        return grupoUsuario;
    }

    @Override
    public SegGruposusuarios modelToEntity(GrupoUsuario grupoUsuario) {

        if (grupoUsuario == null) {
            return null;
        }

        SegGruposusuarios segGruposusuarios = new SegGruposusuarios();
        segGruposusuarios.setDescripcion(grupoUsuario.getDescripcion());
        segGruposusuarios.setEstado(grupoUsuario.getEstado().equals("Activo") ? "A" : "I");
        segGruposusuarios.setGrupousuarioid(grupoUsuario.getId());
        segGruposusuarios.setNombre(grupoUsuario.getNombre());

        return segGruposusuarios;

    }

}
