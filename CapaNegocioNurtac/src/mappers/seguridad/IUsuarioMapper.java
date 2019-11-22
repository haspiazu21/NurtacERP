/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers.seguridad;

import entities.seguridad.SegUsuarios;
import modelo.seguridad.Usuario;

/**
 *
 * @author Ellet
 */
public interface IUsuarioMapper {
    
    Usuario entityToModel(SegUsuarios usuarioEntity);
    
    SegUsuarios modelToEntity(Usuario usuario);
    
}
