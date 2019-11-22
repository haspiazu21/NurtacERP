/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import modelo.seguridad.Menu;
import modelo.seguridad.Usuario;

/**
 *
 * @author Ellet
 */
public interface IFacadeSeguridad {
    
    List<Menu> getMenus(Usuario usuario);
    
    Usuario getLoggedUser(String username, String password);
}
