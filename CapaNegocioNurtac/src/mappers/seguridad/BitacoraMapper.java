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
public class BitacoraMapper implements IBitacoraMapper {

    @Override
    public Bitacora entityToModel(SegBitacora bitacoraEntity) {
        
        Bitacora ebitacora=new Bitacora();
        ebitacora.setCodigo(ebitacora.getCodigo());
        ebitacora.setAccion(ebitacora.getAccion());
        ebitacora.setEmpresa(ebitacora.getEmpresa());
        ebitacora.setFecha(ebitacora.getFecha());
        ebitacora.setGrupousuario(ebitacora.getGrupousuario());
        ebitacora.setModulo(ebitacora.getModulo());
        ebitacora.setSucursal(ebitacora.getSucursal());
        ebitacora.setUsuario(ebitacora.getUsuario());
        
        return ebitacora;
        
    }

    @Override
    public SegBitacora modelToEntity(Bitacora ubitacora) {
        
        SegBitacora segBitacora= new SegBitacora();
        segBitacora.setCodigo(segBitacora.getCodigo());
        segBitacora.setAccion(segBitacora.getAccion());
        segBitacora.setEmpresa(segBitacora.getEmpresa());
        segBitacora.setFecha(segBitacora.getFecha());
        segBitacora.setGrupousuario(segBitacora.getGrupousuario());
        segBitacora.setModulo(segBitacora.getModulo());
        segBitacora.setSucursal(segBitacora.getSucursal());
        segBitacora.setUsuario(segBitacora.getUsuario());
                
        return segBitacora;
       
        
    }
    
}
