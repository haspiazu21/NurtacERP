/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.seguridad.SegRoles;
import java.util.List;
import modelo.seguridad.GrupoUsuario;
import modelo.seguridad.Menu;
import modelo.seguridad.Page;
import modelo.seguridad.Roles;
import modelo.seguridad.Usuario;

/**
 *
 * @author Tia
 */
public interface IFacadeRol {

    List<Roles> getAllRoles();

    void guardarRol(Roles roles);

    void eliminaRol(Roles roles);
    
    public List<Page> getAllRoles(Roles sel_roles);

}
