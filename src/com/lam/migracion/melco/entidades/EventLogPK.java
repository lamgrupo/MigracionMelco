/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.migracion.melco.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author JoséAntonio
 */
@Embeddable
public class EventLogPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "nDateTime")
    private int nDateTime;
    @Basic(optional = false)
    @Column(name = "nReaderIdn")
    private int nReaderIdn;
    @Basic(optional = false)
    @Column(name = "nEventIdn")
    private int nEventIdn;
    @Basic(optional = false)
    @Column(name = "nUserID")
    private int nUserID;

    public EventLogPK() {
    }

    public EventLogPK(int nDateTime, int nReaderIdn, int nEventIdn, int nUserID) {
        this.nDateTime = nDateTime;
        this.nReaderIdn = nReaderIdn;
        this.nEventIdn = nEventIdn;
        this.nUserID = nUserID;
    }

    public int getNDateTime() {
        return nDateTime;
    }

    public void setNDateTime(int nDateTime) {
        this.nDateTime = nDateTime;
    }

    public int getNReaderIdn() {
        return nReaderIdn;
    }

    public void setNReaderIdn(int nReaderIdn) {
        this.nReaderIdn = nReaderIdn;
    }

    public int getNEventIdn() {
        return nEventIdn;
    }

    public void setNEventIdn(int nEventIdn) {
        this.nEventIdn = nEventIdn;
    }

    public int getNUserID() {
        return nUserID;
    }

    public void setNUserID(int nUserID) {
        this.nUserID = nUserID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nDateTime;
        hash += (int) nReaderIdn;
        hash += (int) nEventIdn;
        hash += (int) nUserID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventLogPK)) {
            return false;
        }
        EventLogPK other = (EventLogPK) object;
        if (this.nDateTime != other.nDateTime) {
            return false;
        }
        if (this.nReaderIdn != other.nReaderIdn) {
            return false;
        }
        if (this.nEventIdn != other.nEventIdn) {
            return false;
        }
        if (this.nUserID != other.nUserID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.migracion.melco.entidades.EventLogPK[ nDateTime=" + nDateTime + ", nReaderIdn=" + nReaderIdn + ", nEventIdn=" + nEventIdn + ", nUserID=" + nUserID + " ]";
    }
    
}
