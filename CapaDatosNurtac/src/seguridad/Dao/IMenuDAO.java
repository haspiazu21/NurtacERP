/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.Dao;

import seguridad.entities.SegMenus;
import java.util.List;

/**
 *
 * @author Ellet
 */
public interface IMenuDAO {

    void create(SegMenus menu);

    void merge(SegMenus menu);

    void delete(int menuId);

    SegMenus find(int id);

    List<SegMenus> findAll();

    List<SegMenus> findAllByModuloId(int moduloId);

    List<SegMenus> findAllByPermisosUsuario(int moduloId, int usuarioId);

    List<SegMenus> findAllByPermisosGrupo(int moduloId, int grupoUsuarioId);
    
    List<SegMenus> findAllPermisosGrupo(int grupoUsuarioId);

    int getNextId();

}
