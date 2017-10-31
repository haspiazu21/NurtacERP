/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeg.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Ellet
 */
@Entity
@Table(name = "seg_permisosgrupos")
@NamedQueries({
    @NamedQuery(name = "SegPermisosgrupos.findAll", query = "SELECT s FROM SegPermisosgrupos s")
    , @NamedQuery(name = "SegPermisosgrupos.findByMenuid", query = "SELECT s FROM SegPermisosgrupos s WHERE s.segPermisosgruposPK.menuid = :menuid")
    , @NamedQuery(name = "SegPermisosgrupos.findByGrupousuarioid", query = "SELECT s FROM SegPermisosgrupos s WHERE s.segPermisosgruposPK.grupousuarioid = :grupousuarioid")
    , @NamedQuery(name = "SegPermisosgrupos.findByGuardar", query = "SELECT s FROM SegPermisosgrupos s WHERE s.guardar = :guardar")
    , @NamedQuery(name = "SegPermisosgrupos.findByBuscar", query = "SELECT s FROM SegPermisosgrupos s WHERE s.buscar = :buscar")
    , @NamedQuery(name = "SegPermisosgrupos.findByModificar", query = "SELECT s FROM SegPermisosgrupos s WHERE s.modificar = :modificar")
    , @NamedQuery(name = "SegPermisosgrupos.findByImprimir", query = "SELECT s FROM SegPermisosgrupos s WHERE s.imprimir = :imprimir")
    , @NamedQuery(name = "SegPermisosgrupos.findByEliminar", query = "SELECT s FROM SegPermisosgrupos s WHERE s.eliminar = :eliminar")
    , @NamedQuery(name = "SegPermisosgrupos.findByAnular", query = "SELECT s FROM SegPermisosgrupos s WHERE s.anular = :anular")
    , @NamedQuery(name = "SegPermisosgrupos.deleteByGrupousuarioid", query = "DELETE FROM SegPermisosgrupos s WHERE s.segPermisosgruposPK.grupousuarioid = :grupousuarioid")})
public class SegPermisosgrupos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SegPermisosgruposPK segPermisosgruposPK;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean guardar;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean buscar;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean modificar;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean imprimir;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean eliminar;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean anular;
    @JoinColumn(name = "grupousuarioid", referencedColumnName = "grupousuarioid", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegGruposusuarios segGruposusuarios;
    @JoinColumn(name = "menuid", referencedColumnName = "menuid", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegMenus segMenus;

    public SegPermisosgrupos() {
    }

    public SegPermisosgrupos(SegPermisosgruposPK segPermisosgruposPK) {
        this.segPermisosgruposPK = segPermisosgruposPK;
    }

    public SegPermisosgrupos(SegPermisosgruposPK segPermisosgruposPK, boolean guardar, boolean buscar, boolean modificar, boolean imprimir, boolean eliminar, boolean anular) {
        this.segPermisosgruposPK = segPermisosgruposPK;
        this.guardar = guardar;
        this.buscar = buscar;
        this.modificar = modificar;
        this.imprimir = imprimir;
        this.eliminar = eliminar;
        this.anular = anular;
    }

    public SegPermisosgrupos(int menuid, int grupousuarioid) {
        this.segPermisosgruposPK = new SegPermisosgruposPK(menuid, grupousuarioid);
    }

    public SegPermisosgruposPK getSegPermisosgruposPK() {
        return segPermisosgruposPK;
    }

    public void setSegPermisosgruposPK(SegPermisosgruposPK segPermisosgruposPK) {
        this.segPermisosgruposPK = segPermisosgruposPK;
    }

    public boolean getGuardar() {
        return guardar;
    }

    public void setGuardar(boolean guardar) {
        this.guardar = guardar;
    }

    public boolean getBuscar() {
        return buscar;
    }

    public void setBuscar(boolean buscar) {
        this.buscar = buscar;
    }

    public boolean getModificar() {
        return modificar;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    public boolean getImprimir() {
        return imprimir;
    }

    public void setImprimir(boolean imprimir) {
        this.imprimir = imprimir;
    }

    public boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    public boolean getAnular() {
        return anular;
    }

    public void setAnular(boolean anular) {
        this.anular = anular;
    }

    public SegGruposusuarios getSegGruposusuarios() {
        return segGruposusuarios;
    }

    public void setSegGruposusuarios(SegGruposusuarios segGruposusuarios) {
        this.segGruposusuarios = segGruposusuarios;
    }

    public SegMenus getSegMenus() {
        return segMenus;
    }

    public void setSegMenus(SegMenus segMenus) {
        this.segMenus = segMenus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segPermisosgruposPK != null ? segPermisosgruposPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPermisosgrupos)) {
            return false;
        }
        SegPermisosgrupos other = (SegPermisosgrupos) object;
        if ((this.segPermisosgruposPK == null && other.segPermisosgruposPK != null) || (this.segPermisosgruposPK != null && !this.segPermisosgruposPK.equals(other.segPermisosgruposPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModuloSeg.entities.SegPermisosgrupos[ segPermisosgruposPK=" + segPermisosgruposPK + " ]";
    }

}
