/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capanegocio;

import facade.FacadeMantGrupoUsuario;
import facade.FacadePermGrupo;
import facade.IFacadeMantGrupoUsuario;
import facade.IFacadePermGrupo;
import factory.FactoryEM;
import java.util.ArrayList;
import java.util.List;
import modelo.seguridad.GrupoUsuario;
import modelo.seguridad.Page;
import modelo.seguridad.Permiso;

/**
 *
 * @author Ellet
 */
public class CapaNegocio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       // FactoryEM.inicializarFactory();
//
//        IFacadePermGrupo f = new FacadePermGrupo();

//        List<Page> pages = f.getAllPermisosGrupo(new GrupoUsuario(2, "", "", ""));
//
//        for (Page page : pages) {
//            System.out.println("Menu: " + page.getNombre());
//            System.out.println("Modulo: " + page.getModulo());
//            System.out.println("Tiene Permiso: " + page.getPermiso().isAsignado());
//        }
//        List<Page> pages = new ArrayList<>();
//        Page pg = new Page();
//        pg.setCodigo(2);
//        pg.setModulo("asdasd");
//        pg.setNombre("asadsd");
//        pg.setPermiso(new Permiso(true, true, true, true, true, true, true));
//        pages.add(pg);
//
//        f.guardarPermisos(pages, new GrupoUsuario(2, "", "", ""));
//


//        IFacadeMantGrupoUsuario m = new FacadeMantGrupoUsuario();
//        
//        GrupoUsuario g = new GrupoUsuario();
//        
//        g.setDescripcion("asd");
//        g.setNombre("Test");
//        
//        m.guardarGrupoUsuario(g);
//        
//
//        FactoryEM.destruirFactory();

    }

}
