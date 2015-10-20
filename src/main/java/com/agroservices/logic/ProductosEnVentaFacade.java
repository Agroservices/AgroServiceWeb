/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.logic;

import com.agroservices.model.Campesino;
import com.agroservices.model.ProductoEnVenta;
import com.agroservices.persistence.ProductosEnVentaRepository;
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
    
    
    
    public List<ProductoEnVenta> getProductosEnVentaConsulta(int idProducto, int cantidad){
        
        return pr.productosEnVentaPorCantidadProducto(idProducto, cantidad);
        
    }
}
