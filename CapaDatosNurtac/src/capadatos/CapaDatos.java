/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos;

import dao.general.EmpresaDAO;
import entities.general.GenEmpresas;
import entities.seguridad.SegRoles;
import factory.FactoryEM;
import dao.general.IEmpresaDAO;
import dao.general.ISucursalDAO;
import dao.general.SucursalDAO;
import dao.seguridad.IMenuDAO;
import dao.seguridad.IModuloDAO;
import dao.seguridad.IRolesDAO;
import dao.seguridad.IUsuarioDAO;
import dao.seguridad.MenuDAO;
import dao.seguridad.RolesDAO;
import dao.seguridad.UsuarioDAO;
import dao.seguridad.ModuloDAO;
import entities.general.GenSucursales;
import entities.seguridad.SegMenus;
import entities.seguridad.SegModulos;
import entities.seguridad.SegPermisosgrupos;
import entities.seguridad.SegUsuarios;
import static java.lang.Boolean.TRUE;
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
//        IEmpresaDAO crud = new EmpresaDAO();
/**Creacion de Empresa*/
//        GenEmpresas empresa = new GenEmpresas();
//        empresa.setCedreplegal("0921078580");
//        empresa.setComercial("Fenix");
//        empresa.setEstado("A");
//        empresa.setNombre("Fenix");
//        empresa.setReplegal("Henry Aspiazu");
//        
//        crud.create(empresa);
//        System.out.println(empresa.toString());
        
/**Actualizacion de Datos empresariales*/
//        GenEmpresas empresa2 = crud.find(2);
//        System.out.println(empresa2.toString());
//        empresa2.setNombre("Nurtac");
//        empresa2.setComercial("Funcación Nurtac");
//        crud.merge(empresa2);


//        IMenuDAO crudMenu = new MenuDAO();
//        List<SegMenus> menus = crudMenu.findAllPermisosGrupo(1);
//        
//        for (SegMenus menu : menus) {
//            System.out.println(menu.getSegPermisosgruposList().size() > 0);
//            System.out.println(menu.getNombre());
//            System.out.println(menu.getSegPermisosgruposList().size());
//        }
  
/**Gestion de Roles - Nueva Implementacion Henry Aspiazu 28/10/2019 */

//        SegRoles roles= new SegRoles();
//       
//        IRolesDAO crud_rol = new RolesDAO();
//        //roles.setIdRol(2);
//        roles.setNombreRol("Administración de Usuarios");
//        roles.setModulo("Seguridad");
//        roles.setSubmodulo("Consultas");
//        roles.setEstadoRol("Activo");
//               
//        crud_rol.create(roles);
//        System.out.println(roles.toString());
/**Gestion de Usuarios - Nueva Implementacion Henry Aspiazu 28/10/2019 */
    SegUsuarios usuario= new SegUsuarios();
    IEmpresaDAO crud = new EmpresaDAO();
    GenEmpresas empresa = crud.find(2);
    empresa.getGenSucursalesList().get(1);
    
    GenSucursales sucursal= new GenSucursales();
    
    sucursal.getSucursalid();
   
    UsuarioDAO crud_user =new UsuarioDAO();
    
    usuario.setUsername("User Pruebas");
    usuario.setContrasena("12345");
    usuario.getEmpresaid();
    usuario.setEstado("A");
    //usuario.setGrupousuarioid(2);
    //usuario.setSegPermisosusuariosList(true,true,true);
    //usuario.setSucursalid()=sucursal.setSucursalid(1);
    usuario.setUsuarioid_rol(1);

    crud_user.create(usuario);
    System.out.println(usuario.toString());


/**Gestion de bitacora - Nueva Implementacion Henry Aspiazu 28/10/2019 */
      FactoryEM.destruirFactory();
    }
}
