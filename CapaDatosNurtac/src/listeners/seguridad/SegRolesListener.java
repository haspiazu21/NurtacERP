/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.seguridad;

import entities.seguridad.SegRoles;
import entities.seguridad.SegUsuarios;
import exceptions.UniqueException;
import factory.FactoryEM;
import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.persistence.TypedQuery;

/**
 *
 * @author haspi
 */
public class SegRolesListener {
    
      @PrePersist
    public void rolExiste(SegRoles segRoles) throws UniqueException {
        EntityManager em = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegRoles.findByNombreRol", SegRoles.class);
            q.setParameter("nombreRol", segRoles.getNombreRol());
            if (q.getResultList().size() > 0) {
                throw new UniqueException("Nombre de rol ya existe");
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
