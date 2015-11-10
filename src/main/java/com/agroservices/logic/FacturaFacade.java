/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.logic;

import com.agroservices.model.Ubicacion;
import com.agroservices.persistence.FacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres
 */
@Service
public class FacturaFacade {
    
    @Autowired
    FacturasRepository fr;
    
    public Ubicacion getUbicacionPorFactura(int idFactura){
        return fr.getUbicacionMinoristaPorFactura(idFactura);
    }
    
    
}
