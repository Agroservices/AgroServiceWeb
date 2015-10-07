/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.logic;

import com.agroservices.model.Ubicacion;
import com.agroservices.persistence.UbicacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres Barrero
 */
@Service
public class UbicacionesFacade {
    
    @Autowired
    UbicacionesRepository ur;
    
    public void saveUbicacion(Ubicacion u){
        ur.save(u);
    }
    
}
