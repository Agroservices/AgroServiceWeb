/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.persistence;

import com.agroservices.model.Venta;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres Barrero
 */
public interface VentasRepository extends CrudRepository<Venta, Integer>{
    
    @Query("FROM Venta v")
    public List<Venta> getVentasTotales();
    
}
