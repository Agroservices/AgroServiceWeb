/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.logic;


import com.agroservices.model.Venta;
import com.agroservices.persistence.VentasRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Andres Barrero
 */
public class VentasFacade {
    
    @Autowired
    VentasRepository vr;
    
    @Transactional
    public void guardarVenta(Venta v)throws Exception{
        //if(cr.exists(c.getIdCampesinos()))throw new Exception("Error en el campesino");
        //if(ur.exists(c.getUbicaciones().getIdUbicaciones()))throw new Exception("Error en la ubicacion");
        vr.save(v);
        //ur.save(c.getUbicaciones());
    }
}
