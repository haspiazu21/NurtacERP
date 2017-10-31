/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloGen.capadatos;

import ModuloGen.Dao.EmpresaDAO;
import ModuloGen.entities.GenEmpresas;
import ModuloGen.factory.FactoryEM;
import ModuloGen.Dao.IEmpresaDAO;
import ModuloGen.Dao.ISucursalDAO;
import ModuloGen.Dao.SucursalDAO;
import ModuloSeg.Dao.IMenuDAO;
import ModuloSeg.Dao.IUsuarioDAO;
import ModuloSeg.Dao.MenuDAO;
import ModuloSeg.Dao.UsuarioDAO;
import ModuloGen.entities.GenSucursales;
import ModuloSeg.entities.SegMenus;
import ModuloSeg.entities.SegPermisosgrupos;
import ModuloSeg.entities.SegUsuarios;
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
