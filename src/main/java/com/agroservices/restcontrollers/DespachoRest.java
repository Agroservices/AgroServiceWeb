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
    
    @RequestMapping(value = "/rutas/{id}",method = RequestMethod.GET)
    public List<Despacho> DespachoByRuta(@PathVariable int id)throws OperationFailedException{
        return df.getDespachosByRuta(id);
    }
    
    @RequestMapping(value = "/{id}/seEntrego",method = RequestMethod.POST)
    public ResponseEntity<?>modificarEstadoEntrega(@PathVariable int id,@RequestBody Despacho des){                    
            boolean ans = df.setEstadoEntrega(id, des.isSeEntrego());
            if(ans){
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    
    @RequestMapping(value = "/{id}/seRecogio",method = RequestMethod.POST)
    public ResponseEntity<?>modificarEstadoRecogida(@PathVariable int id, @RequestBody Despacho des){            
            boolean ans = df.setEstadoRecogida(id, des.isSeRecogio());
            if(ans){
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }    
    
    /**
     * Método encargado de confirmar que el producto comprado por el minorista le fue entregado
     * @param id
     * @return
     * @throws OperationFailedException 
     */
    
    @RequestMapping(value = "/confirmat/{id}",method = RequestMethod.POST)
    public ResponseEntity<?> confirmarDetalleDespacho(@PathVariable int id)throws OperationFailedException{
        
        if(df.setDetalleDespacho(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        
    }
    
    /*@RequestMapping(value = "/poblar",method = RequestMethod.GET)
    public String poblar()throws OperationFailedException{
        df.poblar();
        return "POBLAR DESPACHOS OK";
    }*/
}
