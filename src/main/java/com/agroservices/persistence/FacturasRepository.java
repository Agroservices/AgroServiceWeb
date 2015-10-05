/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.persistence;

import com.agroservices.model.Factura;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres Barrero
 */
public interface FacturasRepository extends CrudRepository<Factura, Integer>{
    
}
