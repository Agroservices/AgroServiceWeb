/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.logic;

import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres Melo
 */

@Service
public class entidadBancariaFacade {
    
    public boolean validarTarjeta(informacionTarjeta tarjeta){
        
        Date fecha = new Date();
        boolean resultado = true;
        
        if(tarjeta.getNumero()%2!=0){
            resultado = false;
        }
        
        if(tarjeta.getAñoVencimiento()>=(fecha.getYear()+1900)){
            resultado = false;
        }
        
        if(tarjeta.getMesVencimiento()>=(fecha.getMonth()+1)){
            resultado = false;
        }
        
        return resultado;
    }
    
}
