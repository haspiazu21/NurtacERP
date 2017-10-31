/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeg.Dao;

import ModuloSeg.entities.SegPermisosgrupos;
import ModuloSeg.entities.SegPermisosusuarios;
import ModuloGen.factory.FactoryEM;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ellet
 */
public class PermisoUsuarioDAO implements IPermisoUsuarioDAO {

    @Override
    public void create(List<SegPermisosusuarios> permisosUsuario, int usuarioId) {
        EntityManager em = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            Query q = em.createNamedQuery("SegPermisosusuarios.deleteByUsuarioid");
            q.setParameter("usuarioid", usuarioId);
            q.executeUpdate();
            for (SegPermisosusuarios segPermisosusuarios : permisosUsuario) {
                em.persist(segPermisosusuarios);
            }
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
    public List<SegPermisosusuarios> findByUsuario(int usuarioId) {
        EntityManager em = null;
        List<SegPermisosusuarios> permisos = new ArrayList<>();
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegPermisosusuarios.findByUsuarioid", SegPermisosusuarios.class);
            q.setParameter("usuarioid", usuarioId);
            permisos = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception exc) {
            throw exc;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return permisos;
    }

}
