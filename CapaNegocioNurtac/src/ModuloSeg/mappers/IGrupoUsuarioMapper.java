/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeg.mappers;

import ModuloSeg.entities.SegGruposusuarios;
import ModuloSeg.modelo.GrupoUsuario;

/**
 *
 * @author Ellet
 */
public interface IGrupoUsuarioMapper {

    GrupoUsuario entityToModel(SegGruposusuarios grupoUsuarioEntity);

    SegGruposusuarios modelToEntity(GrupoUsuario grupoUsuario);

}
