/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.seguridad;

import entities.seguridad.SegUsuarios;
import exceptions.UniqueException;
import factory.FactoryEM;
import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ellet
 */
public class SegUsuariosListener {

    @PrePersist
    public void usuarioExiste(SegUsuarios segUsuarios) throws UniqueException {
        EntityManager em = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegUsuarios.findByUsername", SegUsuarios.class);
            q.setParameter("username", segUsuarios.getUsername());
            if (q.getResultList().size() > 0) {
                throw new UniqueException("Nombre de usuario ya existe");
            }
            em.getTransaction().commit();

        } catch (UniqueException exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
