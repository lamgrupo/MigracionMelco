/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.migracion.melco.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "ta_marcajes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marcaje.findAll", query = "SELECT m FROM Marcaje m WHERE m.idTerminal > 6 AND m.idTerminal < 10 ORDER BY m.marcajePK.marcajeDefinitivo DESC"),
    @NamedQuery(name = "Marcaje.findByCompania", query = "SELECT m FROM Marcaje m WHERE m.marcajePK.compania = :compania"),
    @NamedQuery(name = "Marcaje.findByTrabajador", query = "SELECT m FROM Marcaje m WHERE m.marcajePK.trabajador = :trabajador"),
    @NamedQuery(name = "Marcaje.findByMarcajeDefinitivo", query = "SELECT m FROM Marcaje m WHERE m.marcajePK.marcajeDefinitivo = :marcajeDefinitivo"),
    @NamedQuery(name = "Marcaje.findByMarcajeOriginal", query = "SELECT m FROM Marcaje m WHERE m.marcajeOriginal = :marcajeOriginal"),
    @NamedQuery(name = "Marcaje.findByTipoMarcaje", query = "SELECT m FROM Marcaje m WHERE m.tipoMarcaje = :tipoMarcaje"),
    @NamedQuery(name = "Marcaje.findByNumeroCredencial", query = "SELECT m FROM Marcaje m WHERE m.numeroCredencial = :numeroCredencial"),
    @NamedQuery(name = "Marcaje.findByFechaAplicarNomina", query = "SELECT m FROM Marcaje m WHERE m.fechaAplicarNomina = :fechaAplicarNomina"),
    @NamedQuery(name = "Marcaje.findByReferencia", query = "SELECT m FROM Marcaje m WHERE m.referencia = :referencia"),
    @NamedQuery(name = "Marcaje.findByUsuario", query = "SELECT m FROM Marcaje m WHERE m.usuario = :usuario"),
    @NamedQuery(name = "Marcaje.findByFechaRegistro", query = "SELECT m FROM Marcaje m WHERE m.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Marcaje.findByFechaModificacion", query = "SELECT m FROM Marcaje m WHERE m.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Marcaje.findByTurno", query = "SELECT m FROM Marcaje m WHERE m.turno = :turno")})
public class Marcaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MarcajePK marcajePK;
    @Basic(optional = false)
    @Column(name = "marcaje_original")
    @Temporal(TemporalType.TIMESTAMP)
    private Date marcajeOriginal;
    @Basic(optional = false)
    @Column(name = "tipo_marcaje")
    private int tipoMarcaje;
    @Basic(optional = false)
    @Column(name = "numero_credencial")
    private String numeroCredencial;
    @Basic(optional = false)
    @Column(name = "fecha_aplicar_nomina")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAplicarNomina;
    @Basic(optional = false)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "turno")
    private Short turno;
    @Column(name = "id_terminal")
    private Integer idTerminal;

    public Marcaje() {
    }

    public Marcaje(MarcajePK marcajePK) {
        this.marcajePK = marcajePK;
    }

    public Marcaje(MarcajePK marcajePK, Date marcajeOriginal, int tipoMarcaje, String numeroCredencial, Date fechaAplicarNomina, String referencia, String usuario, Date fechaRegistro, Date fechaModificacion) {
        this.marcajePK = marcajePK;
        this.marcajeOriginal = marcajeOriginal;
        this.tipoMarcaje = tipoMarcaje;
        this.numeroCredencial = numeroCredencial;
        this.fechaAplicarNomina = fechaAplicarNomina;
        this.referencia = referencia;
        this.usuario = usuario;
        this.fechaRegistro = fechaRegistro;
        this.fechaModificacion = fechaModificacion;
    }

    public Marcaje(String compania, String trabajador, Date marcajeDefinitivo) {
        this.marcajePK = new MarcajePK(compania, trabajador, marcajeDefinitivo);
    }

    public MarcajePK getMarcajePK() {
        return marcajePK;
    }

    public void setMarcajePK(MarcajePK marcajePK) {
        this.marcajePK = marcajePK;
    }

    public Date getMarcajeOriginal() {
        return marcajeOriginal;
    }

    public void setMarcajeOriginal(Date marcajeOriginal) {
        this.marcajeOriginal = marcajeOriginal;
    }

    public int getTipoMarcaje() {
        return tipoMarcaje;
    }

    public void setTipoMarcaje(int tipoMarcaje) {
        this.tipoMarcaje = tipoMarcaje;
    }

    public String getNumeroCredencial() {
        return numeroCredencial;
    }

    public void setNumeroCredencial(String numeroCredencial) {
        this.numeroCredencial = numeroCredencial;
    }

    public Date getFechaAplicarNomina() {
        return fechaAplicarNomina;
    }

    public void setFechaAplicarNomina(Date fechaAplicarNomina) {
        this.fechaAplicarNomina = fechaAplicarNomina;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Short getTurno() {
        return turno;
    }

    public void setTurno(Short turno) {
        this.turno = turno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marcajePK != null ? marcajePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marcaje)) {
            return false;
        }
        Marcaje other = (Marcaje) object;
        if ((this.marcajePK == null && other.marcajePK != null) || (this.marcajePK != null && !this.marcajePK.equals(other.marcajePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.migracion.melco.entidades.Marcaje[ marcajePK=" + marcajePK + " ]";
    }

    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }
}
