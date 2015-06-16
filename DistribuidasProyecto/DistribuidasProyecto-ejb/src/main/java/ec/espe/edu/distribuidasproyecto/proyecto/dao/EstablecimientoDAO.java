/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.distribuidasproyecto.proyecto.dao;

import com.persist.common.dao.DefaultGenericDAOImple;
import ec.edu.espe.centrocostero.model.Establecimiento;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Daniel
 */
@LocalBean
@Stateless
public class EstablecimientoDAO extends DefaultGenericDAOImple<Establecimiento, String> {

    public EstablecimientoDAO() {
        super(Establecimiento.class);
    }
}
