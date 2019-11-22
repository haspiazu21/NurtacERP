/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.entities;

import general.entities.GenEmpresas;
import general.entities.GenSucursales;
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
@Table(name = "seg_permisosusuarios")
@NamedQueries({
    @NamedQuery(name = "SegPermisosusuarios.findAll", query = "SELECT s FROM SegPermisosusuarios s")
    , @NamedQuery(name = "SegPermisosusuarios.findByMenuid", query = "SELECT s FROM SegPermisosusuarios s WHERE s.segPermisosusuariosPK.menuid = :menuid")
    , @NamedQuery(name = "SegPermisosusuarios.findByUsuarioid", query = "SELECT s FROM SegPermisosusuarios s WHERE s.segPermisosusuariosPK.usuarioid = :usuarioid")
    , @NamedQuery(name = "SegPermisosusuarios.findByGuardar", query = "SELECT s FROM SegPermisosusuarios s WHERE s.guardar = :guardar")
    , @NamedQuery(name = "SegPermisosusuarios.findByBuscar", query = "SELECT s FROM SegPermisosusuarios s WHERE s.buscar = :buscar")
    , @NamedQuery(name = "SegPermisosusuarios.findByModificar", query = "SELECT s FROM SegPermisosusuarios s WHERE s.modificar = :modificar")
    , @NamedQuery(name = "SegPermisosusuarios.findByImprimir", query = "SELECT s FROM SegPermisosusuarios s WHERE s.imprimir = :imprimir")
    , @NamedQuery(name = "SegPermisosusuarios.findByEliminar", query = "SELECT s FROM SegPermisosusuarios s WHERE s.eliminar = :eliminar")
    , @NamedQuery(name = "SegPermisosusuarios.findByAnular", query = "SELECT s FROM SegPermisosusuarios s WHERE s.anular = :anular")
    , @NamedQuery(name = "SegPermisosusuarios.deleteByUsuarioid", query = "DELETE FROM SegPermisosusuarios s WHERE s.segPermisosusuariosPK.usuarioid = :usuarioid")})
public class SegPermisosusuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SegPermisosusuariosPK segPermisosusuariosPK;
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
    @JoinColumn(name = "menuid", referencedColumnName = "menuid", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegMenus segMenus;
    @JoinColumn(name = "usuarioid", referencedColumnName = "usuarioid", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegUsuarios segUsuarios;

    public SegPermisosusuarios() {
    }

    public SegPermisosusuarios(SegPermisosusuariosPK segPermisosusuariosPK) {
        this.segPermisosusuariosPK = segPermisosusuariosPK;
    }

    public SegPermisosusuarios(SegPermisosusuariosPK segPermisosusuariosPK, boolean guardar, boolean buscar, boolean modificar, boolean imprimir, boolean eliminar, boolean anular) {
        this.segPermisosusuariosPK = segPermisosusuariosPK;
        this.guardar = guardar;
        this.buscar = buscar;
        this.modificar = modificar;
        this.imprimir = imprimir;
        this.eliminar = eliminar;
        this.anular = anular;
    }

    public SegPermisosusuarios(int menuid, int usuarioid) {
        this.segPermisosusuariosPK = new SegPermisosusuariosPK(menuid, usuarioid);
    }

    public SegPermisosusuariosPK getSegPermisosusuariosPK() {
        return segPermisosusuariosPK;
    }

    public void setSegPermisosusuariosPK(SegPermisosusuariosPK segPermisosusuariosPK) {
        this.segPermisosusuariosPK = segPermisosusuariosPK;
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

    public SegMenus getSegMenus() {
        return segMenus;
    }

    public void setSegMenus(SegMenus segMenus) {
        this.segMenus = segMenus;
    }

    public SegUsuarios getSegUsuarios() {
        return segUsuarios;
    }

    public void setSegUsuarios(SegUsuarios segUsuarios) {
        this.segUsuarios = segUsuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segPermisosusuariosPK != null ? segPermisosusuariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPermisosusuarios)) {
            return false;
        }
        SegPermisosusuarios other = (SegPermisosusuarios) object;
        if ((this.segPermisosusuariosPK == null && other.segPermisosusuariosPK != null) || (this.segPermisosusuariosPK != null && !this.segPermisosusuariosPK.equals(other.segPermisosusuariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModuloSeg.entities.SegPermisosusuarios[ segPermisosusuariosPK=" + segPermisosusuariosPK + " ]";
    }

}
