/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.restcontrollers;

import com.agroservices.logic.VentasFacade;
import com.agroservices.model.Campesino;
import com.agroservices.model.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
}
