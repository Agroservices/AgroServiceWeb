/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.persistence;

import com.agroservices.model.ProductoEnVenta;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Andres Barrero
 */
public interface ProductosEnVentaRepository extends CrudRepository<ProductoEnVenta, Integer>{
    @Query("Select p from ProductoEnVenta p where p.campesinos.idCampesinos = :idCampesino")
    public List<ProductoEnVenta> productosEnVentePorCampesino(@Param("idCampesino") Integer idCampesino);
    
    //Seleccion de los productos en venta segun un producto y la cantidad deseada
    
    @Query("SELECT pev FROM ProductoEnVenta pev WHERE pev.productos.idProductos =:idProd AND pev.cantidadDisponible=:cantidad")
    public List<ProductoEnVenta> productosEnVentaPorCantidadProducto(@Param("idProd")Integer idProducto, @Param("cantidad") Integer cantidad);
    
}
