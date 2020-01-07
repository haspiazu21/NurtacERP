/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers.seguridad;

import entities.seguridad.SegBitacora;
import modelo.seguridad.Bitacora;

/**
 *
 * @author hac
 */
public interface IBitacoraMapper {

    /**
     *
     * @param bitacoraEntity
     * @return
     */
    Bitacora entityToModel(SegBitacora bitacoraEntity);

    /**
     *
     * @param ubitacora
     * @return
     */
    SegBitacora modelToEntity(Bitacora ubitacora);

}
