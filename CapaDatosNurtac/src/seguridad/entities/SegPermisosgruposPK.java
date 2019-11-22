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
public class SegPermisosgruposPK implements Serializable {

    @Basic(optional = false)
    @Column(nullable = false)
    private int menuid;
    @Basic(optional = false)
    @Column(nullable = false)
    private int grupousuarioid;

    public SegPermisosgruposPK() {
    }

    public SegPermisosgruposPK(int menuid, int grupousuarioid) {
        this.menuid = menuid;
        this.grupousuarioid = grupousuarioid;
    }

    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }

    public int getGrupousuarioid() {
        return grupousuarioid;
    }

    public void setGrupousuarioid(int grupousuarioid) {
        this.grupousuarioid = grupousuarioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) menuid;
        hash += (int) grupousuarioid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPermisosgruposPK)) {
            return false;
        }
        SegPermisosgruposPK other = (SegPermisosgruposPK) object;
        if (this.menuid != other.menuid) {
            return false;
        }
        if (this.grupousuarioid != other.grupousuarioid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModuloSeg.entities.SegPermisosgruposPK[ menuid=" + menuid + ", grupousuarioid=" + grupousuarioid + " ]";
    }
    
}
