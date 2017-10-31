/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.transactions;

import ModuloGen.facade.FacadeSeguridad;
import ModuloGen.facade.IFacadeSeguridad;
import ModuloSeg.modelo.Menu;
import ModuloSeg.modelo.MenuItem;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import ModuloSeg.modelo.Usuario;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Ellet
 */
@ManagedBean
@SessionScoped
public class MenuMB implements Serializable {

    private MenuModel dynamicMenu;
    private String selectedUrl;
    private String username;
    private String password;
    private Usuario loggedUser;
    private IFacadeSeguridad FacadeSeguridad;

    /**
     * Creates a new instance of MenuMB
     */
    public MenuMB() {
    }

    @PostConstruct
    public void init() {

        FacadeSeguridad = new FacadeSeguridad();
        selectedUrl = "/Index.xhtml";

    }

    public void setUrl(String url) {
        this.selectedUrl = url;

    }

    public MenuModel getDynamicMenu() {
        return dynamicMenu;
    }

    public void setDynamicMenu(MenuModel dynamicMenu) {
        this.dynamicMenu = dynamicMenu;
    }

    public String getSelectedUrl() {
        return selectedUrl;
    }

    public void setSelectedUrl(String selectedUrl) {
        this.selectedUrl = selectedUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(Usuario loggedUser) {
        this.loggedUser = loggedUser;
    }

    private void constructMenu() {
        dynamicMenu = new DefaultMenuModel();
        List<Menu> menuList = FacadeSeguridad.getMenus(loggedUser);
        for (Menu m : menuList) {
            DefaultSubMenu dfsm = new DefaultSubMenu(m.getNombre());

            for (MenuItem mi : m.getMenuItems()) {
                DefaultMenuItem dfsmi = new DefaultMenuItem(mi.getNombre(), mi.getImagen());
                dfsmi.setUpdate(":frmContent:pnlContent");
                dfsmi.setCommand("#{menuMB.setUrl('" + mi.getVista() + "')}");
                dfsm.addElement(dfsmi);
            }

            dynamicMenu.addElement(dfsm);
        }
    }

    public String logIn() {

        loggedUser = FacadeSeguridad.getLoggedUser(username, password);
        if (loggedUser != null) {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getSessionMap()
                    .put("loggedUser", loggedUser);
            constructMenu();
            return "home?faces-redirect=true";
        } else {
            return "iniciodesesion.xhtml";
        }

    }

}
