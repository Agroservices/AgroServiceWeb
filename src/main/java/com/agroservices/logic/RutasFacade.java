/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.logic;

import com.agroservices.model.Campesino;
import com.agroservices.model.Despacho;
import com.agroservices.model.DetalleFactura;
import com.agroservices.model.DetalleFacturaId;
import com.agroservices.model.Factura;
import com.agroservices.model.Minorista;
import com.agroservices.model.Producto;
import com.agroservices.model.ProductoEnVenta;
import com.agroservices.model.Ruta;
import com.agroservices.model.Transportista;
import com.agroservices.model.Ubicacion;
import com.agroservices.persistence.RutasRepository;
import com.agroservices.persistence.TransportistasRepository;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
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
    
    public List<Ruta> rutasPorTransportista(int idTransportista){
        return rr.rutasTransportista(idTransportista);
    }
    
    public String rechazarRuta(int idRuta){
        Ruta r = rr.findOne(idRuta);
        r = asignarRandom(r,r.getTransportistas().getIdTransportistas());
        rr.save(r);
        return "OK";
    }
    
    public Ruta asignarRandom(Ruta r, int id){
        List<Transportista> transportistas = tr.getTransportistasTotales();
        int aleatorio = 0;
        int nuevoId = id;
        do{
        aleatorio =(int)(Math.random()*(transportistas.size()));
        nuevoId = transportistas.get(aleatorio).getIdTransportistas();
        }while(nuevoId==id);
        r.setTransportistas(transportistas.get(aleatorio));
        return r;
    }
    
    public int pruebaRandom(){
        return (int)(Math.random()*5);
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
    
    public List<Despacho> getMockRutasConDespachos(){
        //Dos Campesinos
        Ubicacion ubCamp1 = new Ubicacion("Calle 3#3E-116", "Cajica", "Cundinamarca", "70", "35");
        Campesino c1 = new Campesino(123456789, ubCamp1, "Pedro", "Franco", "5555777");
        Ubicacion ubCamp2 = new Ubicacion("Calle 1#2_21", "Tabio", "Cundinamarca", "73", "37");
        Campesino c2 = new Campesino(123456, ubCamp2, "Juan", "Perez", "1234567");
        ubCamp1.setIdUbicaciones(1);ubCamp2.setIdUbicaciones(2);
        //Dos productos y tres productos en venta
        Producto p1 = new Producto("Papa criolla", 40, false);
        Producto p2 = new Producto("Maiz", 90, false);
        ProductoEnVenta pv1 = new ProductoEnVenta(c1, p1 , "Papa criolla de Cajica", null, 120, 1000);
        ProductoEnVenta pv2= new ProductoEnVenta(c2, p2, "Maiz de Tabio", null, 200, 1500);
        pv1.setIdProductosEnVenta(1);pv2.setIdProductosEnVenta(2);
        //Dos minoristas compran los productos
        Ubicacion ubMin1 = new Ubicacion("Calle 24#2E-48", "Chia", "Cundinamarca", "68", "35");
        Ubicacion ubMin2 = new Ubicacion("Calle 14#10-35", "Zipaquira", "Cundinamarca", "72", "37");
        ubMin1.setIdUbicaciones(3);ubMin2.setIdUbicaciones(4);
        Factura f1 = new Factura(null, ubMin1, null, 0);        
        Factura f2 = new Factura(null, ubMin2, null, 0);
        Factura f3 = new Factura(null, ubMin2, null, 0);
        f1.setIdFacturas(1);f2.setIdFacturas(2);f3.setIdFacturas(3);
        //Crear los tres detalles facturas
        DetalleFacturaId dfId1 = new DetalleFacturaId(1, 4);
        DetalleFactura df1 = new DetalleFactura(dfId1, null, null, 40, 70000, false);
        DetalleFacturaId dfId2 = new DetalleFacturaId(1, 5);
        DetalleFactura df2 = new DetalleFactura(dfId2, null, null, 60, 80000, false);        
        DetalleFacturaId dfId3 = new DetalleFacturaId(2, 6);
        DetalleFactura df3 = new DetalleFactura(dfId3, null, null, 60, 90000, false);        
        //Crear los Despachos
        Despacho d1 = new Despacho(df1, null, new Date(2015, 11, 13), new Date(2015, 11, 13));        
        Despacho d2 = new Despacho(df2, null, new Date(2015, 11, 13), new Date(2015, 11, 13));
        Despacho d3 = new Despacho(df3, null, new Date(2015, 11, 13), new Date(2015, 11, 13));
        d1.setIdDespachos(9);d2.setIdDespachos(10);d3.setIdDespachos(11);
        //Crear Ruta        
        List<Despacho> despachos = new LinkedList<Despacho>();
        despachos.add(d1);despachos.add(d2);despachos.add(d3);        
        return despachos;
    }
    
}
