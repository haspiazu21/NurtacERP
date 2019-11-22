/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.seguridad;

import entities.seguridad.SegModulos;
import factory.FactoryEM;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ellet
 */
public class ModuloDAO implements IModuloDAO {

    @Override
    public void create(SegModulos modulo) {
        EntityManager em = null;
        modulo.setModuloid(getNextId());
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            em.persist(modulo);
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void merge(SegModulos modulo) {
        EntityManager em = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            em.find(SegModulos.class, modulo.getModuloid());
            em.merge(modulo);
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void delete(int moduloId) {
        EntityManager em = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            SegModulos modulo = em.find(SegModulos.class, moduloId);
            em.remove(modulo);
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public SegModulos find(int id) {
        EntityManager em = null;
        SegModulos modulo = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegModulos.findByModuloid", SegModulos.class);
            q.setParameter("moduloid", id);
            if (q.getResultList().size() == 1) {
                modulo = (SegModulos) q.getSingleResult();
            }
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return modulo;
    }

    @Override
    public List<SegModulos> findAll() {
        EntityManager em = null;
        List<SegModulos> modulos = new ArrayList<>();
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegModulos.findAll", SegModulos.class);
            modulos = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return modulos;
    }

    @Override
    public int getNextId() {
        EntityManager em = null;
        int id = 1;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegModulos.getNextId", Integer.class);
            if (q.getSingleResult() != null) {
                id = (int) q.getSingleResult();
            }
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return id;
    }

}
