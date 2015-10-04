/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.persistence;

import com.agroservices.model.Campesino;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface CampesinosRepository extends CrudRepository<Campesino, Integer>{
    
}
