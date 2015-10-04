/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.persistence;

import com.agroservices.model.Ubicacion;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface UbicacionesRepository  extends CrudRepository<Ubicacion, Integer>{
        
    
}
