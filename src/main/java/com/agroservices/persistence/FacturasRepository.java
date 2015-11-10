/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.persistence;

import com.agroservices.model.Factura;
import com.agroservices.model.Ubicacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Andres Barrero
 */
public interface FacturasRepository extends CrudRepository<Factura, Integer>{
    
    @Query("Select f.ubicaciones from Factura f where f.idFacturas = :idFactura")
    public Ubicacion getUbicacionMinoristaPorFactura(@Param("idFactura")Integer idFactura);
    
}
