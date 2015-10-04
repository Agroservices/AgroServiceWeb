/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.restcontrollers;

import com.agroservices.logic.CampesinosFacade;
import com.agroservices.model.Campesino;
import com.agroservices.model.Ubicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/campesinos")
public class CampesinoRest {
    
    @Autowired
    CampesinosFacade cf;
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Campesino consultarCliente()throws OperationFailedException{
        Ubicacion u = new Ubicacion("direccion", "Cajica", "Cdnm", "70", "80");
        Campesino c = new Campesino(1, u, "Guillermo","Alvarez ", "123456");        
        return c;
    }    
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> persist(@RequestBody Campesino c){
        try{
            cf.guardarCampesino(c);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
