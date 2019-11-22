/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general.entities;

import seguridad.entities.SegUsuarios;
import seguridad.entities.SegPermisosusuarios;
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
@Table(name = "gen_empresas")
@NamedQueries({
    @NamedQuery(name = "GenEmpresas.findAll", query = "SELECT g FROM GenEmpresas g")
    , @NamedQuery(name = "GenEmpresas.findByEmpresaid", query = "SELECT g FROM GenEmpresas g WHERE g.empresaid = :empresaid")
    , @NamedQuery(name = "GenEmpresas.findByNombre", query = "SELECT g FROM GenEmpresas g WHERE g.nombre = :nombre")
    , @NamedQuery(name = "GenEmpresas.findByComercial", query = "SELECT g FROM GenEmpresas g WHERE g.comercial = :comercial")
    , @NamedQuery(name = "GenEmpresas.findByCedreplegal", query = "SELECT g FROM GenEmpresas g WHERE g.cedreplegal = :cedreplegal")
    , @NamedQuery(name = "GenEmpresas.findByReplegal", query = "SELECT g FROM GenEmpresas g WHERE g.replegal = :replegal")
    , @NamedQuery(name = "GenEmpresas.findByEstado", query = "SELECT g FROM GenEmpresas g WHERE g.estado = :estado")
    , @NamedQuery(name = "GenEmpresas.getNextId", query = "SELECT MAX(coalesce(g.empresaid, 0)) + 1 FROM GenEmpresas g")})

public class GenEmpresas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer empresaid;
    @Basic(optional = false)
    @Column(nullable = false, length = 150)
    private String nombre;
    @Basic(optional = false)
    @Column(nullable = false, length = 150)
    private String comercial;
    @Basic(optional = false)
    @Column(nullable = false, length = 13)
    private String cedreplegal;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String replegal;
    @Basic(optional = false)
    @Column(nullable = false, length = 1)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaid")
    private List<GenSucursales> genSucursalesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaid")
    private List<SegUsuarios> segUsuariosList;

    public GenEmpresas() {
    }

    public GenEmpresas(Integer empresaid) {
        this.empresaid = empresaid;
    }

    public GenEmpresas(Integer empresaid, String nombre, String comercial, String cedreplegal, String replegal, String estado) {
        this.empresaid = empresaid;
        this.nombre = nombre;
        this.comercial = comercial;
        this.cedreplegal = cedreplegal;
        this.replegal = replegal;
        this.estado = estado;
    }

    public Integer getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(Integer empresaid) {
        this.empresaid = empresaid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComercial() {
        return comercial;
    }

    public void setComercial(String comercial) {
        this.comercial = comercial;
    }

    public String getCedreplegal() {
        return cedreplegal;
    }

    public void setCedreplegal(String cedreplegal) {
        this.cedreplegal = cedreplegal;
    }

    public String getReplegal() {
        return replegal;
    }

    public void setReplegal(String replegal) {
        this.replegal = replegal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<GenSucursales> getGenSucursalesList() {
        return genSucursalesList;
    }

    public void setGenSucursalesList(List<GenSucursales> genSucursalesList) {
        this.genSucursalesList = genSucursalesList;
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
        hash += (empresaid != null ? empresaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenEmpresas)) {
            return false;
        }
        GenEmpresas other = (GenEmpresas) object;
        if ((this.empresaid == null && other.empresaid != null) || (this.empresaid != null && !this.empresaid.equals(other.empresaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModuloGen.entities.GenEmpresas[ empresaid=" + empresaid + " ]";
    }

}
