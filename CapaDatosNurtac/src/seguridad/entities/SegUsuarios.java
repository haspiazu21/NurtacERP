/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.entities;

import general.entities.GenEmpresas;
import general.entities.GenSucursales;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import seguridad.listeners.SegUsuariosListener;

/**
 *
 * @author Ellet
 */
@Entity
@EntityListeners({SegUsuariosListener.class})
@Table(name = "seg_usuarios")
@NamedQueries({
    @NamedQuery(name = "SegUsuarios.findAll", query = "SELECT s FROM SegUsuarios s")
    , @NamedQuery(name = "SegUsuarios.findByUsuarioid", query = "SELECT s FROM SegUsuarios s WHERE s.usuarioid = :usuarioid")
    , @NamedQuery(name = "SegUsuarios.findByUsername", query = "SELECT s FROM SegUsuarios s WHERE s.username = :username")
    , @NamedQuery(name = "SegUsuarios.findByContrasena", query = "SELECT s FROM SegUsuarios s WHERE s.contrasena = :contrasena")
    , @NamedQuery(name = "SegUsuarios.findByNombre", query = "SELECT s FROM SegUsuarios s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SegUsuarios.findByEstado", query = "SELECT s FROM SegUsuarios s WHERE s.estado = :estado")
    , @NamedQuery(name = "SegUsuarios.findByUsernamePassword", query = "SELECT s FROM SegUsuarios s WHERE s.username = :username AND s.contrasena = :password")
    , @NamedQuery(name = "SegUsuarios.getNextId", query = "SELECT MAX(coalesce(s.usuarioid, 0)) + 1 FROM SegUsuarios s")})
public class SegUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer usuarioid;
    @Basic(optional = false)
    @Column(nullable = false, length = 16, unique = true)
    private String username;
    @Basic(optional = false)
    @Column(nullable = false, length = 32)
    private String contrasena;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @Column(nullable = false, length = 1)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segUsuarios")
    private List<SegPermisosusuarios> segPermisosusuariosList;
    @JoinColumn(name = "empresaid", referencedColumnName = "empresaid", nullable = false)
    @ManyToOne(optional = false)
    private GenEmpresas empresaid;
    @JoinColumn(name = "sucursalid", referencedColumnName = "sucursalid", nullable = false)
    @ManyToOne(optional = false)
    private GenSucursales sucursalid;
    @JoinColumn(name = "grupousuarioid", referencedColumnName = "grupousuarioid")
    @ManyToOne
    private SegGruposusuarios grupousuarioid;

    public SegUsuarios() {
    }

    public SegUsuarios(Integer usuarioid) {
        this.usuarioid = usuarioid;
    }

    public SegUsuarios(Integer usuarioid, String username, String contrasena, String nombre, String estado) {
        this.usuarioid = usuarioid;
        this.username = username;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Integer usuarioid) {
        this.usuarioid = usuarioid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public List<SegPermisosusuarios> getSegPermisosusuariosList() {
        return segPermisosusuariosList;
    }

    public void setSegPermisosusuariosList(List<SegPermisosusuarios> segPermisosusuariosList) {
        this.segPermisosusuariosList = segPermisosusuariosList;
    }

    public GenEmpresas getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(GenEmpresas empresaid) {
        this.empresaid = empresaid;
    }

    public GenSucursales getSucursalid() {
        return sucursalid;
    }

    public void setSucursalid(GenSucursales sucursalid) {
        this.sucursalid = sucursalid;
    }

    public SegGruposusuarios getGrupousuarioid() {
        return grupousuarioid;
    }

    public void setGrupousuarioid(SegGruposusuarios grupousuarioid) {
        this.grupousuarioid = grupousuarioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioid != null ? usuarioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuarios)) {
            return false;
        }
        SegUsuarios other = (SegUsuarios) object;
        if ((this.usuarioid == null && other.usuarioid != null) || (this.usuarioid != null && !this.usuarioid.equals(other.usuarioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModuloSeg.entities.SegUsuarios[ usuarioid=" + usuarioid + " ]";
    }

}
