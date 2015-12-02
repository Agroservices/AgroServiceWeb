/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.logic;

import com.agroservices.model.Campesino;
import com.agroservices.model.Producto;
import com.agroservices.model.ProductoEnVenta;
import com.agroservices.persistence.ProductosEnVentaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class ProductosEnVentaFacade {
    
    @Autowired
    ProductosEnVentaRepository pr;
    
    public List<ProductoEnVenta> getProductosEnVentaPorCampesino(int idCampesino){
        return pr.productosEnVentePorCampesino(idCampesino);
    }
    
    public void saveProductoEnVentaParaCampesino(Campesino campesino, ProductoEnVenta prodVenta){
        prodVenta.setCampesinos(campesino);
        pr.save(prodVenta);
    }
    
    public void saveProductoEnVenta(ProductoEnVenta pev){
        pr.save(pev);
    }
    
    public String consultarNombreDeProducto(int idProducto){
        return pr.findOne(idProducto).getProductos().getNombre();
    }
    
    public List<ProductoEnVenta> getProductosEnVentaConsulta(int idProducto, float cantidad){
        
        return pr.productosEnVentaPorCantidadProducto(idProducto, cantidad);                
        
    }
    
    public List<ProductoEnVenta> getProductos(){
        
        List<ProductoEnVenta> productosEnVenta = new ArrayList<>();
        Iterable<ProductoEnVenta> iter = pr.findAll();
        
        for(ProductoEnVenta p: iter){
            productosEnVenta.add(p);
        }
        
        //return productosEnVenta;
        return pr.getProductosEnVenta();
        
    }
    
    /**
     * Método encargado de modificar el precio por kg del producto en venta especificado
     * @param productoModificado
     * @return 
     */
    
    public boolean modificarProductoEnVenta(ProductoEnVenta productoModificado){
        
        try{
            ProductoEnVenta producto = pr.findOne(productoModificado.getIdProductosEnVenta());
            ProductoEnVenta productoActualizado = pr.findOne(producto.getIdProductosEnVenta());
        
            productoActualizado.setPrecioPorKg(productoModificado.getPrecioPorKg());
        
            pr.save(productoActualizado);
            
            return true;
        }catch(Exception ex){
            return false;
        }
        
    }
}
