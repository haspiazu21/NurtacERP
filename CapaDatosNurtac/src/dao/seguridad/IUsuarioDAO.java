/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.seguridad;

import entities.seguridad.SegUsuarios;
import java.util.List;

/**
 *
 * @author Ellet
 */
public interface IUsuarioDAO {

    void create(SegUsuarios usuario);

    void merge(SegUsuarios usuario);

    void delete(int usuarioId);

    SegUsuarios find(int id);
    
    SegUsuarios findByUsernamePassword(String username, String password);

    List<SegUsuarios> findAll();

    int getNextId();

}
