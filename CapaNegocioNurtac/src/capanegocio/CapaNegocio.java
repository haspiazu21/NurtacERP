/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capanegocio;

import entities.seguridad.SegRoles;
import facade.FacadeMantGrupoUsuario;
import facade.FacadeMantUsuario;
import facade.FacadePermGrupo;
import facade.FacadeRol;
import facade.IFacadeMantGrupoUsuario;
import facade.IFacadeMantUsuario;
import facade.IFacadePermGrupo;
import facade.IFacadeRol;
import factory.FactoryEM;
import java.util.ArrayList;
import java.util.List;
import modelo.general.Empresa;
import modelo.general.Sucursal;
import modelo.seguridad.GrupoUsuario;
import modelo.seguridad.Page;
import modelo.seguridad.Permiso;
import modelo.seguridad.Roles;
import modelo.seguridad.Usuario;

/**
 *
 * @author Ellet
 */
public class CapaNegocio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        FactoryEM.inicializarFactory();
//        IFacadePermGrupo f = new FacadePermGrupo();

        /**
         * Carga de Paginas y Verificacion de Acceso x Grupo
         */
//        List<Page> pages = f.getAllPermisosGrupo(new GrupoUsuario(1, "", "", ""));
//
//        for (Page page : pages) {
//            System.out.println("Menu: " + page.getNombre());
//            System.out.println("Modulo: " + page.getModulo());
//            System.out.println("Tiene Permiso: " + page.getPermiso().getAsignado());
//        }
        /**
         * Guardar Permisos de Paginas x Grupo de Usuarios
         */
//        List<Page> pages = new ArrayList<>();
//        Page pg = new Page();
//        pg.setCodigo(4);
//        pg.setModulo("Inventario");
//        pg.setNombre("Inventario");
//        pg.setPermiso(new Permiso(true, true, true, true, false, true, true));
//        pages.add(pg);
//        f.guardarPermisos(pages, new GrupoUsuario(4, "", "", ""));
//
        /**
         * Creacion de Grupos de Usuarios desde la capa de Negocio
         */
//        IFacadeMantGrupoUsuario m = new FacadeMantGrupoUsuario();
//        GrupoUsuario g = new GrupoUsuario();
//        g.setDescripcion("Usuarios encargados de los servicios generales.");
//        g.setNombre("Servicios Administrativos");
//        m.guardarGrupoUsuario(g);
        /**
         * Creacion de usuario desde la capa de Negocio
         */
//         
//        IFacadeMantUsuario transaccuser = new FacadeMantUsuario();
//        Usuario usuario = new Usuario();
//        
//        IFacadeMantGrupoUsuario grupousuario= new FacadeMantGrupoUsuario();
//        
//        GrupoUsuario grupo=grupousuario.getAllGruposUsuarios().get(1);
//        Empresa idempresa=transaccuser.findAllEmpresas().get(1);
//        Sucursal suc=transaccuser.findSucursalesByEmpresa(1).get(1);
//        Roles roluser= transaccuser.findAllRoles().get(0);
//        
//        usuario.setNombre("User Pruebas");
//        usuario.setGrupousuario(grupo);
//        usuario.setSucursal(suc);
//        usuario.setUsuario("user.pruebas");
//        usuario.setContrasena("12345");
//        usuario.setEstado("A");
//        usuario.setEmpresa(idempresa);
//        usuario.setRol_usuario(roluser);
//        
//        transaccuser.guardarUsuario(usuario);
        /**
         * creacion de roles desde capa de negocio
         */
//        IFacadeRol frol = new FacadeRol();
//        Roles rolu = new Roles();
//        rolu.setCodigo(rolu.getCodigo());
//        rolu.setNombre("HDA");
//        rolu.setModulo("TR");
//        rolu.setSubmodulo("FT");
//        rolu.setEstado("A");
//        
//        frol.guardarRol(rolu);
//
//        List<Roles> roles = frol.getAllRoles();
//        roles.forEach((rol) -> {
//            System.out.println("Roles: " + rol.getNombre()+ "Tipo: " + rol.getModulo());
//        });
//
////*cierre de conexion*/            
//        FactoryEM.destruirFactory();

    }

}
