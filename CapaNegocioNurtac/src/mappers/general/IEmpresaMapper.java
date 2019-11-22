/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers.general;

import entities.general.GenEmpresas;
import modelo.general.Empresa;

/**
 *
 * @author Ellet
 */
public interface IEmpresaMapper {

    Empresa entityToModel(GenEmpresas empresaEntity);
    
    GenEmpresas modelToEntity(Empresa empresa);
}
