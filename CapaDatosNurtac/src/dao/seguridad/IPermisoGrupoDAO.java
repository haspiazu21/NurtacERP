/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.seguridad;

import entities.seguridad.SegPermisosgrupos;
import java.util.List;

/**
 *
 * @author Ellet
 */
public interface IPermisoGrupoDAO {

    void create(List<SegPermisosgrupos> permisosGrupo, int grupoUsuarioId);

    List<SegPermisosgrupos> findByGrupoUsuario(int grupoUsuarioId);

}
