/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.logic;

import com.agroservices.model.Campesino;
import com.agroservices.model.Producto;
import com.agroservices.model.ProductoEnVenta;
import com.agroservices.persistence.CampesinosRepository;
import com.agroservices.persistence.UbicacionesRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class CampesinosFacade {
    
    
    @Autowired
    CampesinosRepository cr;
    
    @Autowired
    UbicacionesRepository ur;
    
    @Autowired
    ProductosEnVentaFacade pvf;
    
    @Autowired
    ProductosFacade pf;
    
    /**
     * Vuelve persistente un campesino en la base de datos     
     * @param c Campesino que se desea volver persistente          
     * Se vuelve persistente el campesino en la base de datos si no existe previamente
     */     
    @Transactional
    public void guardarCampesino(Campesino c){
        //if(cr.exists(c.getIdCampesinos()))throw new Exception("Error en el campesino");
        //if(ur.exists(c.getUbicaciones().getIdUbicaciones()))throw new Exception("Error en la ubicacion");
        cr.save(c);
        //ur.save(c.getUbicaciones());
    }
    
    /**
     * Almacena un producto en venta en un campesino en especial
     */
    public void guardarProductoEnVentaParaCampesino(int idCampesino, ProductoEnVenta prodVenta){
        Campesino c = cr.findOne(idCampesino);
        //Producto p = pf.getProducto(prodVenta.getProductos().getIdProductos());
        //prodVenta.setProductos(p);
        prodVenta.setCampesinos(c);
        pvf.saveProductoEnVentaParaCampesino(c, prodVenta);        
    }
    
    
    public Campesino getCampesinoPorId(int idCampesino){
        return cr.findOne(idCampesino);
    }
    
    public List<ProductoEnVenta> getProductosEnVenta(int idCampesino){
        return pvf.getProductosEnVentaPorCampesino(idCampesino);
    }
    
}
