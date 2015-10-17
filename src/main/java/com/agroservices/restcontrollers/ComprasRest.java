/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.restcontrollers;

import com.agroservices.logic.ComprasFacade;
import com.agroservices.logic.ProductosEnVentaFacade;
import com.agroservices.model.Producto;
import com.agroservices.model.ProductoEnVenta;
import java.util.List;
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
@RequestMapping("/compras")
public class ComprasRest {
    
    @Autowired
    ComprasFacade cf;
    

    
}
