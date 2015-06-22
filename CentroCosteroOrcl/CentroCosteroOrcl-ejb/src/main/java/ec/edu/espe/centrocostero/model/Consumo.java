/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe.centrocostero.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "CONSUMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consumo.findAll", query = "SELECT c FROM Consumo c")})
public class Consumo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CONSUMO", nullable = false)
    private Short codConsumo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_PRODUCTO", nullable = false)
    private BigInteger cantidadProducto;
    @Size(max = 100)
    @Column(name = "DETALLE", length = 100)
    private String detalle;
    @JoinColumn(name = "COD_VISITA", referencedColumnName = "COD_VISITA")
    @ManyToOne
    private Visita codVisita;
    @JoinColumn(name = "COD_PRODUCTO", referencedColumnName = "COD_PRODUCTO")
    @ManyToOne
    private Producto codProducto;

    public Consumo() {
    }

    public Consumo(Short codConsumo) {
        this.codConsumo = codConsumo;
    }

    public Consumo(Short codConsumo, BigInteger cantidadProducto) {
        this.codConsumo = codConsumo;
        this.cantidadProducto = cantidadProducto;
    }

    public Short getCodConsumo() {
        return codConsumo;
    }

    public void setCodConsumo(Short codConsumo) {
        this.codConsumo = codConsumo;
    }

    public BigInteger getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(BigInteger cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Visita getCodVisita() {
        return codVisita;
    }

    public void setCodVisita(Visita codVisita) {
        this.codVisita = codVisita;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codConsumo != null ? codConsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consumo)) {
            return false;
        }
        Consumo other = (Consumo) object;
        if ((this.codConsumo == null && other.codConsumo != null) || (this.codConsumo != null && !this.codConsumo.equals(other.codConsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.centrocostero.model.Consumo[ codConsumo=" + codConsumo + " ]";
    }
    
}
