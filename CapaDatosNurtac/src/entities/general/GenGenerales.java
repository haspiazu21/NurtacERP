/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.general;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Ellet
 */
@Entity
@Table(name = "gen_generales")
@NamedQueries({
    @NamedQuery(name = "GenGenerales.findAll", query = "SELECT g FROM GenGenerales g")
    , @NamedQuery(name = "GenGenerales.findByGeneralid", query = "SELECT g FROM GenGenerales g WHERE g.generalid = :generalid")
    , @NamedQuery(name = "GenGenerales.findBySiglatipo", query = "SELECT g FROM GenGenerales g WHERE g.siglatipo = :siglatipo")
    , @NamedQuery(name = "GenGenerales.findByNombre", query = "SELECT g FROM GenGenerales g WHERE g.nombre = :nombre")
    , @NamedQuery(name = "GenGenerales.findByEstado", query = "SELECT g FROM GenGenerales g WHERE g.estado = :estado")
    , @NamedQuery(name = "GenGenerales.getNextId", query = "SELECT coalesce(g.generalid, 0) + 1 FROM GenGenerales g")})
public class GenGenerales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer generalid;
    @Basic(optional = false)
    @Column(nullable = false, length = 3)
    private String siglatipo;
    @Basic(optional = false)
    @Column(nullable = false, length = 150)
    private String nombre;
    @Basic(optional = false)
    @Column(nullable = false, length = 1)
    private String estado;

    public GenGenerales() {
    }

    public GenGenerales(Integer generalid) {
        this.generalid = generalid;
    }

    public GenGenerales(Integer generalid, String siglatipo, String nombre, String estado) {
        this.generalid = generalid;
        this.siglatipo = siglatipo;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getGeneralid() {
        return generalid;
    }

    public void setGeneralid(Integer generalid) {
        this.generalid = generalid;
    }

    public String getSiglatipo() {
        return siglatipo;
    }

    public void setSiglatipo(String siglatipo) {
        this.siglatipo = siglatipo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (generalid != null ? generalid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenGenerales)) {
            return false;
        }
        GenGenerales other = (GenGenerales) object;
        if ((this.generalid == null && other.generalid != null) || (this.generalid != null && !this.generalid.equals(other.generalid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.general.GenGenerales[ generalid=" + generalid + " ]";
    }

}
