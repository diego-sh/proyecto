/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe.centrocostero.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Daniel
 */
@Embeddable
public class ConsumoActividadPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "COD_VISITA", nullable = false, length = 8)
    private String codVisita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "COD_ACTIVIDAD", nullable = false, length = 4)
    private String codActividad;

    public ConsumoActividadPK() {
    }

    public ConsumoActividadPK(String codVisita, String codActividad) {
        this.codVisita = codVisita;
        this.codActividad = codActividad;
    }

    public String getCodVisita() {
        return codVisita;
    }

    public void setCodVisita(String codVisita) {
        this.codVisita = codVisita;
    }

    public String getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(String codActividad) {
        this.codActividad = codActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVisita != null ? codVisita.hashCode() : 0);
        hash += (codActividad != null ? codActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsumoActividadPK)) {
            return false;
        }
        ConsumoActividadPK other = (ConsumoActividadPK) object;
        if ((this.codVisita == null && other.codVisita != null) || (this.codVisita != null && !this.codVisita.equals(other.codVisita))) {
            return false;
        }
        if ((this.codActividad == null && other.codActividad != null) || (this.codActividad != null && !this.codActividad.equals(other.codActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.centrocostero.model.ConsumoActividadPK[ codVisita=" + codVisita + ", codActividad=" + codActividad + " ]";
    }
    
}
