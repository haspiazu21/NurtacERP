/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.Dao;

import seguridad.entities.SegGruposusuarios;
import general.factory.FactoryEM;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ellet
 */
public class GrupoUsuarioDAO implements IGrupoUsuarioDAO {

    @Override
    public void create(SegGruposusuarios grupoUsuario) {
        EntityManager em = null;
        grupoUsuario.setGrupousuarioid(getNextId());
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            em.persist(grupoUsuario);
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
    public void merge(SegGruposusuarios grupoUsuario) {
        EntityManager em = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            em.find(SegGruposusuarios.class, grupoUsuario.getGrupousuarioid());
            em.merge(grupoUsuario);
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
    public void delete(int grupoUsuarioId) {
        EntityManager em = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            SegGruposusuarios grupoUsuario = em.find(SegGruposusuarios.class, grupoUsuarioId);
            em.remove(grupoUsuario);
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
    public SegGruposusuarios find(int id) {
        EntityManager em = null;
        SegGruposusuarios grupoUsuario = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegGruposusuarios.findByGrupousuarioid", SegGruposusuarios.class);
            q.setParameter("grupousuarioid", id);
            if (q.getResultList().size() == 1) {
                grupoUsuario = (SegGruposusuarios) q.getSingleResult();
            }
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return grupoUsuario;
    }

    @Override
    public List<SegGruposusuarios> findAll() {
        EntityManager em = null;
        List<SegGruposusuarios> gruposUsuarios = new ArrayList<>();
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegGruposusuarios.findAll", SegGruposusuarios.class);
            gruposUsuarios = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return gruposUsuarios;
    }

    @Override
    public int getNextId() {
        EntityManager em = null;
        int id = 1;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegUsuarios.getNextId", Integer.class);
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
