/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.logic;

import com.agroservices.model.Minorista;
import com.agroservices.persistence.MinoristasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres Melo
 */

@Service
public class MinoristasFacade {
    
    @Autowired
    MinoristasRepository mr;
    
    /**
     * Método encargado de retornar el minorsta correspindiente a la id suministrada
     * @param idMinorista identificador del minorista a ser consultado
     * @return 
     */
    public Minorista getMinoristaById (int idMinorista){
        
        return mr.findOne(idMinorista);
        
    }
    
    
    public String getNombreApellidoMinorista(int idMinorista){
        
        return mr.getNombreMinorista(idMinorista) +" "+ mr.getApellidoMinorista(idMinorista);
        
    }
    
}
