/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.logic;

import com.agroservices.model.DetalleFactura;
import com.agroservices.model.DetalleFacturaId;
import com.agroservices.model.Factura;
import com.agroservices.model.Minorista;
import com.agroservices.model.Producto;
import com.agroservices.model.ProductoEnVenta;
import com.agroservices.model.TransaccionBancaria;
import com.agroservices.model.Ubicacion;
import com.agroservices.model.Venta;
import com.agroservices.persistence.DetallesFacturasRepository;
import com.agroservices.persistence.FacturasRepository;
import com.agroservices.persistence.MinoristasRepository;
import com.agroservices.persistence.ProductosEnVentaRepository;
import com.agroservices.persistence.ProductosRepository;
import com.agroservices.persistence.TransaccionesBancariasRepository;
import com.agroservices.persistence.VentasRepository;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    
    @Autowired
    FacturasRepository fr;
    
    @Autowired
    MinoristasRepository mr;
    
    @Autowired
    TransaccionesBancariasRepository tbr;
    
    @Autowired
    DetallesFacturasRepository dfr;
    
    @Autowired
    VentasRepository vr;
    
    
    public boolean agregarFactura(Factura factura, int idMinorista, int idProductoEnVenta, float cantidadComprada){
        
        try {
        
        // Datos para la factura
        Minorista minorista = mr.findOne(idMinorista);
        ProductoEnVenta producto = per.findOne(idProductoEnVenta);
        
        Date fecha = new Date();
        Ubicacion ubicacion = minorista.getUbicacioneses().iterator().next();
        
        factura.setUbicaciones(ubicacion);
        factura.setFecha(fecha);
        factura.getTransaccionesBancarias().setDineroConsignado(fecha);
        
        tbr.save(factura.getTransaccionesBancarias());
        
        fr.save(factura);
        
        // Creacion detalles
        
        DetalleFacturaId detalleId = new DetalleFacturaId(producto.getIdProductosEnVenta(), factura.getIdFacturas());
        DetalleFactura detalleFactura = new DetalleFactura(detalleId, factura, producto, producto.getPrecioPorKg(), cantidadComprada, false);
        
        dfr.save(detalleFactura);
        
        Factura facturaActualizada = fr.findOne(factura.getIdFacturas());
        
        Set <DetalleFactura> detalleFacturasNuevo = new HashSet<DetalleFactura>(0);
        
        detalleFacturasNuevo.add(detalleFactura);
        
        //facturaActualizada.getDetalleFacturas().add(detalleFactura);
        
        facturaActualizada.setDetalleFacturas(detalleFacturasNuevo);
        
        fr.save(facturaActualizada);
        
        System.out.println("Id Factura: "+factura.getIdFacturas());
          
        //Creacion de la venta
        
        Venta venta = new Venta(producto.getCampesinos(), producto);
        venta.setFechaVenta(fecha);
        
        vr.save(venta);
        
        ProductoEnVenta productoActualizado = per.findOne(producto.getIdProductosEnVenta());
        productoActualizado.setCantidadDisponible(producto.getCantidadDisponible()-cantidadComprada);
        
        per.save(productoActualizado);
        
        return true;
        
        //System.out.println("Id Factura: "+factura.getIdFacturas());
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return false;
        }
        
        
        
        
    }
    
    
    
    
    
    
}
