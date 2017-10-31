/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeg.Dao;

import ModuloSeg.entities.SegTiposmenu;
import java.util.List;

/**
 *
 * @author Ellet
 */
public interface ITipoMenuDAO {

    void create(SegTiposmenu tipoMenu);

    void merge(SegTiposmenu tipoMenu);

    void delete(int tipoMenuId);

    SegTiposmenu find(int id);

    List<SegTiposmenu> findAll();

    int getNextId();
}
