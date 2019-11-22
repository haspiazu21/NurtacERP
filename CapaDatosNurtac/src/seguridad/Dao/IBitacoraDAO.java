/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.Dao;

import seguridad.entities.SegBitacora;
import java.util.List;

/**
 *
 * @author Ellet
 */
public interface IBitacoraDAO {

    void create(SegBitacora bitacora);

    List<SegBitacora> findAll();

    int getNextId();

}