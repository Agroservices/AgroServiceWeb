/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.restcontrollers;

import com.agroservices.logic.MinoristasFacade;
import com.agroservices.model.Minorista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres Melo
 */

@RestController
@RequestMapping("/minoristas")
public class MinoristaRest {
    
    @Autowired
    MinoristasFacade mf;
    
    
    /**
     * Método encargado de retornar el Nombre del minorista correspondiente a la identificación suministrada
     * @param id identificación del minorista a consultar
     * @return 
     */
    @RequestMapping(value = "/nombre/{id}",method = RequestMethod.GET)
    public String getMinorista(@PathVariable int id){
        
        return mf.getNombreApellidoMinorista(id);
        
    }
    
}
