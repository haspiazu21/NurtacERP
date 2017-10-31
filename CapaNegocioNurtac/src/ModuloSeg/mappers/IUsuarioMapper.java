/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeg.mappers;

import ModuloSeg.entities.SegUsuarios;
import ModuloSeg.modelo.Usuario;

/**
 *
 * @author Ellet
 */
public interface IUsuarioMapper {
    
    Usuario entityToModel(SegUsuarios usuarioEntity);
    
    SegUsuarios modelToEntity(Usuario usuario);
    
}
