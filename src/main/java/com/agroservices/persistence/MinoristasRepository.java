/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.persistence;

import com.agroservices.model.Minorista;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Andres Barrero
 */
public interface MinoristasRepository extends CrudRepository<Minorista, Integer>{
    
    
    /**
     * Consulta encargada de retornar el nombre del minorista especificado
     * @param idMinorista identificador del minorista a consultar
     * @return 
     */
    @Query("SELECT m.nombres FROM Minorista m WHERE m.idMinoristas = :idMinorista")
    public String getNombreMinorista (@Param("idMinorista") Integer idMinorista);
    
    
    /**
     * Consulta encargada de retornar el apellido del minorista especificado
     * @param idMinorista identificador del minorista a consultar
     * @return 
     */
    @Query("SELECT m.apellidos FROM Minorista m WHERE m.idMinoristas = :idMinorista")
    public String getApellidoMinorista (@Param("idMinorista") Integer idMinorista);
    
}
