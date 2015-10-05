/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.persistence;

import com.agroservices.model.DetalleFactura;
import com.agroservices.model.DetalleFacturaId;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres Barrero
 */
public interface DetallesFacturasRepository extends CrudRepository<DetalleFactura, DetalleFacturaId>{
    
}
