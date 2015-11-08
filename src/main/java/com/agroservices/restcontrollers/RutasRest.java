/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.restcontrollers;

import com.agroservices.logic.RutasFacade;
import com.agroservices.model.Ruta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres Barrero
 */
@RestController
@RequestMapping("/rutas")
public class RutasRest {
    
    @Autowired
    RutasFacade rf;
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Ruta> consultarTodasVentas()throws OperationFailedException{
        return rf.todasRutasDummy();
    }
    
    /*@RequestMapping(value = "/poblar",method = RequestMethod.GET)
    public String poblar()throws OperationFailedException{
        rf.poblar();
        return "POBLADO RUTAS OK";
    }*/
}
