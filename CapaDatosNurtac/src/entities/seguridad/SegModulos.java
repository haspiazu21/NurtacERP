/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.seguridad;

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
@Table(name = "seg_modulos")
@NamedQueries({
    @NamedQuery(name = "SegModulos.findAll", query = "SELECT s FROM SegModulos s")
    , @NamedQuery(name = "SegModulos.findByModuloid", query = "SELECT s FROM SegModulos s WHERE s.moduloid = :moduloid")
    , @NamedQuery(name = "SegModulos.findByNombre", query = "SELECT s FROM SegModulos s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SegModulos.findByEstado", query = "SELECT s FROM SegModulos s WHERE s.estado = :estado")
    , @NamedQuery(name = "SegModulos.getNextId", query = "SELECT coalesce(s.moduloid, 0) + 1 FROM SegModulos s")})
public class SegModulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer moduloid;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @Column(nullable = false, length = 1)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduloid")
    private List<SegMenus> segMenusList;

    public SegModulos() {
    }

    public SegModulos(Integer moduloid) {
        this.moduloid = moduloid;
    }

    public SegModulos(Integer moduloid, String nombre, String estado) {
        this.moduloid = moduloid;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getModuloid() {
        return moduloid;
    }

    public void setModuloid(Integer moduloid) {
        this.moduloid = moduloid;
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
        hash += (moduloid != null ? moduloid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegModulos)) {
            return false;
        }
        SegModulos other = (SegModulos) object;
        if ((this.moduloid == null && other.moduloid != null) || (this.moduloid != null && !this.moduloid.equals(other.moduloid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.general.SegModulos[ moduloid=" + moduloid + " ]";
    }

}
