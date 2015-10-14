/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.logic;

import com.agroservices.model.Producto;
import com.agroservices.model.ProductoEnVenta;
import com.agroservices.persistence.ProductosEnVentaRepository;
import com.agroservices.persistence.ProductosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres Melo
 */

@Service
public class ComprasFacade {
    
    @Autowired 
    ProductosEnVentaRepository per;
    
    @Autowired
    ProductosRepository pr;
    
    /**
     * Método encargado de retornar el producto que concuerde con el nombre ingresado
     * @param nombre nombre del producto que se desea obtener
     * @return 
     */
    
    public Producto getProducto(String nombre){
        
        return pr.getProductoPorNombre(nombre).get(0);
        
    }
    
    
    public List<ProductoEnVenta> getProductosEnVentaConsulta(int idProducto, int cantidad){
        
        return per.productosEnVentaPorCantidadProducto(idProducto, cantidad);
        
    }
    
    
}