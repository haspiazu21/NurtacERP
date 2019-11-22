/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.seguridad;

import entities.seguridad.SegPermisosusuarios;
import java.util.List;

/**
 *
 * @author Ellet
 */
public interface IPermisoUsuarioDAO {

    void create(List<SegPermisosusuarios> permisosUsuario, int usuarioId);

    List<SegPermisosusuarios> findByUsuario(int usuarioId);

}
