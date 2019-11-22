/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.seguridad;

import entities.seguridad.SegGruposusuarios;
import java.util.List;

/**
 *
 * @author Ellet
 */
public interface IGrupoUsuarioDAO {
    
    void create(SegGruposusuarios grupoUsuario);

    void merge(SegGruposusuarios grupoUsuario);

    void delete(int grupoUsuarioId);

    SegGruposusuarios find(int id);

    List<SegGruposusuarios> findAll();

    int getNextId();

}
