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
    
    public List<ProductoEnVenta> getProductosEnVentaPorCampesino(Campesino c){
        return null;
    }
    
    public void setProductoEnVentaParaCampesino(Campesino campesino, ProductoEnVenta prodVenta){
        
    }
    
    public void saveProductoEnVenta(ProductoEnVenta pev){
        pr.save(pev);
    }
    
}
