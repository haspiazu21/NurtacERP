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
@Table(name = "seg_gruposusuarios")
@NamedQueries({
    @NamedQuery(name = "SegGruposusuarios.findAll", query = "SELECT s FROM SegGruposusuarios s")
    , @NamedQuery(name = "SegGruposusuarios.findByGrupousuarioid", query = "SELECT s FROM SegGruposusuarios s WHERE s.grupousuarioid = :grupousuarioid")
    , @NamedQuery(name = "SegGruposusuarios.findByNombre", query = "SELECT s FROM SegGruposusuarios s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SegGruposusuarios.findByEstado", query = "SELECT s FROM SegGruposusuarios s WHERE s.estado = :estado")
    , @NamedQuery(name = "SegGruposusuarios.getNextId", query = "SELECT MAX(coalesce(s.grupousuarioid, 0)) + 1 FROM SegGruposusuarios s")})
public class SegGruposusuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer grupousuarioid;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @Column(nullable = false, length = 200)
    private String descripcion;
    @Basic(optional = false)
    @Column(nullable = false, length = 1)
    private String estado;
    @OneToMany(mappedBy = "grupousuarioid")
    private List<SegUsuarios> segUsuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segGruposusuarios")
    private List<SegPermisosgrupos> segPermisosgruposList;

    public SegGruposusuarios() {
    }

    public SegGruposusuarios(Integer grupousuarioid) {
        this.grupousuarioid = grupousuarioid;
    }

    public SegGruposusuarios(Integer grupousuarioid, String nombre, String descripcion, String estado) {
        this.grupousuarioid = grupousuarioid;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getGrupousuarioid() {
        return grupousuarioid;
    }

    public void setGrupousuarioid(Integer grupousuarioid) {
        this.grupousuarioid = grupousuarioid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<SegUsuarios> getSegUsuariosList() {
        return segUsuariosList;
    }

    public void setSegUsuariosList(List<SegUsuarios> segUsuariosList) {
        this.segUsuariosList = segUsuariosList;
    }

    public List<SegPermisosgrupos> getSegPermisosgruposList() {
        return segPermisosgruposList;
    }

    public void setSegPermisosgruposList(List<SegPermisosgrupos> segPermisosgruposList) {
        this.segPermisosgruposList = segPermisosgruposList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupousuarioid != null ? grupousuarioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegGruposusuarios)) {
            return false;
        }
        SegGruposusuarios other = (SegGruposusuarios) object;
        if ((this.grupousuarioid == null && other.grupousuarioid != null) || (this.grupousuarioid != null && !this.grupousuarioid.equals(other.grupousuarioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModuloSeg.entities.SegGruposusuarios[ grupousuarioid=" + grupousuarioid + " ]";
    }

}
