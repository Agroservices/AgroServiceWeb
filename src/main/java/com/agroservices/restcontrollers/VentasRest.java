/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.restcontrollers;

import com.agroservices.logic.DespachosFacade;
import com.agroservices.logic.FacturaFacade;
import com.agroservices.logic.VentasFacade;
import com.agroservices.model.Campesino;
import com.agroservices.model.Despacho;
import com.agroservices.model.Producto;
import com.agroservices.model.ProductoEnVenta;
import com.agroservices.model.Ubicacion;
import com.agroservices.model.Venta;
import java.util.Date;
import java.util.List;
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
 * @author Andres Barrero
 */
@RestController
@RequestMapping("/ventas")
public class VentasRest {
    
    @Autowired
    VentasFacade vf;
    
    @Autowired
    FacturaFacade ff;
     
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> notificarVenta(@RequestBody Venta v){
        try{
            vf.guardarVenta(v);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Venta> consultarTodasVentas()throws OperationFailedException{
        return vf.ventasTotales();
        //return vf.ventasTotalesDummy();
    }
    
    @RequestMapping(value="/check",method = RequestMethod.GET)        
    public String check() {
        return "REST API VENTAS OK";        
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public List<Venta> ventasCampesino(@PathVariable int id)throws OperationFailedException{
        return vf.ventasDeCampesino(id);
    }
    
    @RequestMapping(value = "/abc",method = RequestMethod.GET)
    public Venta consultarVenta()throws OperationFailedException{
        Producto p = new Producto("papa", 5, true);
        Ubicacion u = new Ubicacion("direccion", "Cajica", "Cdnm", "70", "80");
        Campesino c = new Campesino(1, u, "Guillermo","Alvarez ", "123456");
        ProductoEnVenta pev = new ProductoEnVenta(c, p, "Papa muyyyy rica", new Date(), (float)52, (float)20);
        Venta v = new Venta(c, pev);
        /*Venta v = vf.consultarVenta(id);
        if(v==null)
            throw new OperationFailedException();*/
        return v;
    }
    
    @RequestMapping(value = "/factura/{idFactura}/ubicacion", method = RequestMethod.GET)
    public Ubicacion getUbicacionMinoristaPorFactura(@PathVariable int idFactura){
        return ff.getUbicacionPorFactura(idFactura);
    }
    
}
