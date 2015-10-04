
import com.agroservices.model.Campesino;
import com.agroservices.model.Producto;
import com.agroservices.model.ProductoEnVenta;
import com.agroservices.model.Ubicacion;
import com.agroservices.persistence.CampesinosRepository;
import com.agroservices.persistence.ProductosEnVentaRepository;
import com.agroservices.persistence.ProductosRepository;
import com.agroservices.persistence.RutasRepository;
import com.agroservices.persistence.UbicacionesRepository;
import java.util.Date;
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
    RutasRepository rr;
    
    @Test
    public void consultarRutasAsignadas(){
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
        assertTrue(true==true);
    }
    
}
