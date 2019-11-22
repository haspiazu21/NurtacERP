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
@Table(name = "seg_menus")
@NamedQueries({
    @NamedQuery(name = "SegMenus.findAll", query = "SELECT s FROM SegMenus s")
    , @NamedQuery(name = "SegMenus.findByMenuid", query = "SELECT s FROM SegMenus s WHERE s.menuid = :menuid")
    , @NamedQuery(name = "SegMenus.findByNombre", query = "SELECT s FROM SegMenus s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SegMenus.findByFormulario", query = "SELECT s FROM SegMenus s WHERE s.formulario = :formulario")
    , @NamedQuery(name = "SegMenus.findByImagen", query = "SELECT s FROM SegMenus s WHERE s.imagen = :imagen")
    , @NamedQuery(name = "SegMenus.findByEstado", query = "SELECT s FROM SegMenus s WHERE s.estado = :estado")
    , @NamedQuery(name = "SegMenus.findByModuloid", query = "SELECT s FROM SegMenus s WHERE s.moduloid.moduloid = :moduloid")
    , @NamedQuery(name = "SegMenus.findByPermisoUsuario", query = "SELECT m FROM SegPermisosusuarios p "
            + "INNER JOIN p.segMenus m "
            + "INNER JOIN m.moduloid d  "
            + "WHERE d.moduloid = :moduloid "
            + " AND p.segUsuarios.usuarioid = :usuarioid ")
    , @NamedQuery(name = "SegMenus.findByPermisoGrupo", query = "SELECT m FROM SegPermisosgrupos p "
            + "INNER JOIN p.segMenus m "
            + "INNER JOIN m.moduloid d  "
            + "WHERE d.moduloid = :moduloid "
            + " AND p.segGruposusuarios.grupousuarioid = :grupousuarioid")
    , @NamedQuery(name = "SegMenus.findPermisosGrupo", query = "SELECT m FROM SegMenus m "
            + "LEFT JOIN FETCH m.segPermisosgruposList p "
            + "WHERE (p.segGruposusuarios.grupousuarioid = :grupousuarioid OR p is NULL)")
    , @NamedQuery(name = "SegMenus.getNextId", query = "SELECT MAX(coalesce(s.menuid, 0)) + 1 FROM SegMenus s")})
public class SegMenus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer menuid;
    @Basic(optional = false)
    @Column(nullable = false, length = 150)
    private String nombre;
    @Basic(optional = false)
    @Column(nullable = false, length = 150)
    private String formulario;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String imagen;
    @Basic(optional = false)
    @Column(nullable = false, length = 1)
    private String estado;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segMenus")
    private List<SegPermisosusuarios> segPermisosusuariosList;
    @JoinColumn(name = "moduloid", referencedColumnName = "moduloid", nullable = false)
    @ManyToOne(optional = false)
    private SegModulos moduloid;
    @JoinColumn(name = "tipomenuid", referencedColumnName = "tipomenuid", nullable = false)
    @ManyToOne(optional = false)
    private SegTiposmenu tipomenuid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segMenus")
    private List<SegPermisosgrupos> segPermisosgruposList;

    public SegMenus() {
    }

    public SegMenus(Integer menuid) {
        this.menuid = menuid;
    }

    public SegMenus(Integer menuid, String nombre, String formulario, String imagen, String estado, boolean guardar, boolean buscar, boolean modificar, boolean imprimir, boolean eliminar, boolean anular) {
        this.menuid = menuid;
        this.nombre = nombre;
        this.formulario = formulario;
        this.imagen = imagen;
        this.estado = estado;
        this.guardar = guardar;
        this.buscar = buscar;
        this.modificar = modificar;
        this.imprimir = imprimir;
        this.eliminar = eliminar;
        this.anular = anular;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isGuardar() {
        return guardar;
    }

    public void setGuardar(boolean guardar) {
        this.guardar = guardar;
    }

    public boolean isBuscar() {
        return buscar;
    }

    public void setBuscar(boolean buscar) {
        this.buscar = buscar;
    }

    public boolean isModificar() {
        return modificar;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    public boolean isImprimir() {
        return imprimir;
    }

    public void setImprimir(boolean imprimir) {
        this.imprimir = imprimir;
    }

    public boolean isEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    public boolean isAnular() {
        return anular;
    }

    public void setAnular(boolean anular) {
        this.anular = anular;
    }

    public List<SegPermisosusuarios> getSegPermisosusuariosList() {
        return segPermisosusuariosList;
    }

    public void setSegPermisosusuariosList(List<SegPermisosusuarios> segPermisosusuariosList) {
        this.segPermisosusuariosList = segPermisosusuariosList;
    }

    public SegModulos getModuloid() {
        return moduloid;
    }

    public void setModuloid(SegModulos moduloid) {
        this.moduloid = moduloid;
    }

    public SegTiposmenu getTipomenuid() {
        return tipomenuid;
    }

    public void setTipomenuid(SegTiposmenu tipomenuid) {
        this.tipomenuid = tipomenuid;
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
        hash += (menuid != null ? menuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegMenus)) {
            return false;
        }
        SegMenus other = (SegMenus) object;
        if ((this.menuid == null && other.menuid != null) || (this.menuid != null && !this.menuid.equals(other.menuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.general.SegMenus[ menuid=" + menuid + " ]";
    }

}
