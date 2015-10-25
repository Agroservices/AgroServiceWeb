/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.restcontrollers;

import com.agroservices.logic.ProductosFacade;
import com.agroservices.model.Campesino;
import com.agroservices.model.Producto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
@RequestMapping("/productos")
public class ProductosRest {
    
    @Autowired
    ProductosFacade pf;
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Producto> getProductos(){
        
        /*
        Producto p = new Producto("PapaCriolla", 11, true);
        Producto p1 = new Producto("PapaBlanca", 10, true);
        Producto p2 = new Producto("Tomate",12,false);
        
        List<Producto> productos = new ArrayList<>(0);
        p.setIdProductos(1);
        p1.setIdProductos(2);
        p2.setIdProductos(3);
        productos.add(p);
        productos.add(p1);
        productos.add(p2);
        
        return productos;
        */
        // Cuando la base de datos funcione correctamente
        return pf.getProductos();
        
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> persist(@RequestBody Producto p){
        try{
            pf.saveProducto(p);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }    
    
}
