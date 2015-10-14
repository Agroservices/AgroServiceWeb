/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.logic;


import com.agroservices.model.Campesino;
import com.agroservices.model.Producto;
import com.agroservices.model.ProductoEnVenta;
import com.agroservices.model.Ubicacion;
import com.agroservices.model.Venta;
import com.agroservices.persistence.VentasRepository;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres Barrero
 */
@Service
public class VentasFacade {
    
    @Autowired
    VentasRepository vr;
    
    private static final List<Venta> dummySellsData=new LinkedList<>();
    
    static{
        Producto p = new Producto("papa", 5, true);
        Ubicacion u = new Ubicacion("direccion", "Cajica", "Cdnm", "70", "80");
        Campesino c1 = new Campesino(1, u, "Guillermo","Alvarez ", "123456");
        ProductoEnVenta pev1 = new ProductoEnVenta(c1, p, "Papa muyyyy rica", new Date(), (float)52, (float)20);
        Campesino c2 = new Campesino(2, u, "Andres","Melo", "123456");
        Producto p2 = new Producto("Arroz", 5, true);
        ProductoEnVenta pev2 = new ProductoEnVenta(c2, p2, "Papa muyyyy rica", new Date(), (float)52, (float)20);
        Campesino c3 = new Campesino(3, u, "Felipe","Barrero", "123456");
        Producto p3 = new Producto("Lechuga", 5, true);
        ProductoEnVenta pev3 = new ProductoEnVenta(c3, p3, "Papa muyyyy rica", new Date(), (float)52, (float)20);
        dummySellsData.add(new Venta(c1, pev1));
        dummySellsData.add(new Venta(c2, pev2));
        dummySellsData.add(new Venta(c3, pev3));
    }
    
    
    @Transactional
    public void guardarVenta(Venta v){
        vr.save(v);
    }
    
    public Venta consultarVenta(int id){
        return vr.findOne(id);
    }
    
    public List<Venta> ventasTotales(){
        return vr.getVentasTotales();
    }
    
    public List<Venta> ventasTotalesDummy(){
        return dummySellsData;
    }
    
}
