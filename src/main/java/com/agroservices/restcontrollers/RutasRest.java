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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @RequestMapping(value = "/asignar/{id}",method = RequestMethod.GET)
    public String asignarRuta(@PathVariable int id)throws OperationFailedException{
        String resultado=rf.asignarRuta(id);
        return resultado;
    }
    
    @RequestMapping(value = "/transportista/{id}",method = RequestMethod.GET)
    public List<Ruta> rutasPorTransportista(@PathVariable int id)throws OperationFailedException{
        return rf.rutasPorTransportista(id);
    }
    
    @RequestMapping(value = "/rechazar/{id}",method = RequestMethod.GET)
    public String rechazarRuta(@PathVariable int id)throws OperationFailedException{
        String resultado=rf.rechazarRuta(id);
        return resultado;
    }
    
    @RequestMapping(value = "/random",method = RequestMethod.GET)
    public int probarRandom()throws OperationFailedException{
        return rf.pruebaRandom();
    }
}
