/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.migracion.melco.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author JoséAntonio
 */
@Embeddable
public class MarcajePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "compania")
    private String compania;
    @Basic(optional = false)
    @Column(name = "trabajador")
    private String trabajador;
    @Basic(optional = false)
    @Column(name = "marcaje_definitivo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date marcajeDefinitivo;

    public MarcajePK() {
    }

    public MarcajePK(String compania, String trabajador, Date marcajeDefinitivo) {
        this.compania = compania;
        this.trabajador = trabajador;
        this.marcajeDefinitivo = marcajeDefinitivo;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }

    public Date getMarcajeDefinitivo() {
        return marcajeDefinitivo;
    }

    public void setMarcajeDefinitivo(Date marcajeDefinitivo) {
        this.marcajeDefinitivo = marcajeDefinitivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compania != null ? compania.hashCode() : 0);
        hash += (trabajador != null ? trabajador.hashCode() : 0);
        hash += (marcajeDefinitivo != null ? marcajeDefinitivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcajePK)) {
            return false;
        }
        MarcajePK other = (MarcajePK) object;
        if ((this.compania == null && other.compania != null) || (this.compania != null && !this.compania.equals(other.compania))) {
            return false;
        }
        if ((this.trabajador == null && other.trabajador != null) || (this.trabajador != null && !this.trabajador.equals(other.trabajador))) {
            return false;
        }
        if ((this.marcajeDefinitivo == null && other.marcajeDefinitivo != null) || (this.marcajeDefinitivo != null && !this.marcajeDefinitivo.equals(other.marcajeDefinitivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.migracion.melco.entidades.MarcajePK[ compania=" + compania + ", trabajador=" + trabajador + ", marcajeDefinitivo=" + marcajeDefinitivo + " ]";
    }
    
}
