
import com.agroservices.logic.PersistenceFacade;
import com.agroservices.model.Campesino;
import com.agroservices.model.Despacho;
import com.agroservices.model.DetalleFactura;
import com.agroservices.model.DetalleFacturaId;
import com.agroservices.model.Factura;
import com.agroservices.model.Minorista;
import com.agroservices.model.Producto;
import com.agroservices.model.ProductoEnVenta;
import com.agroservices.model.Ruta;
import com.agroservices.model.TransaccionBancaria;
import com.agroservices.model.Transportista;
import com.agroservices.model.Ubicacion;
import com.agroservices.persistence.CampesinosRepository;
import com.agroservices.persistence.DespachosRepository;
import com.agroservices.persistence.DetallesFacturasRepository;
import com.agroservices.persistence.FacturasRepository;
import com.agroservices.persistence.MinoristasRepository;
import com.agroservices.persistence.ProductosEnVentaRepository;
import com.agroservices.persistence.ProductosRepository;
import com.agroservices.persistence.RutasRepository;
import com.agroservices.persistence.TransaccionesBancariasRepository;
import com.agroservices.persistence.TransportistasRepository;
import com.agroservices.persistence.UbicacionesRepository;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andres Barrero
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContextH2.xml"})
public class PersistenceTestSpring {
    
    @Autowired
    ProductosRepository pr;
    
    @Autowired
    UbicacionesRepository ur;
    
    @Autowired
    CampesinosRepository cr;
    
    @Autowired
    ProductosEnVentaRepository per;
    
    @Autowired
    TransaccionesBancariasRepository tbr;
    
    @Autowired
    MinoristasRepository mr;
    
    @Autowired
    FacturasRepository fr;
    
    @Autowired
    DetallesFacturasRepository dfr;
    
    @Autowired
    TransportistasRepository tr;
    
    @Autowired
    RutasRepository rr;
    
    @Autowired
    DespachosRepository dr;
    
