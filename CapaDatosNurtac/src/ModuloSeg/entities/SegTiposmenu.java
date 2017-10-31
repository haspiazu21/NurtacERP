/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloSeg.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ellet
 */
@Entity
@Table(name = "seg_tiposmenu")
@NamedQueries({
    @NamedQuery(name = "SegTiposmenu.findAll", query = "SELECT s FROM SegTiposmenu s")
    , @NamedQuery(name = "SegTiposmenu.findByTipomenuid", query = "SELECT s FROM SegTiposmenu s WHERE s.tipomenuid = :tipomenuid")
    , @NamedQuery(name = "SegTiposmenu.findByNombre", query = "SELECT s FROM SegTiposmenu s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SegTiposmenu.findByEstado", query = "SELECT s FROM SegTiposmenu s WHERE s.estado = :estado")
    , @NamedQuery(name = "SegTiposmenu.getNextId", query = "SELECT MAX(coalesce(s.tipomenuid, 0)) + 1 FROM SegTiposmenu s")})
public class SegTiposmenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer tipomenuid;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @Column(nullable = false, length = 1)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipomenuid")
    private List<SegMenus> segMenusList;

    public SegTiposmenu() {
    }

    public SegTiposmenu(Integer tipomenuid) {
        this.tipomenuid = tipomenuid;
    }

    public SegTiposmenu(Integer tipomenuid, String nombre, String estado) {
        this.tipomenuid = tipomenuid;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getTipomenuid() {
        return tipomenuid;
    }

    public void setTipomenuid(Integer tipomenuid) {
        this.tipomenuid = tipomenuid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<SegMenus> getSegMenusList() {
        return segMenusList;
    }

    public void setSegMenusList(List<SegMenus> segMenusList) {
        this.segMenusList = segMenusList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipomenuid != null ? tipomenuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegTiposmenu)) {
            return false;
        }
        SegTiposmenu other = (SegTiposmenu) object;
        if ((this.tipomenuid == null && other.tipomenuid != null) || (this.tipomenuid != null && !this.tipomenuid.equals(other.tipomenuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModuloSeg.entities.SegTiposmenu[ tipomenuid=" + tipomenuid + " ]";
    }

}
