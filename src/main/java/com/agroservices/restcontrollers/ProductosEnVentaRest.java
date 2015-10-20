/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.restcontrollers;

import com.agroservices.logic.ProductosEnVentaFacade;
import com.agroservices.logic.ProductosFacade;
import com.agroservices.model.Campesino;
import com.agroservices.model.Producto;
import com.agroservices.model.ProductoEnVenta;
import com.agroservices.model.Ubicacion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres
 */
@RestController
@RequestMapping("/productosEnVenta")
public class ProductosEnVentaRest {
    
    @Autowired
    ProductosEnVentaFacade pef;
    
    @Autowired
    ProductosFacade pf;
    
    //Se determina que la id estara compuesta asi: "#-%" donde #= producro y &=cantidad
    /**
     * Metodo encargado de retornar los productos en venta que serán mostrados al minorista, según los parametros espeficados por el mismo
     * @param id cadena que contiene los datos del producto que se busca y la cantidad de ese producto
     * @return productos 
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public List<ProductoEnVenta> getConsultaProductosEVProductoCantidad(@PathVariable String id){
        
//        String elementoDivisor = "-";
//        String[] valores = id.split(elementoDivisor);//  0: producto 1:cantidad
//        
//        Producto p = pf.getProducto(Integer.parseInt(valores[0]));
//        List<ProductoEnVenta> productos = pef.getProductosEnVentaConsulta(p.getIdProductos(), Integer.parseInt(valores[1]));

        List<ProductoEnVenta> productos = new ArrayList<>(0);
        Ubicacion u = new Ubicacion("a", "a", "a", "a", "a");
        Campesino c = new Campesino(1, u, "Andres", "Melo", "018000");
        Producto p = new Producto("Papita", 12, true);
        Date fecha = new Date(114, 2, 12);
        ProductoEnVenta pe1 = new ProductoEnVenta(c, p, "La mejor papa", fecha, 60, 1000);
        ProductoEnVenta pe2 = new ProductoEnVenta(c, p, "La mejor papa2", fecha, 60, 1000);
        ProductoEnVenta pe3 = new ProductoEnVenta(c, p, "La mejor papa3", fecha, 60, 1000);
        
        pe1.setIdProductosEnVenta(1);
        pe2.setIdProductosEnVenta(2);
        pe3.setIdProductosEnVenta(3);
        
        productos.add(pe1);
        productos.add(pe2);
        productos.add(pe3);
       
        return productos;
        
    }
    
    
}
