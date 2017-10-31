/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloGen.facade;

import java.util.List;
import ModuloGen.modelo.Empresa;
import ModuloGen.modelo.Sucursal;
import ModuloSeg.modelo.GrupoUsuario;
import ModuloSeg.modelo.Usuario;

/**
 *
 * @author Ellet
 */
public interface IFacadeMantUsuario {

    List<Empresa> findAllEmpresas();

    List<Sucursal> findSucursalesByEmpresa(int empresaid);

    List<GrupoUsuario> findAllGruposUsuarios();

    List<Usuario> findAllUsuarios();

    void guardarUsuario(Usuario usuario);

    void eliminarUsuario(Usuario usuario);
}
