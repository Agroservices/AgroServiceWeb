/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.restcontrollers;

import com.agroservices.logic.DespachosFacade;
import com.agroservices.model.Despacho;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres Barrero
 */
@RestController
@RequestMapping("/despachos")
public class DespachoRest {
    
    @Autowired
    DespachosFacade df;
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Despacho> consultarTodosDespachos()throws OperationFailedException{
        return df.getDespachos();
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Despacho DespachoId(@PathVariable int id)throws OperationFailedException{
        return df.getDespachoId(id);
    }
    
    @RequestMapping(value = "/transportista/{id}",method = RequestMethod.GET)
    public List<Despacho> DespachoByTransportista(@PathVariable int id)throws OperationFailedException{
        return df.getDespachosByTransportista(id);
    }
    
    /*@RequestMapping(value = "/poblar",method = RequestMethod.GET)
    public String poblar()throws OperationFailedException{
        df.poblar();
        return "POBLAR DESPACHOS OK";
    }*/
}
