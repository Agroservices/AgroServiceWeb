/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.restcontrollers;

import com.agroservices.logic.ComprasFacade;
import com.agroservices.logic.ProductosEnVentaFacade;
import com.agroservices.logic.entidadBancariaFacade;
import com.agroservices.logic.informacionTarjeta;
import com.agroservices.model.Campesino;
import com.agroservices.model.DetalleFactura;
import com.agroservices.model.DetalleFacturaId;
import com.agroservices.model.Factura;
import com.agroservices.model.Producto;
import com.agroservices.model.ProductoEnVenta;
import com.agroservices.model.TransaccionBancaria;
import com.agroservices.model.Ubicacion;
import com.mysql.fabric.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres Melo
 */

@RestController
@RequestMapping("/compras")
public class ComprasRest {
    
    @Autowired
    ComprasFacade cf;
    
    @Autowired
    entidadBancariaFacade ef;
    
    /**
     * Método encargado de definir si la información correspindiente a la tarjeta es valida
     * @param elemento la informacion de la tarjeta que debe ser aprobada 
     * @return tranBancaria objeto que representa la transccion bancaria correspondiente a la compra
     */
    
    @RequestMapping(value = "/tarjetaValidacion/",method = RequestMethod.POST)
    public ResponseEntity<?> validarTarjeta(@RequestBody informacionTarjeta elemento){
        
        
        System.out.println("Elemento tarjtea:"+elemento.getNumero());
        
        if(ef.validarTarjeta(elemento)){
            
            TransaccionBancaria tranBacaria = new TransaccionBancaria("TBOK"+String.valueOf(elemento.getNumero()*2), null);
            
            return new ResponseEntity<>(tranBacaria,HttpStatus.OK);
            
        }else{
           return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        
    }
    
    
    @RequestMapping(value = "/transaccion/{codigo}",method = RequestMethod.GET)
    public TransaccionBancaria getTransaccionCodigo(@PathVariable String codigo){
        return new TransaccionBancaria(codigo, null);
    }
    
    
    @RequestMapping(value = "/{idMinorista}/{idProductoEnVenta}/{cantidadComprada}",method = RequestMethod.POST)
    public ResponseEntity<?> agregarCompra(@PathVariable int idMinorista, @PathVariable int idProductoEnVenta, @PathVariable float cantidadComprada ,@RequestBody Factura factura){
        
        boolean resultado = cf.agregarFactura(factura, idMinorista, idProductoEnVenta, cantidadComprada);
        
        if(resultado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        
    }
    
    // Métodos de ejemplo
    @RequestMapping(value = "/tarjetaValidacion/",method = RequestMethod.GET)
    public informacionTarjeta getTarjeta(){
        return new  informacionTarjeta(12345, 123, 1, 2016);
    }
    
    @RequestMapping(value = "/compraEjemplo/",method = RequestMethod.GET)
    public Factura getFactura(){
        
        Date fechaOcurrencia = new Date();
        TransaccionBancaria transaccion = new TransaccionBancaria("aprob1234", fechaOcurrencia);
        Ubicacion ubicacion = new Ubicacion("Calle 1", "Bogota", "Cundinamarca", "23", "45");
        
        Factura factura = new Factura(transaccion, ubicacion, fechaOcurrencia,120);
        factura.setIdFacturas(10);
        
        Set<ProductoEnVenta> setCampesino = new HashSet<ProductoEnVenta>();
        Campesino campesino = new Campesino(12, ubicacion, "Andres", "Melo", "123456");
        
        Set<ProductoEnVenta> setProducto = new HashSet<ProductoEnVenta>();
        Producto producto = new Producto(1, "Cebolla", 12, true,setProducto);
                
        ProductoEnVenta productoVenta =  new ProductoEnVenta(campesino, producto, "Cebolla azul", fechaOcurrencia, 100, 1200);
        productoVenta.setIdProductosEnVenta(10);
        
        producto.getProductosEnVentas().add(productoVenta);
        campesino.getProductosEnVentas().add(productoVenta);
        
        DetalleFacturaId detalleID = new DetalleFacturaId(productoVenta.getIdProductosEnVenta(), factura.getIdFacturas());
        DetalleFactura detalle =  new DetalleFactura(detalleID, factura, productoVenta, 10, 1200, true);
        
        Set<DetalleFactura> detFactura = new HashSet<DetalleFactura>();
        factura.setDetalleFacturas(detFactura);
        
        factura = new Factura(null, 100);
        
        return factura;
        
    }
    

    
}
