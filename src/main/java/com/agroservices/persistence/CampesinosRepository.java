/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.persistence;

import com.agroservices.model.Campesino;
import com.agroservices.model.Ubicacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author User
 */
public interface CampesinosRepository extends CrudRepository<Campesino, Integer>{
    
    @Query("Select c.ubicaciones from Campesino c inner join c.productosEnVentas p where p.idProductosEnVenta = :idProducto")
    public Ubicacion getUbicacionCampesinoPorProductoEnVenta(@Param("idProducto")Integer idProducto);
    
}
