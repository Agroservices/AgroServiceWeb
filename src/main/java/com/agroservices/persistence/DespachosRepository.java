/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.persistence;

import com.agroservices.model.Despacho;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Andres Barrero
 */
public interface DespachosRepository extends CrudRepository<Despacho, Integer>{
    
    @Query("FROM Despacho d")
    public List<Despacho> getDespachosTotales();
    
    @Query("from Despacho d where d.idDespachos=:idDespacho")
    public Despacho search(@Param("idDespacho") Integer id);
    
    @Query("from Despacho d where d.rutas.transportistas.idTransportistas=:idTransportista")
    public List<Despacho> porTransportista(@Param("idTransportista") Integer id);
    
}
