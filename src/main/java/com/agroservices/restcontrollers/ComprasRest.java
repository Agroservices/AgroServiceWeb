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
import com.agroservices.model.Producto;
import com.agroservices.model.ProductoEnVenta;
import com.mysql.fabric.Response;
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
 * @author Andres Melo
 */

@RestController
@RequestMapping("/compras")
public class ComprasRest {
    
    @Autowired
    ComprasFacade cf;
    
    @Autowired
    entidadBancariaFacade ef;
    
    @RequestMapping(value = "/tarjetaValidacion/",method = RequestMethod.POST)
    public ResponseEntity<?> validarTarjeta(@RequestBody informacionTarjeta elemento){
        
        
        
        if(ef.validarTarjeta(elemento)){
            
            return new ResponseEntity<>(HttpStatus.OK);
            
        }else{
           return new ResponseEntity<>(HttpStatus.OK);
        }
        
    }
    
    @RequestMapping(value = "/tarjeta/",method = RequestMethod.GET)
    public informacionTarjeta getTarjeta(){
        return new  informacionTarjeta(12345, 123, 1, 2016);
    }
    

    
}
