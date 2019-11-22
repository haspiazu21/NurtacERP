/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.seguridad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ellet
 */
@Entity
@Table(name = "seg_bitacora")
@NamedQueries({
    @NamedQuery(name = "SegBitacora.findAll", query = "SELECT s FROM SegBitacora s")
    , @NamedQuery(name = "SegBitacora.findByCodigo", query = "SELECT s FROM SegBitacora s WHERE s.codigo = :codigo")
    , @NamedQuery(name = "SegBitacora.findByEmpresa", query = "SELECT s FROM SegBitacora s WHERE s.empresa = :empresa")
    , @NamedQuery(name = "SegBitacora.findBySucursal", query = "SELECT s FROM SegBitacora s WHERE s.sucursal = :sucursal")
    , @NamedQuery(name = "SegBitacora.findByModulo", query = "SELECT s FROM SegBitacora s WHERE s.modulo = :modulo")
    , @NamedQuery(name = "SegBitacora.findByFecha", query = "SELECT s FROM SegBitacora s WHERE s.fecha = :fecha")
    , @NamedQuery(name = "SegBitacora.findByAccion", query = "SELECT s FROM SegBitacora s WHERE s.accion = :accion")
    , @NamedQuery(name = "SegBitacora.findByUsuario", query = "SELECT s FROM SegBitacora s WHERE s.usuario = :usuario")
    , @NamedQuery(name = "SegBitacora.findByGrupousuario", query = "SELECT s FROM SegBitacora s WHERE s.grupousuario = :grupousuario")
    , @NamedQuery(name = "SegBitacora.getNextId", query = "SELECT MAX(coalesce(s.codigo, 0)) + 1 FROM SegBitacora s")})
public class SegBitacora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codigo;
    @Column(length = 150)
    private String empresa;
    @Column(length = 150)
    private String sucursal;
    @Column(length = 100)
    private String modulo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(length = 500)
    private String accion;
    @Column(length = 100)
    private String usuario;
    @Column(length = 100)
    private String grupousuario;

    public SegBitacora() {
    }

    public SegBitacora(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getGrupousuario() {
        return grupousuario;
    }

    public void setGrupousuario(String grupousuario) {
        this.grupousuario = grupousuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegBitacora)) {
            return false;
        }
        SegBitacora other = (SegBitacora) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.general.SegBitacora[ codigo=" + codigo + " ]";
    }

}
