/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.seguridad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author haspi
 */
@Entity
@Table(name = "seg_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegRoles.findAll", query = "SELECT s FROM SegRoles s"),
    @NamedQuery(name = "SegRoles.findByIdRol", query = "SELECT s FROM SegRoles s WHERE s.idRol = :idRol"),
    @NamedQuery(name = "SegRoles.findByNombreRol", query = "SELECT s FROM SegRoles s WHERE s.nombreRol = :nombreRol and s.modulo = :modulo and s.submodulo = :submodulo"),
    @NamedQuery(name = "SegRoles.findByModulo", query = "SELECT s FROM SegRoles s WHERE s.modulo = :modulo"),
    @NamedQuery(name = "SegRoles.findBySubmodulo", query = "SELECT s FROM SegRoles s WHERE s.submodulo = :submodulo"),
    @NamedQuery(name = "SegRoles.findByEstadoRol", query = "SELECT s FROM SegRoles s WHERE s.estadoRol = :estadoRol"),
    @NamedQuery(name = "SegRoles.getNextId", query = "SELECT MAX(coalesce(idRol, 0)) + 1 FROM SegRoles")})
public class SegRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_rol", nullable = true)
    private Integer idRol;
    @Column(name = "nombre_rol")
    private String nombreRol;
    @Column(name = "modulo")
    private String modulo;
    @Column(name = "submodulo")
    private String submodulo;
    @Column(name = "estado_rol")
    private String estadoRol;

    public SegRoles() {
    }

    public SegRoles(Integer idRol) {
        this.idRol = idRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getSubmodulo() {
        return submodulo;
    }

    public void setSubmodulo(String submodulo) {
        this.submodulo = submodulo;
    }

    public String getEstadoRol() {
        return estadoRol;
    }

    public void setEstadoRol(String estadoRol) {
        this.estadoRol = estadoRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegRoles)) {
            return false;
        }
        SegRoles other = (SegRoles) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.seguridad.SegRoles[ idRol= " + idRol + " nombre rol " + nombreRol  +"]";
    }

    
}
