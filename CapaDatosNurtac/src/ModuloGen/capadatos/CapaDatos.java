/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloGen.capadatos;

import general.Dao.EmpresaDAO;
import general.entities.GenEmpresas;
import general.factory.FactoryEM;
import general.Dao.IEmpresaDAO;
import general.Dao.ISucursalDAO;
import general.Dao.SucursalDAO;
import seguridad.Dao.IMenuDAO;
import seguridad.Dao.IUsuarioDAO;
import seguridad.Dao.MenuDAO;
import seguridad.Dao.UsuarioDAO;
import general.entities.GenSucursales;
import seguridad.entities.SegMenus;
import seguridad.entities.SegPermisosgrupos;
import seguridad.entities.SegUsuarios;
import java.util.List;

/**
 *
 * @author Ellet
 */
public class CapaDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

     FactoryEM.inicializarFactory();
        IEmpresaDAO crud = new EmpresaDAO();
        GenEmpresas empresa = new GenEmpresas();
        empresa.setCedreplegal("092107858");
        empresa.setComercial("Fenix");
        empresa.setEstado("A");
        empresa.setNombre("Fenix");
        empresa.setReplegal("Henry Aspiazu");
//        
        crud.create(empresa);
        System.out.println(empresa.toString());
        
//        GenEmpresas empresa2 = crud.find(2);
//
//        System.out.println(empresa2.toString());
//        empresa2.setNombre("Nurtac");
//        empresa2.setComercial("Funcación Nurtac");
//
//        crud.merge(empresa2);
//        IMenuDAO crudMenu = new MenuDAO();
//        
//        List<SegMenus> menus = crudMenu.findAllPermisosGrupo(2);
//        
//        for (SegMenus menu : menus) {
//            System.out.println(menu.getSegPermisosgruposList().size() > 0);
//            System.out.println(menu.getNombre());
//            System.out.println(menu.getSegPermisosgruposList().size());
//        }
//        
 FactoryEM.destruirFactory();
    }

}
