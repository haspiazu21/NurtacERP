/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.Dao;

import seguridad.entities.SegModulos;
import java.util.List;

/**
 *
 * @author Ellet
 */
public interface IModuloDAO {

    void create(SegModulos modulo);

    void merge(SegModulos modulo);

    void delete(int moduloId);

    SegModulos find(int id);

    List<SegModulos> findAll();

    int getNextId();

}
