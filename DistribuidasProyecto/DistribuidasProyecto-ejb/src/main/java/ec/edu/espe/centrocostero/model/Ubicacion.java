/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe.centrocostero.model;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "UBICACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubicacion.findAll", query = "SELECT u FROM Ubicacion u")})
public class Ubicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "COD_UBICACION", nullable = false, length = 4)
    private String codUbicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_BLOQUE", nullable = false)
    private BigInteger numeroBloque;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "REFERENCIA", nullable = false, length = 100)
    private String referencia;
    @OneToMany(mappedBy = "codUbicacion")
    private List<Establecimiento> establecimientoList;

    public Ubicacion() {
    }

    public Ubicacion(String codUbicacion) {
        this.codUbicacion = codUbicacion;
    }

    public Ubicacion(String codUbicacion, BigInteger numeroBloque, String referencia) {
        this.codUbicacion = codUbicacion;
        this.numeroBloque = numeroBloque;
        this.referencia = referencia;
    }

    public String getCodUbicacion() {
        return codUbicacion;
    }

    public void setCodUbicacion(String codUbicacion) {
        this.codUbicacion = codUbicacion;
    }

    public BigInteger getNumeroBloque() {
        return numeroBloque;
    }

    public void setNumeroBloque(BigInteger numeroBloque) {
        this.numeroBloque = numeroBloque;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @XmlTransient
    public List<Establecimiento> getEstablecimientoList() {
        return establecimientoList;
    }

    public void setEstablecimientoList(List<Establecimiento> establecimientoList) {
        this.establecimientoList = establecimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUbicacion != null ? codUbicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicacion)) {
            return false;
        }
        Ubicacion other = (Ubicacion) object;
        if ((this.codUbicacion == null && other.codUbicacion != null) || (this.codUbicacion != null && !this.codUbicacion.equals(other.codUbicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.centrocostero.model.Ubicacion[ codUbicacion=" + codUbicacion + " ]";
    }
    
}
