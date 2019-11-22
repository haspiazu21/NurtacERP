/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.general;

import entities.general.GenSucursales;
import factory.FactoryEM;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ellet
 */
public class SucursalDAO implements ISucursalDAO {

    @Override
    public void create(GenSucursales sucursal) {
        EntityManager em = null;
        sucursal.setSucursalid(getNextId());
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            em.persist(sucursal);
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
    public void merge(GenSucursales sucursal) {
        EntityManager em = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            em.find(GenSucursales.class, sucursal.getSucursalid());
            em.merge(sucursal);
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
    public void delete(int sucursalId) {
        EntityManager em = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            GenSucursales sucursal = em.find(GenSucursales.class, sucursalId);
            em.remove(sucursal);
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
    public GenSucursales find(int id) {
        EntityManager em = null;
        GenSucursales sucursal = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("GenSucursales.findBySucursalid", GenSucursales.class);
            q.setParameter("sucursalid", id);
            if (q.getResultList().size() == 1) {
                sucursal = (GenSucursales) q.getSingleResult();
            }
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return sucursal;
    }

    @Override
    public List<GenSucursales> findAll() {
        EntityManager em = null;
        List<GenSucursales> sucursales = new ArrayList<>();
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("GenSucursales.findAll", GenSucursales.class);
            sucursales = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return sucursales;
    }

    @Override
    public List<GenSucursales> findAllByEmpresa(int empresaId) {
        EntityManager em = null;
        List<GenSucursales> sucursales = new ArrayList<>();
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("GenSucursales.findByEmpresaid", GenSucursales.class);
            q.setParameter("empresaid", empresaId);
            sucursales = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return sucursales;
    }

    @Override
    public int getNextId() {
        EntityManager em = null;
        int id = 1;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("GenSucursales.getNextId", Integer.class);
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
