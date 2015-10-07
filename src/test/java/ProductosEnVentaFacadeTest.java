/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.agroservices.logic.CampesinosFacade;
import com.agroservices.logic.ProductosEnVentaFacade;
import com.agroservices.logic.ProductosFacade;
import com.agroservices.model.Campesino;
import com.agroservices.model.Producto;
import com.agroservices.model.ProductoEnVenta;
import com.agroservices.model.Ubicacion;
import com.agroservices.restcontrollers.OperationFailedException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ProductosEnVentaFacadeTest {
    
    
    @Autowired
    CampesinosFacade cf;
    
    @Autowired
    ProductosFacade pf;
    
    @Autowired
    ProductosEnVentaFacade pvf;
    
    public ProductosEnVentaFacadeTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void almacenarProductosEnVenta(){
        //Almacenar un campesino con su ubicacion
        Ubicacion u1 = new Ubicacion("Calle 160 # 36 - 45", "Chia", "Cundinamarca", "50", "50");
        Campesino c1 = new Campesino(123456789, u1, "Pedro Nel", "Sanchez Carrasquilla", "4559875");
        cf.guardarCampesino(c1);
        //Almacenar un producto que sera la categoria de los productos en venta a agregar
        Producto p1 = new Producto("Arroz", 36, true);
        try {
            pf.saveProducto(p1);
        } catch (OperationFailedException ex) {
            Logger.getLogger(ProductosEnVentaFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("No se esperaba una exception");
        }
        //Agregar los productos en venta
        ProductoEnVenta pev1 = new ProductoEnVenta(c1, p1, "Arroz de una alta calidad", new Date(2015-1900, 6, 15), (float)(35.8), 3500);        
        ProductoEnVenta pev2 = new ProductoEnVenta(c1, p1, "Arroz de una calidad baja", new Date(2015-1900, 6, 15), (float)(35.8), 2000);
        pvf.saveProductoEnVentaParaCampesino(c1, pev1);        
        pvf.saveProductoEnVentaParaCampesino(c1, pev2);        
        //Corroborar que se almacenaron los productos en venta
        List<ProductoEnVenta> prodVenta = pvf.getProductosEnVentaPorCampesino(c1.getIdCampesinos());
        HashSet<ProductoEnVenta> conjProdVenta = new HashSet<>();
        conjProdVenta.add(pev1);
        conjProdVenta.add(pev2);
        assertTrue("Se esperaba una lista de productos en venta de tamaño diferente ", conjProdVenta.size()==prodVenta.size());
        //Corroborar el contenido persistente de los productos en venta obtenido
        for(ProductoEnVenta pv1:conjProdVenta){
            boolean exist = false;
            for(int i=0;i<prodVenta.size() && !exist;i++){
                ProductoEnVenta pv2 = prodVenta.get(i);
                exist = pv1.getProductos().getIdProductos()==pv2.getProductos().getIdProductos() && 
                        pv1.getCampesinos().getIdCampesinos()==pv2.getCampesinos().getIdCampesinos() && pv1.getIdProductosEnVenta()==pv2.getIdProductosEnVenta()
                        && pv1.getPrecioPorKg()==pv2.getPrecioPorKg() && pv1.getCantidadDisponible()==pv2.getCantidadDisponible();
            }
            assertTrue("No se encontro un producto en venta esperado", exist);
        }                    
    }
}
