/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.centrocostero.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "VISITA")

public class Visita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "COD_VISITA", nullable = false, length = 8)
    private String codigo;
    @Column(name = "FECHA_VISITA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "ESTADO_FACTURA", nullable = false, length = 3)
    private String estadoFactura;
    @Column(name = "VALOR_VISITA", precision = 3, scale = 2)
    private BigDecimal valor;
    @Column(name = "COD_USUARIO")
    private String codigoUsuario;
    @Column(name = "COD_TRANSPORTE")
    private Integer codigoTransporte;
    @Column(name = "COD_ESTABLECIMIENTO")
    private String codigoEstablecimiento;
    @Column(name = "CEDULA")
    private String cedula;

    @JoinColumn(name = "COD_USUARIO", referencedColumnName = "COD_USUARIO", insertable = false, updatable = false)
    @ManyToOne
    private Usuario usuario;
    @JoinColumn(name = "COD_TRANSPORTE", referencedColumnName = "COD_TRANSPORTE", insertable = false, updatable = false)
    @ManyToOne
    private Transporte transporte;
    @JoinColumn(name = "COD_ESTABLECIMIENTO", referencedColumnName = "COD_ESTABLECIMIENTO", insertable = false, updatable = false)
    @ManyToOne
    private Establecimiento establecimiento;
    @JoinColumn(name = "CEDULA", referencedColumnName = "CEDULA", insertable = false, updatable = false)
    @ManyToOne
    private Cliente cliente;

    public Visita() {
    }

    public Visita(String codVisita) {
        this.codigo = codVisita;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(String estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Integer getCodigoTransporte() {
        return codigoTransporte;
    }

    public void setCodigoTransporte(Integer codigoTransporte) {
        this.codigoTransporte = codigoTransporte;
    }

    public String getCodigoEstablecimiento() {
        return codigoEstablecimiento;
    }

    public void setCodigoEstablecimiento(String codigoEstablecimiento) {
        this.codigoEstablecimiento = codigoEstablecimiento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visita)) {
            return false;
        }
        Visita other = (Visita) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Visita{" + "codigo=" + codigo + ", fecha=" + fecha + ", estadoFactura=" + estadoFactura + ", valor=" + valor + ", codigoUsuario=" + codigoUsuario + ", codigoTransporte=" + codigoTransporte + ", codigoEstablecimiento=" + codigoEstablecimiento + ", cedula=" + cedula + ", usuario=" + usuario + '}';
    }

}
