/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners.seguridad;

import entities.seguridad.SegRoles;
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
            q.setParameter("modulo",segRoles.getModulo());
            q.setParameter("submodulo", segRoles.getSubmodulo());
            if (q.getResultList().size() > 0) {
                throw new UniqueException("El rol, modulo y submodulo ya estan registrados");
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
