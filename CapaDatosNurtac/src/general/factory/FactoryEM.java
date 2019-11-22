/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ellet
 */
public class FactoryEM {

    private static EntityManagerFactory emf;

    private FactoryEM() {
    }

    public static void inicializarFactory() {
        emf = Persistence.createEntityManagerFactory("CapaDatosPU");
    }

    public static void destruirFactory() {
        if (emf != null) {
            emf.close();
        }
    }

    public static EntityManager getEntityManager() {
        if (emf != null) {
            return emf.createEntityManager();
        }
        return null;
    }

}
