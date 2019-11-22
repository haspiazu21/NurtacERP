/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.Dao;

import seguridad.entities.SegUsuarios;
import general.factory.FactoryEM;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ellet
 */
public class UsuarioDAO implements IUsuarioDAO {

    @Override
    public void create(SegUsuarios usuario) {
        EntityManager em = null;
        usuario.setUsuarioid(getNextId());
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            em.persist(usuario);
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
    public void merge(SegUsuarios usuario) {
        EntityManager em = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            em.find(SegUsuarios.class, usuario.getUsuarioid());
            em.merge(usuario);
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
    public void delete(int usuarioId) {
        EntityManager em = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            SegUsuarios usuario = em.find(SegUsuarios.class, usuarioId);
            em.remove(usuario);
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
    public SegUsuarios find(int id) {
        EntityManager em = null;
        SegUsuarios usuario = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegUsuarios.findByUsuarioid", SegUsuarios.class);
            q.setParameter("usuarioid", id);
            if (q.getResultList().size() == 1) {
                usuario = (SegUsuarios) q.getSingleResult();
            }
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return usuario;
    }

    @Override
    public List<SegUsuarios> findAll() {
        EntityManager em = null;
        List<SegUsuarios> usuarios = new ArrayList<>();
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegUsuarios.findAll", SegUsuarios.class);
            usuarios = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return usuarios;
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

    @Override
    public SegUsuarios findByUsernamePassword(String username, String password) {
        EntityManager em = null;
        SegUsuarios usuario = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegUsuarios.findByUsernamePassword", SegUsuarios.class);
            q.setParameter("username", username);
            q.setParameter("password", password);
            if (q.getResultList().size() == 1) {
                usuario = (SegUsuarios) q.getSingleResult();
            }
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return usuario;
    }

}
