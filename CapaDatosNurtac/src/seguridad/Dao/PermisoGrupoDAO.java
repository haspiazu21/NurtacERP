/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.Dao;

import seguridad.entities.SegPermisosgrupos;
import general.factory.FactoryEM;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ellet
 */
public class PermisoGrupoDAO implements IPermisoGrupoDAO {

    @Override
    public void create(List<SegPermisosgrupos> permisosGrupo, int grupoUsuarioId) {
        EntityManager em = null;
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            Query q = em.createNamedQuery("SegPermisosgrupos.deleteByGrupousuarioid");
            q.setParameter("grupousuarioid", grupoUsuarioId);
            q.executeUpdate();
            for (SegPermisosgrupos segPermisosgrupos : permisosGrupo) {
                em.persist(segPermisosgrupos);
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
    public List<SegPermisosgrupos> findByGrupoUsuario(int grupoUsuarioId) {
        EntityManager em = null;
        List<SegPermisosgrupos> permisos = new ArrayList<>();
        try {
            em = FactoryEM.getEntityManager();
            em.getTransaction().begin();
            TypedQuery q = em.createNamedQuery("SegPermisosgrupos.findByGrupousuarioid", SegPermisosgrupos.class);
            q.setParameter("grupousuarioid", grupoUsuarioId);
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
