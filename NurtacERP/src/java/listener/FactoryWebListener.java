/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;


import ModuloGen.factory.FactoryEM;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 *
 * @author serbr
 */
@WebListener
public class FactoryWebListener implements ServletContextListener{

    
    
    private FactoryWebListener(){
        
    }
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        FactoryEM.inicializarFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        FactoryEM.destruirFactory();
    }
    
}
