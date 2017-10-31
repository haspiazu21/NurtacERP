/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeg.Dao;

import ModuloSeg.entities.SegTiposmenu;
import ModuloGen.factory.FactoryEM;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ellet
 */
public class TipoMenuDAO implements ITipoMenuDAO {

    @Override
    public void create(SegTiposmenu tipoMenu) {
        EntityManager em = null;
        tipoMenu.setTipomenuid(getNextId());
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoMenu);
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
    public void merge(SegTiposmenu tipoMenu) {
        EntityManager em = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            em.find(SegTiposmenu.class, tipoMenu.getTipomenuid());
            em.merge(tipoMenu);
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
    public void delete(int tipoMenuId) {
        EntityManager em = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            SegTiposmenu tipoMenu = em.find(SegTiposmenu.class, tipoMenuId);
            em.merge(tipoMenu);
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
    public SegTiposmenu find(int id) {
        EntityManager em = null;
        SegTiposmenu tipoMenu = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegTiposmenu.findByTipomenuid", SegTiposmenu.class);
            q.setParameter("tipomenuid", id);
            if (q.getResultList().size() == 1) {
                tipoMenu = (SegTiposmenu) q.getSingleResult();
            }
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return tipoMenu;
    }

    @Override
    public List<SegTiposmenu> findAll() {
        EntityManager em = null;
        List<SegTiposmenu> tiposMenu = new ArrayList<>();
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegTiposmenu.findAll", SegTiposmenu.class);
            tiposMenu = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return tiposMenu;
    }

    @Override
    public int getNextId() {
        EntityManager em = null;
        int id = 1;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegTiposmenu.getNextId", Integer.class);
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
