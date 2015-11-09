/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.persistence;

import com.agroservices.model.Transportista;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres Barrero
 */
public interface TransportistasRepository extends CrudRepository<Transportista, Integer>{
    
    @Query("FROM Transportista t")
    public List<Transportista> getTransportistasTotales();
}
