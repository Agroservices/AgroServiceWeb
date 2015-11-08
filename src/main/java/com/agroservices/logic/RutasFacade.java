/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.logic;

import com.agroservices.model.Ruta;
import com.agroservices.model.Transportista;
import com.agroservices.persistence.RutasRepository;
import com.agroservices.persistence.TransportistasRepository;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres Barrero
 */
@Service
public class RutasFacade {
    
    @Autowired
    RutasRepository rr;
    
    @Autowired
    TransportistasRepository tr;
    
    private static final List<Ruta> dummyRoutesData=new LinkedList<>();
    
    static{
        Transportista t1 = new Transportista(123456789, "Brian", "O'Conner", "7894561");
        Transportista t2 = new Transportista(741852963, "Dominic", "Toretto", "7418529");
        Transportista t3 = new Transportista(963852741, "Dwane", "Jhonson", "9638527");
        Ruta r1 = new Ruta(t1, new Date(2015-1900, 8, 10), new Date(2015-1900,8,10));
        Ruta r2 = new Ruta(t1, new Date(2015-1900, 8, 10), new Date(2015-1900,8,11));
        Ruta r3 = new Ruta(t2, new Date(2015-1900, 8, 12), new Date(2015-1900,8,12));
        Ruta r4 = new Ruta(t2, new Date(2015-1900, 8, 15), new Date(2015-1900,8,16));
        Ruta r5 = new Ruta(t2, new Date(2015-1900, 8, 10), new Date(2015-1900,8,11));
        Ruta r6 = new Ruta(t2, new Date(2015-1900, 8, 20), new Date(2015-1900,8,20));
        Ruta r7 = new Ruta(t3, new Date(2015-1900, 8, 12), new Date(2015-1900,8,12));
        Ruta r8 = new Ruta(t3, new Date(2015-1900, 8, 12), new Date(2015-1900,8,12));
        Ruta r9 = new Ruta(t3, new Date(2015-1900, 8, 15), new Date(2015-1900,8,16));
        dummyRoutesData.add(r1);
        dummyRoutesData.add(r2);
        dummyRoutesData.add(r3);
        dummyRoutesData.add(r4);
        dummyRoutesData.add(r5);
        dummyRoutesData.add(r6);
        dummyRoutesData.add(r7);
        dummyRoutesData.add(r8);
        dummyRoutesData.add(r9);
    }
    
    public List<Ruta> todasRutasDummy(){
        return dummyRoutesData;
    }
    
    public String asignarRuta(int idRuta){
        Ruta r = rr.findOne(idRuta);
        r.setAprobacion(true);
        rr.save(r);
        return "OK";
    }
    
    /*public void poblar(){
        Transportista t1 = tr.findOne(123456789);
        Transportista t2 = tr.findOne(741852963);
        Transportista t3 = tr.findOne(963852741);
        Ruta r1 = new Ruta(t1, new Date(2015-1900, 8, 10), new Date(2015-1900,8,10));
        Ruta r2 = new Ruta(t1, new Date(2015-1900, 8, 10), new Date(2015-1900,8,11));
        Ruta r3 = new Ruta(t2, new Date(2015-1900, 8, 12), new Date(2015-1900,8,12));
        Ruta r4 = new Ruta(t2, new Date(2015-1900, 8, 15), new Date(2015-1900,8,16));
        Ruta r5 = new Ruta(t2, new Date(2015-1900, 8, 10), new Date(2015-1900,8,11));
        Ruta r6 = new Ruta(t2, new Date(2015-1900, 8, 20), new Date(2015-1900,8,20));
        Ruta r7 = new Ruta(t3, new Date(2015-1900, 8, 12), new Date(2015-1900,8,12));
        Ruta r8 = new Ruta(t3, new Date(2015-1900, 8, 12), new Date(2015-1900,8,12));
        Ruta r9 = new Ruta(t3, new Date(2015-1900, 8, 15), new Date(2015-1900,8,16));
        r1.setAprobacion(false);
        r2.setAprobacion(false);
        r3.setAprobacion(false);
        r4.setAprobacion(false);
        r5.setAprobacion(false);
        r6.setAprobacion(false);
        r7.setAprobacion(false);
        r8.setAprobacion(false);
        r9.setAprobacion(false);
        rr.save(r1);
        rr.save(r2);
        rr.save(r3);
        rr.save(r4);
        rr.save(r5);
        rr.save(r6);
        rr.save(r7);
        rr.save(r8);
        rr.save(r9);
    }*/
    
}