    @Test
    public void simulacionCompra(){
        /*******************************************************************
        CREACION DE LOS PRODUCTOS
        ********************************************************************/
        Producto p1 = new Producto("Lechuga", 36, true);
        Producto p2 = new Producto("Tomate", 30, false);
        Producto p3 = new Producto("Cebolla", 60, false);
        Producto p4 = new Producto("Papa criolla", 15, true);
        pr.save(p1);
        pr.save(p2);
        pr.save(p3);
        pr.save(p4);
        /*******************************************************************
        CREACION DE LAS UBICACIONES
        ********************************************************************/
        Ubicacion u1 = new Ubicacion("Calle 160 # 36 - 45", "Chia", "Cundinamarca", "50", "50");
        Ubicacion u2 = new Ubicacion("Transversal 14 # 25 - 35", "Bogota", "Cundinamarca", "60", "60");
        Ubicacion u3 = new Ubicacion("Calle 26 sur # 8 - 63", "Bogota", "Cundinamarca", "70", "70");
        Ubicacion u4 = new Ubicacion("Carrera 53 # 15 - 43", "Tabio", "Cundinamarca", "80", "80");
        Ubicacion u5 = new Ubicacion("Carrera 13 # 24 - 72", "Sopo", "Cundinamarca", "90", "90");
        Ubicacion u6 = new Ubicacion("Calle 140 # 7 - 8", "Bogota", "Cundinamarca", "100", "100");
        Ubicacion u7 = new Ubicacion("Calle 127 # 15 - 28", "Bogota", "Cundinamarca", "110", "110");
        ur.save(u1);
        ur.save(u2);
        ur.save(u3);
        ur.save(u4);
        ur.save(u5);
        ur.save(u6);
        /*******************************************************************
        CREACION DE LOS CAMPESINOS
        ********************************************************************/
        Campesino c1 = new Campesino(123456789, u1, "Pedro Nel", "Sanchez Carrasquilla", "4559875");
        Campesino c2 = new Campesino(987654321, u4, "Carlos Albeiro", "Rodriguez Paez", "1597536");
        Campesino c3 = new Campesino(159753846, u5, "Wilson", "Torres Sanabria", "3571568");
        cr.save(c1);
        cr.save(c2);
        cr.save(c3);
        /*******************************************************************
        CREACION DE LOS PRODUCTOS EN VENTA
        ********************************************************************/
        ProductoEnVenta pev1 = new ProductoEnVenta(c1, p1, "Lechuga verde", new Date(2015-1900, 6, 15), (float)(35.8), 3500);
        ProductoEnVenta pev2 = new ProductoEnVenta(c1, p2, "Tomates rojos", new Date(2015-1900, 7, 8), (float)(60.3), 2450);        
        ProductoEnVenta pev3 = new ProductoEnVenta(c2, p3, "Cebolla cabezona", new Date(2015-1900, 8, 23), (float)(100.4), 1800);
        ProductoEnVenta pev4 = new ProductoEnVenta(c3, p4, "Papa amarilla", new Date(2015-1900, 7, 18), (float)(86.5), 4600);
        per.save(pev1);
        per.save(pev2);
        per.save(pev3);
        per.save(pev4);
        /*******************************************************************
        CREACION DE LAS TRANSACCIONES BANCARIAS
        ********************************************************************/
        TransaccionBancaria tb1 = new TransaccionBancaria("A1B2C3D4", new Date(2015-1900, 5, 13));
        TransaccionBancaria tb2 = new TransaccionBancaria("E5F6G7H8", new Date(2015-1900, 3, 8));
        TransaccionBancaria tb3 = new TransaccionBancaria("I9J1K2L3", new Date(2015-1900, 7, 20));
        TransaccionBancaria tb4 = new TransaccionBancaria("M4N5O6P7", new Date(2015-1900, 1, 26));
        TransaccionBancaria tb5 = new TransaccionBancaria("M4N5O6P7", new Date(2015-1900, 1, 26));
        tbr.save(tb1);
        tbr.save(tb2);
        tbr.save(tb3);
        tbr.save(tb4);
        tbr.save(tb5);
        /*******************************************************************
        CREACION DE LOS MINORISTAS
        ********************************************************************/
        Minorista m1 = new Minorista(159753258, "Leonel", "Gomez Camacho", "2587894");
        Minorista m2 = new Minorista(357456685, "Abel", "Alvarado Cruz", "9216849");
        Minorista m3 = new Minorista(354895147, "Pablo", "Estrada Camargo", "6702091");
        m1.getUbicacioneses().add(u2);
        m1.getUbicacioneses().add(u3);
        m2.getUbicacioneses().add(u6);
        m3.getUbicacioneses().add(u7);
        mr.save(m1);
        mr.save(m2);
        mr.save(m3);
        /*******************************************************************
        CREACION DE LAS FACTURAS
        ********************************************************************/
        Factura f1 = new Factura(tb1, ur.findOne(1), new Date(2015-1900, 5, 13), (float)(0.16));
        Factura f2 = new Factura(tb2, ur.findOne(2), new Date(2015-1900, 4, 14), (float)(0.16));
        Factura f3 = new Factura(tb3, ur.findOne(3), new Date(2015-1900, 6, 15), (float)(0.16));
        Factura f4 = new Factura(tb4, ur.findOne(6), new Date(2015-1900, 3, 16), (float)(0.16));
        Factura f5 = new Factura(tb5, ur.findOne(1), new Date(2015-1900, 7, 17), (float)(0.16));
        fr.save(f1);
        fr.save(f2);
        fr.save(f3);
        fr.save(f4);
        fr.save(f5);
        /*******************************************************************
        CREACION DE DETALLES FACTURA ID
        ********************************************************************/
        DetalleFacturaId dti1 = new DetalleFacturaId(1, 1);
        DetalleFacturaId dti2 = new DetalleFacturaId(2, 1);
        DetalleFacturaId dti3 = new DetalleFacturaId(3, 2);
        DetalleFacturaId dti4 = new DetalleFacturaId(4, 3);
        DetalleFacturaId dti5 = new DetalleFacturaId(1, 3);
        DetalleFacturaId dti6 = new DetalleFacturaId(2, 4);
        DetalleFacturaId dti7 = new DetalleFacturaId(1, 4);
        DetalleFacturaId dti8 = new DetalleFacturaId(3, 4);
        DetalleFacturaId dti9 = new DetalleFacturaId(1, 5);
        /*******************************************************************
        CREACION DE DETALLES FACTURA
        ********************************************************************/
        DetalleFactura dt1 = new DetalleFactura(dti1, f1, pev1, (float)(10), (float)(pev1.getPrecioPorKg()*10), false);
        DetalleFactura dt2 = new DetalleFactura(dti2, f1, pev2, (float)(20), (float)(pev2.getPrecioPorKg()*20), false);
        DetalleFactura dt3 = new DetalleFactura(dti3, f2, pev3, (float)(8), (float)(pev3.getPrecioPorKg()*8), false);
        DetalleFactura dt4 = new DetalleFactura(dti4, f3, pev4, (float)(5), (float)(pev4.getPrecioPorKg()*5), false);
        DetalleFactura dt5 = new DetalleFactura(dti5, f3, pev1, (float)(10), (float)(pev1.getPrecioPorKg()*10), false);
        DetalleFactura dt6 = new DetalleFactura(dti6, f4, pev2, (float)(12), (float)(pev2.getPrecioPorKg()*12), false);
        DetalleFactura dt7 = new DetalleFactura(dti7, f4, pev1, (float)(9), (float)(pev1.getPrecioPorKg()*9), false);
        DetalleFactura dt8 = new DetalleFactura(dti8, f4, pev3, (float)(18), (float)(pev1.getPrecioPorKg()*18), false);
        DetalleFactura dt9 = new DetalleFactura(dti9, f5, pev1, (float)(15), (float)(pev1.getPrecioPorKg()*15), false);
        dfr.save(dt1);
        dfr.save(dt2);
        dfr.save(dt3);
        dfr.save(dt4);
        dfr.save(dt5);
        dfr.save(dt6);
        dfr.save(dt7);
        dfr.save(dt8);
        dfr.save(dt9);
        /*******************************************************************
        CREACION DE TRANSPORTISTAS
        ********************************************************************/
        Transportista t1 = new Transportista(123456789, "Brian", "O'Conner", "7894561");
        Transportista t2 = new Transportista(741852963, "Dominic", "Toretto", "7418529");
        Transportista t3 = new Transportista(963852741, "Dwane", "Jhonson", "9638527");
        tr.save(t1);
        tr.save(t2);
        tr.save(t3);
        /*******************************************************************
        CREACION DE RUTAS
        ********************************************************************/
        Ruta r1 = new Ruta(t1, new Date(2015-1900, 8, 10), new Date(2015-1900,8,10));
        Ruta r2 = new Ruta(t1, new Date(2015-1900, 8, 10), new Date(2015-1900,8,11));
        Ruta r3 = new Ruta(t2, new Date(2015-1900, 8, 12), new Date(2015-1900,8,12));
        Ruta r4 = new Ruta(t2, new Date(2015-1900, 8, 15), new Date(2015-1900,8,16));
        Ruta r5 = new Ruta(t2, new Date(2015-1900, 8, 10), new Date(2015-1900,8,11));
        Ruta r6 = new Ruta(t2, new Date(2015-1900, 8, 20), new Date(2015-1900,8,20));
        Ruta r7 = new Ruta(t3, new Date(2015-1900, 8, 12), new Date(2015-1900,8,12));
        Ruta r8 = new Ruta(t3, new Date(2015-1900, 8, 12), new Date(2015-1900,8,12));
        Ruta r9 = new Ruta(t3, new Date(2015-1900, 8, 15), new Date(2015-1900,8,16));
        rr.save(r1);
        rr.save(r2);
        rr.save(r3);
        rr.save(r4);
        rr.save(r5);
        rr.save(r6);
        rr.save(r7);
        rr.save(r8);
        rr.save(r9);
        /*******************************************************************
        CREACION DE DESPACHOS
        ********************************************************************/
        Despacho d1 = new Despacho(dt1, r1, new Date(2015-1900,8,10), new Date(2015-1900,8,10));
        Despacho d2 = new Despacho(dt2, r2, new Date(2015-1900,8,10), new Date(2015-1900,8,11));
        Despacho d3 = new Despacho(dt3, r3, new Date(2015-1900, 8, 12), new Date(2015-1900,8,12));
        Despacho d4 = new Despacho(dt4, r4, new Date(2015-1900, 8, 15), new Date(2015-1900,8,16));
        Despacho d5 = new Despacho(dt5, r5, new Date(2015-1900, 8, 10), new Date(2015-1900,8,11));
        Despacho d6 = new Despacho(dt6, r6, new Date(2015-1900, 8, 20), new Date(2015-1900,8,20));
        Despacho d7 = new Despacho(dt7, r7, new Date(2015-1900, 8, 12), new Date(2015-1900,8,12));
        Despacho d8 = new Despacho(dt8, r8, new Date(2015-1900, 8, 12), new Date(2015-1900,8,12));
        Despacho d9 = new Despacho(dt9, r9, new Date(2015-1900, 8, 15), new Date(2015-1900,8,16));
        dr.save(d1);
        dr.save(d2);
        dr.save(d3);
        dr.save(d4);
        dr.save(d5);
        dr.save(d6);
        dr.save(d7);
        dr.save(d8);
        dr.save(d9);
        
        Date d = new Date(2015-1900,8,12);
        Despacho ddd = dr.search(7);
        List<Integer> rutas = rr.rutasPorTransportista(d, t3.getIdTransportistas());
        List<Integer> productos = pr.productosPorFecha(d, t3.getIdTransportistas());
        
        assertEquals("Cada producto a recoger tiene asociada una ruta", rutas.size(), productos.size());
        assertEquals("Se espera que el numero de rutas asignadas al transportista 3 para la fecha sean dos", rutas.size(), 2);
        assertEquals("Se espera que el numero de productos a recoger por el transportista 3 para la fecha sean dos", productos.size(), 2);
        assertEquals("Se espera que el primer producto a recoger sea lechuga", productos.get(0), "Lechuga");
        assertTrue("Se espera que la primera ruta a recorrer sea la 7", rutas.get(0).equals(7));
        assertEquals("La primera ruta, es decir la 7 debe recoger el primer producto, es decir lechuga", ddd.getDetalleFactura().getProductosEnVenta().getProductos().getNombre(), "Lechuga");
        assertTrue(true==true);
    }
    
    
    
}
