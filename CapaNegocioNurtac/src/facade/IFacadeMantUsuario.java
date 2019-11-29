/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import modelo.general.Empresa;
import modelo.general.Sucursal;
import modelo.seguridad.GrupoUsuario;
import modelo.seguridad.Roles;
import modelo.seguridad.Usuario;

/**
 *
 * @author Ellet
 */
public interface IFacadeMantUsuario {

    List<Empresa> findAllEmpresas();

    List<Sucursal> findSucursalesByEmpresa(int empresaid);

    List<GrupoUsuario> findAllGruposUsuarios();

    List<Usuario> findAllUsuarios();
    
    List<Roles> findAllRoles();

    void guardarUsuario(Usuario usuario);

    void eliminarUsuario(Usuario usuario);
}
