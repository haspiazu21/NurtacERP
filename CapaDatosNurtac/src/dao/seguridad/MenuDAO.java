/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.seguridad;

import entities.seguridad.SegMenus;
import factory.FactoryEM;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ellet
 */
public class MenuDAO implements IMenuDAO {

    @Override
    public void create(SegMenus menu) {
        EntityManager em = null;
        menu.setMenuid(getNextId());
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            em.persist(menu);
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
    public void merge(SegMenus menu) {
        EntityManager em = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            em.find(SegMenus.class, menu.getMenuid());
            em.merge(menu);
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
    public void delete(int menuId) {
        EntityManager em = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            SegMenus menu = em.find(SegMenus.class, menuId);
            em.merge(menu);
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
    public SegMenus find(int id) {
        EntityManager em = null;
        SegMenus menu = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegMenus.findByMenuid", SegMenus.class);
            q.setParameter("menuid", id);
            if (q.getResultList().size() == 1) {
                menu = (SegMenus) q.getSingleResult();
            }
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return menu;
    }

    @Override
    public List<SegMenus> findAll() {
        EntityManager em = null;
        List<SegMenus> menus = new ArrayList<>();
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegMenus.findAll", SegMenus.class);
            menus = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return menus;
    }

    @Override
    public List<SegMenus> findAllByModuloId(int moduloId) {
        EntityManager em = null;
        List<SegMenus> menus = new ArrayList<>();
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegMenus.findByModuloid", SegMenus.class);
            q.setParameter("moduloid", moduloId);
            menus = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return menus;
    }

    @Override
    public List<SegMenus> findAllByPermisosUsuario(int moduloId, int usuarioId) {
        EntityManager em = null;
        List<SegMenus> menus = new ArrayList<>();
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegMenus.findByPermisoUsuario", SegMenus.class);
            q.setParameter("moduloid", moduloId);
            q.setParameter("usuarioid", usuarioId);
            menus = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return menus;
    }

    @Override
    public List<SegMenus> findAllByPermisosGrupo(int moduloId, int grupoUsuarioId) {
        EntityManager em = null;
        List<SegMenus> menus = new ArrayList<>();
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegMenus.findByPermisoGrupo", SegMenus.class);
            q.setParameter("moduloid", moduloId);
            q.setParameter("grupousuarioid", grupoUsuarioId);
            menus = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return menus;
    }

    @Override
    public int getNextId() {
        EntityManager em = null;
        int id = 1;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegMenus.getNextId", Integer.class);
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
    public List<SegMenus> findAllPermisosGrupo(int grupoUsuarioId) {
        EntityManager em = null;
        List<SegMenus> menus = new ArrayList<>();
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegMenus.findPermisosGrupo", SegMenus.class);
            q.setParameter("grupousuarioid", grupoUsuarioId);
            menus = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return menus;
    }

}
