/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import modelo.seguridad.GrupoUsuario;

/**
 *
 * @author Ellet
 */
public interface IFacadeMantGrupoUsuario {
    
    List<GrupoUsuario> getAllGruposUsuarios();
    
    void guardarGrupoUsuario(GrupoUsuario grupoUsuario);
    
    void eliminarGrupoUsuario(int grupoUsuarioId);
    
}
