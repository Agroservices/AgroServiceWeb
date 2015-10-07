/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.logic;

import com.agroservices.model.Producto;
import com.agroservices.persistence.ProductosRepository;
import com.agroservices.restcontrollers.OperationFailedException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class ProductosFacade {
    
    @Autowired
    ProductosRepository pr;
        
    public List<Producto> getProductos(){        
        List<Producto> productos = new ArrayList<>();
        Iterable<Producto> iterable = pr.findAll();
        for(Producto p: iterable){
            productos.add(p);
        }
        return productos;
    }
    
    
    public void saveProducto(Producto producto)throws OperationFailedException{
        List<Producto> productosPorNombre = pr.validacionProductoPorNombre(producto.getNombre());
        if(!productosPorNombre.isEmpty())throw new OperationFailedException();        
        pr.save(producto);        
    }
            
    
}
