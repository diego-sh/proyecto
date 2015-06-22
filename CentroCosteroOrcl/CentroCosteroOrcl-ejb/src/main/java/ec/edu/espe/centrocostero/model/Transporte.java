/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe.centrocostero.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "TRANSPORTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transporte.findAll", query = "SELECT t FROM Transporte t")})
public class Transporte implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TRANSPORTE", nullable = false, precision = 38, scale = 0)
    private BigDecimal codTransporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "CHOFER", nullable = false, length = 60)
    private String chofer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "PLACA", nullable = false, length = 7)
    private String placa;
    @Size(max = 200)
    @Column(name = "DESC__TRANSPORTE", length = 200)
    private String descTransporte;
    @OneToMany(mappedBy = "codTransporte")
    private List<Visita> visitaList;

    public Transporte() {
    }

    public Transporte(BigDecimal codTransporte) {
        this.codTransporte = codTransporte;
    }

    public Transporte(BigDecimal codTransporte, String chofer, String placa) {
        this.codTransporte = codTransporte;
        this.chofer = chofer;
        this.placa = placa;
    }

    public BigDecimal getCodTransporte() {
        return codTransporte;
    }

    public void setCodTransporte(BigDecimal codTransporte) {
        this.codTransporte = codTransporte;
    }

    public String getChofer() {
        return chofer;
    }

    public void setChofer(String chofer) {
        this.chofer = chofer;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDescTransporte() {
        return descTransporte;
    }

    public void setDescTransporte(String descTransporte) {
        this.descTransporte = descTransporte;
    }

    @XmlTransient
    public List<Visita> getVisitaList() {
        return visitaList;
    }

    public void setVisitaList(List<Visita> visitaList) {
        this.visitaList = visitaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTransporte != null ? codTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transporte)) {
            return false;
        }
        Transporte other = (Transporte) object;
        if ((this.codTransporte == null && other.codTransporte != null) || (this.codTransporte != null && !this.codTransporte.equals(other.codTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.centrocostero.model.Transporte[ codTransporte=" + codTransporte + " ]";
    }
    
}
