/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.agroservices.logic.CampesinosFacade;
import com.agroservices.logic.ProductosEnVentaFacade;
import com.agroservices.logic.ProductosFacade;
import com.agroservices.logic.UbicacionesFacade;
import com.agroservices.logic.VentasFacade;
import com.agroservices.model.Campesino;
import com.agroservices.model.Producto;
import com.agroservices.model.ProductoEnVenta;
import com.agroservices.model.Ubicacion;
import com.agroservices.model.Venta;
import com.agroservices.restcontrollers.OperationFailedException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author User
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContextH2.xml"})
public class ProductosFacadeTest {
    
    @Autowired
    ProductosFacade pf;
    
    @Autowired
    CampesinosFacade cf;
    
    @Autowired
    UbicacionesFacade uf;
    
    @Autowired
    ProductosEnVentaFacade pef;
    
    @Autowired
    VentasFacade vf;
    
    public ProductosFacadeTest() {
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void almacenarProductosTest(){
        try {
            Producto producto1 = new Producto("Papa criolla", 30 , false);
            Producto producto2 = new Producto("Tomate", 10 , true);
            Producto producto3 = new Producto("Zanahoria", 15 , false);
            Producto producto4 = new Producto("Cebolla", 20 , false);
            Producto producto5 = new Producto("Patilla", 5 , true);            
            pf.saveProducto(producto1);
            pf.saveProducto(producto2);
            pf.saveProducto(producto3);
            pf.saveProducto(producto4);
            pf.saveProducto(producto5);
            List<Producto> listaProd = pf.getProductos();
            //            
            HashSet<Producto> prodAlmacenados = new HashSet<>();
            prodAlmacenados.add(producto1);
            prodAlmacenados.add(producto2);
            prodAlmacenados.add(producto3);
            prodAlmacenados.add(producto4);
            prodAlmacenados.add(producto5);
            //assertTrue("Se esperaba un grupo de tamaño diferente de objetos persistentes", listaProd.size()==prodAlmacenados.size());
            //
            for(Producto p1: prodAlmacenados){
                boolean existsProd = false;
                for(int i=0;i<listaProd.size() && !existsProd;i++){
                    Producto p2 = listaProd.get(i);
                    existsProd = p1.getNombre().equals(p2.getNombre()) && p1.getDuracion()==p2.getDuracion()
                            && p1.isRefrigeracion()==p2.isRefrigeracion();
                }                    
                assertTrue("No se encontro un producto que debio estar persistente",existsProd);
            }
        } catch (OperationFailedException ex) {
            Logger.getLogger(ProductosFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void probarArrojarLaOperationFailedEXceptionTest(){
        try {
            Producto p1 = new Producto("Arroz", 90, false);
            Producto p2 = new Producto("Arroz", 30, false);
            pf.saveProducto(p1);
            pf.saveProducto(p2);
            fail("Se esperaba el lanzamiento de una exception por productos con nombres iguales");
        } catch (OperationFailedException ex) {
            assertTrue("Se esperaba una exception", true);
        }
    }
    
    @Test
    public void registrarVentaTest(){
        
        try{
        /*******************************************************************
        CREACION DE LOS PRODUCTOS
        ********************************************************************/
        Producto p1 = new Producto("Arroz", 36, true);
        Producto p2 = new Producto("Frijoles", 30, false);
        Producto p3 = new Producto("Arveja", 60, false);
        Producto p4 = new Producto("Papa pastusa", 15, true);
        pf.saveProducto(p1);
        pf.saveProducto(p2);
        pf.saveProducto(p3);
        pf.saveProducto(p4);
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
        uf.saveUbicacion(u1);
        uf.saveUbicacion(u2);
        uf.saveUbicacion(u3);
        uf.saveUbicacion(u4);
        uf.saveUbicacion(u5);
        uf.saveUbicacion(u6);
        /*******************************************************************
        CREACION DE LOS CAMPESINOS
        ********************************************************************/
        Campesino c1 = new Campesino(123456789, u1, "Pedro Nel", "Sanchez Carrasquilla", "4559875");
        Campesino c2 = new Campesino(987654321, u4, "Carlos Albeiro", "Rodriguez Paez", "1597536");
        Campesino c3 = new Campesino(159753846, u5, "Wilson", "Torres Sanabria", "3571568");
        cf.guardarCampesino(c1);
        cf.guardarCampesino(c2);
        cf.guardarCampesino(c3);
        /*******************************************************************
        CREACION DE LOS PRODUCTOS EN VENTA
        ********************************************************************/
        ProductoEnVenta pev1 = new ProductoEnVenta(c1, p1, "Lechuga verde", new Date(2015-1900, 6, 15), (float)(35.8), 3500);
        ProductoEnVenta pev2 = new ProductoEnVenta(c1, p2, "Tomates rojos", new Date(2015-1900, 7, 8), (float)(60.3), 2450);        
        ProductoEnVenta pev3 = new ProductoEnVenta(c2, p3, "Cebolla cabezona", new Date(2015-1900, 8, 23), (float)(100.4), 1800);
        ProductoEnVenta pev4 = new ProductoEnVenta(c3, p4, "Papa amarilla", new Date(2015-1900, 7, 18), (float)(86.5), 4600);
        pef.saveProductoEnVenta(pev1);
        pef.saveProductoEnVenta(pev2);
        pef.saveProductoEnVenta(pev3);
        pef.saveProductoEnVenta(pev4);
        /*******************************************************************
        CREACION DE LAS VENTAS
        ********************************************************************/
        Venta v1 = new Venta(c1, pev1);
        Venta v2 = new Venta(c1, pev2);
        Venta v3 = new Venta(c2, pev3);
        Venta v4 = new Venta(c3, pev4);
        vf.guardarVenta(v1);
        vf.guardarVenta(v2);
        vf.guardarVenta(v3);
        vf.guardarVenta(v4);
        
        List<Venta> ventas = vf.ventasTotales();
        
        assertTrue("Se espera que el numero de ventas registradas sea 4", ventas.size()==4);
        assertTrue("La primera venta se le realizo al campesino Pedro Nel con c.c 123456789",ventas.get(0).getCampesinos().getNombres().equalsIgnoreCase("Pedro Nel") && ventas.get(0).getCampesinos().getIdCampesinos()==123456789);
        assertTrue("La segunda venta fue de frijoles", ventas.get(1).getProductosEnVenta().getProductos().getNombre().equalsIgnoreCase("Frijoles"));
        
        } catch (OperationFailedException ex) {
            Logger.getLogger(ProductosFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
