/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos;

import dao.general.EmpresaDAO;
import entities.general.GenEmpresas;
import factory.FactoryEM;
import dao.general.IEmpresaDAO;
import dao.general.ISucursalDAO;
import dao.general.SucursalDAO;
import dao.seguridad.IMenuDAO;
import dao.seguridad.IUsuarioDAO;
import dao.seguridad.MenuDAO;
import dao.seguridad.UsuarioDAO;
import entities.general.GenSucursales;
import entities.seguridad.SegMenus;
import entities.seguridad.SegPermisosgrupos;
import entities.seguridad.SegUsuarios;
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

        //     FactoryEM.inicializarFactory();
//        IEmpresaDAO crud = new EmpresaDAO();
//        GenEmpresas empresa = new GenEmpresas();
//        empresa.setCedreplegal("999999999");
//        empresa.setComercial("Asesoral");
//        empresa.setEstado("A");
//        empresa.setNombre("Asesoral");
//        empresa.setReplegal("Xavier Moreira");
//        
//        crud.create(empresa);
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
        // FactoryEM.destruirFactory();
    }

}