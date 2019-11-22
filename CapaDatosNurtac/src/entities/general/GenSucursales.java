/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.general;

import entities.seguridad.SegUsuarios;
import entities.seguridad.SegPermisosusuarios;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ellet
 */
@Entity
@Table(name = "gen_sucursales")
@NamedQueries({
    @NamedQuery(name = "GenSucursales.findAll", query = "SELECT g FROM GenSucursales g")
    , @NamedQuery(name = "GenSucursales.findBySucursalid", query = "SELECT g FROM GenSucursales g WHERE g.sucursalid = :sucursalid")
    , @NamedQuery(name = "GenSucursales.findByNombre", query = "SELECT g FROM GenSucursales g WHERE g.nombre = :nombre")
    , @NamedQuery(name = "GenSucursales.findByDireccion", query = "SELECT g FROM GenSucursales g WHERE g.direccion = :direccion")
    , @NamedQuery(name = "GenSucursales.findByTelefono", query = "SELECT g FROM GenSucursales g WHERE g.telefono = :telefono")
    , @NamedQuery(name = "GenSucursales.findByEmail", query = "SELECT g FROM GenSucursales g WHERE g.email = :email")
    , @NamedQuery(name = "GenSucursales.findByEstado", query = "SELECT g FROM GenSucursales g WHERE g.estado = :estado")
    , @NamedQuery(name = "GenSucursales.findByEmpresaid", query = "SELECT g FROM GenSucursales g WHERE g.empresaid.empresaid = :empresaid")
    , @NamedQuery(name = "GenSucursales.getNextId", query = "SELECT coalesce(g.sucursalid, 0) + 1 FROM GenSucursales g")})
public class GenSucursales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer sucursalid;
    @Basic(optional = false)
    @Column(nullable = false, length = 13, unique = true)
    private String ruc;
    @Basic(optional = false)
    @Column(nullable = false, length = 150)
    private String nombre;
    @Basic(optional = false)
    @Column(nullable = false, length = 150)
    private String direccion;
    @Basic(optional = false)
    @Column(nullable = false, length = 15)
    private String telefono;
    @Basic(optional = false)
    @Column(nullable = false, length = 150)
    private String email;
    @Basic(optional = false)
    @Column(nullable = false, length = 1)
    private String estado;
    @JoinColumn(name = "empresaid", referencedColumnName = "empresaid", nullable = false)
    @ManyToOne(optional = false)
    private GenEmpresas empresaid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursalid")
    private List<SegUsuarios> segUsuariosList;

    public GenSucursales() {
    }

    public GenSucursales(Integer sucursalid) {
        this.sucursalid = sucursalid;
    }

    public GenSucursales(Integer sucursalid, String nombre, String direccion, String telefono, String email, String estado) {
        this.sucursalid = sucursalid;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
    }

    public Integer getSucursalid() {
        return sucursalid;
    }

    public void setSucursalid(Integer sucursalid) {
        this.sucursalid = sucursalid;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public GenEmpresas getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(GenEmpresas empresaid) {
        this.empresaid = empresaid;
    }

    public List<SegUsuarios> getSegUsuariosList() {
        return segUsuariosList;
    }

    public void setSegUsuariosList(List<SegUsuarios> segUsuariosList) {
        this.segUsuariosList = segUsuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sucursalid != null ? sucursalid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenSucursales)) {
            return false;
        }
        GenSucursales other = (GenSucursales) object;
        if ((this.sucursalid == null && other.sucursalid != null) || (this.sucursalid != null && !this.sucursalid.equals(other.sucursalid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.general.GenSucursales[ sucursalid=" + sucursalid + " ]";
    }

}
