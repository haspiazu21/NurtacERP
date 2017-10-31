/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloGen.facade;

import java.util.List;
import ModuloSeg.modelo.GrupoUsuario;

/**
 *
 * @author Ellet
 */
public interface IFacadeMantGrupoUsuario {
    
    List<GrupoUsuario> getAllGruposUsuarios();
    
    void guardarGrupoUsuario(GrupoUsuario grupoUsuario);
    
    void eliminarGrupoUsuario(int grupoUsuarioId);
    
}
