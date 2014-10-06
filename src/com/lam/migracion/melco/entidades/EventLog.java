/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.migracion.melco.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "TB_EVENT_LOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventLog.findAll", query = "SELECT e FROM EventLog e WHERE e.eventLogPK.nEventIdn = 55 AND e.eventLogPK.nDateTime > :tiempo ORDER BY e.eventLogPK.nDateTime ASC"),
    @NamedQuery(name = "EventLog.findByNEventLogIdn", query = "SELECT e FROM EventLog e WHERE e.nEventLogIdn = :nEventLogIdn"),
    @NamedQuery(name = "EventLog.findByNDateTime", query = "SELECT e FROM EventLog e WHERE e.eventLogPK.nDateTime = :nDateTime"),
    @NamedQuery(name = "EventLog.findByNReaderIdn", query = "SELECT e FROM EventLog e WHERE e.eventLogPK.nReaderIdn = :nReaderIdn"),
    @NamedQuery(name = "EventLog.findByNEventIdn", query = "SELECT e FROM EventLog e WHERE e.eventLogPK.nEventIdn = :nEventIdn"),
    @NamedQuery(name = "EventLog.findByNUserID", query = "SELECT e FROM EventLog e WHERE e.eventLogPK.nUserID = :nUserID"),
    @NamedQuery(name = "EventLog.findByNIsLog", query = "SELECT e FROM EventLog e WHERE e.nIsLog = :nIsLog"),
    @NamedQuery(name = "EventLog.findByNTNAEvent", query = "SELECT e FROM EventLog e WHERE e.nTNAEvent = :nTNAEvent"),
    @NamedQuery(name = "EventLog.findByNIsUseTA", query = "SELECT e FROM EventLog e WHERE e.nIsUseTA = :nIsUseTA"),
    @NamedQuery(name = "EventLog.findByNType", query = "SELECT e FROM EventLog e WHERE e.nType = :nType")})
public class EventLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EventLogPK eventLogPK;
    @Basic(optional = false)
    @Column(name = "nEventLogIdn")
    private int nEventLogIdn;
    @Basic(optional = false)
    @Column(name = "nIsLog")
    private short nIsLog;
    @Basic(optional = false)
    @Column(name = "nTNAEvent")
    private short nTNAEvent;
    @Basic(optional = false)
    @Column(name = "nIsUseTA")
    private short nIsUseTA;
    @Basic(optional = false)
    @Column(name = "nType")
    private short nType;

    public EventLog() {
    }

    public EventLog(EventLogPK eventLogPK) {
        this.eventLogPK = eventLogPK;
    }

    public EventLog(EventLogPK eventLogPK, int nEventLogIdn, short nIsLog, short nTNAEvent, short nIsUseTA, short nType) {
        this.eventLogPK = eventLogPK;
        this.nEventLogIdn = nEventLogIdn;
        this.nIsLog = nIsLog;
        this.nTNAEvent = nTNAEvent;
        this.nIsUseTA = nIsUseTA;
        this.nType = nType;
    }

    public EventLog(int nDateTime, int nReaderIdn, int nEventIdn, int nUserID) {
        this.eventLogPK = new EventLogPK(nDateTime, nReaderIdn, nEventIdn, nUserID);
    }

    public EventLogPK getEventLogPK() {
        return eventLogPK;
    }

    public void setEventLogPK(EventLogPK eventLogPK) {
        this.eventLogPK = eventLogPK;
    }

    public int getNEventLogIdn() {
        return nEventLogIdn;
    }

    public void setNEventLogIdn(int nEventLogIdn) {
        this.nEventLogIdn = nEventLogIdn;
    }

    public short getNIsLog() {
        return nIsLog;
    }

    public void setNIsLog(short nIsLog) {
        this.nIsLog = nIsLog;
    }

    public short getNTNAEvent() {
        return nTNAEvent;
    }

    public void setNTNAEvent(short nTNAEvent) {
        this.nTNAEvent = nTNAEvent;
    }

    public short getNIsUseTA() {
        return nIsUseTA;
    }

    public void setNIsUseTA(short nIsUseTA) {
        this.nIsUseTA = nIsUseTA;
    }

    public short getNType() {
        return nType;
    }

    public void setNType(short nType) {
        this.nType = nType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventLogPK != null ? eventLogPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventLog)) {
            return false;
        }
        EventLog other = (EventLog) object;
        if ((this.eventLogPK == null && other.eventLogPK != null) || (this.eventLogPK != null && !this.eventLogPK.equals(other.eventLogPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.migracion.melco.entidades.EventLog[ eventLogPK=" + eventLogPK + " ]";
    }
    
}
