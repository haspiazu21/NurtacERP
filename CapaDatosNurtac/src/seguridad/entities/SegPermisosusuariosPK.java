/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ellet
 */
@Embeddable
public class SegPermisosusuariosPK implements Serializable {

    @Basic(optional = false)
    @Column(nullable = false)
    private int menuid;
    @Basic(optional = false)
    @Column(nullable = false)
    private int usuarioid;

    public SegPermisosusuariosPK() {
    }

    public SegPermisosusuariosPK(int menuid, int usuarioid) {
        this.menuid = menuid;
        this.usuarioid = usuarioid;
    }

    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) menuid;
        hash += (int) usuarioid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPermisosusuariosPK)) {
            return false;
        }
        SegPermisosusuariosPK other = (SegPermisosusuariosPK) object;
        if (this.menuid != other.menuid) {
            return false;
        }
        if (this.usuarioid != other.usuarioid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModuloSeg.entities.SegPermisosusuariosPK[ menuid=" + menuid + ", usuarioid=" + usuarioid + " ]";
    }
    
}
