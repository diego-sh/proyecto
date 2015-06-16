/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe.centrocostero.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "VISITA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visita.findAll", query = "SELECT v FROM Visita v")})
public class Visita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "COD_VISITA", nullable = false, length = 8)
    private String codVisita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VISITA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVisita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ESTADO_FACTURA", nullable = false, length = 3)
    private String estadoFactura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR_VISITA", precision = 3, scale = 2)
    private BigDecimal valorVisita;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visita")
    private List<ConsumoActividad> consumoActividadList;
    @OneToMany(mappedBy = "codVisita")
    private List<Consumo> consumoList;
    @JoinColumn(name = "COD_USUARIO", referencedColumnName = "COD_USUARIO")
    @ManyToOne
    private Usuario codUsuario;
    @JoinColumn(name = "COD_TRANSPORTE", referencedColumnName = "COD_TRANSPORTE")
    @ManyToOne
    private Transporte codTransporte;
    @JoinColumn(name = "COD_ESTABLECIMIENTO", referencedColumnName = "COD_ESTABLECIMIENTO")
    @ManyToOne
    private Establecimiento codEstablecimiento;
    @JoinColumn(name = "CEDULA", referencedColumnName = "CEDULA")
    @ManyToOne
    private Cliente cedula;

    public Visita() {
    }

    public Visita(String codVisita) {
        this.codVisita = codVisita;
    }

    public Visita(String codVisita, Date fechaVisita, String estadoFactura) {
        this.codVisita = codVisita;
        this.fechaVisita = fechaVisita;
        this.estadoFactura = estadoFactura;
    }

    public String getCodVisita() {
        return codVisita;
    }

    public void setCodVisita(String codVisita) {
        this.codVisita = codVisita;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public String getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(String estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public BigDecimal getValorVisita() {
        return valorVisita;
    }

    public void setValorVisita(BigDecimal valorVisita) {
        this.valorVisita = valorVisita;
    }

    @XmlTransient
    public List<ConsumoActividad> getConsumoActividadList() {
        return consumoActividadList;
    }

    public void setConsumoActividadList(List<ConsumoActividad> consumoActividadList) {
        this.consumoActividadList = consumoActividadList;
    }

    @XmlTransient
    public List<Consumo> getConsumoList() {
        return consumoList;
    }

    public void setConsumoList(List<Consumo> consumoList) {
        this.consumoList = consumoList;
    }

    public Usuario getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Usuario codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Transporte getCodTransporte() {
        return codTransporte;
    }

    public void setCodTransporte(Transporte codTransporte) {
        this.codTransporte = codTransporte;
    }

    public Establecimiento getCodEstablecimiento() {
        return codEstablecimiento;
    }

    public void setCodEstablecimiento(Establecimiento codEstablecimiento) {
        this.codEstablecimiento = codEstablecimiento;
    }

    public Cliente getCedula() {
        return cedula;
    }

    public void setCedula(Cliente cedula) {
        this.cedula = cedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVisita != null ? codVisita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visita)) {
            return false;
        }
        Visita other = (Visita) object;
        if ((this.codVisita == null && other.codVisita != null) || (this.codVisita != null && !this.codVisita.equals(other.codVisita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.centrocostero.model.Visita[ codVisita=" + codVisita + " ]";
    }
    
}
