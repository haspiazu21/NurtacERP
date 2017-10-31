/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloGen.mappers;

import ModuloGen.entities.GenEmpresas;
import ModuloGen.modelo.Empresa;

/**
 *
 * @author Ellet
 */
public class EmpresaMapper implements IEmpresaMapper {

    @Override
    public Empresa entityToModel(GenEmpresas empresaEntity) {

        if (empresaEntity == null) {
            return null;
        }

        Empresa empresa = new Empresa();
        empresa.setCedRepLegal(empresaEntity.getCedreplegal());
        empresa.setComercial(empresaEntity.getComercial());
        empresa.setEstado(empresaEntity.getEstado().equals("A") ? "Activo" : "Inactivo");
        empresa.setId(empresaEntity.getEmpresaid());
        empresa.setNombre(empresaEntity.getNombre());
        empresa.setRepLegal(empresaEntity.getReplegal());

        return empresa;
    }

    @Override
    public GenEmpresas modelToEntity(Empresa empresa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
