/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.logic;


import com.agroservices.model.Venta;
import com.agroservices.persistence.VentasRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres Barrero
 */
@Service
public class VentasFacade {
    
    @Autowired
    VentasRepository vr;
    
    @Transactional
    public void guardarVenta(Venta v){
        vr.save(v);
    }
    
    public Venta consultarVenta(int id){
        return vr.findOne(id);
    }
    
    public List<Venta> ventasTotales(){
        return vr.getVentasTotales();
    }
    
}
