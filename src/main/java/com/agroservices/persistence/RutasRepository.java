/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.persistence;

import com.agroservices.model.Ruta;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Andres Barrero
 */
public interface RutasRepository extends CrudRepository<Ruta, Integer>{
    
    @Query("SELECT r.idRutas FROM Ruta r WHERE r.fechaInicio=:fechaID AND r.transportistas.idTransportistas= :transportistaID")
    public List<Integer> rutasPorTransportista(@Param("fechaID") Date date, @Param("transportistaID") Integer id);
    
    @Query("FROM Ruta r WHERE r.transportistas.idTransportistas= :transportistaID")
    public List<Ruta> rutasTransportista(@Param("transportistaID") Integer id);
}
