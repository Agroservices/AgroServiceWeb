/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.agroservices.logic.ProductosFacade;
import com.agroservices.model.Producto;
import com.agroservices.restcontrollers.OperationFailedException;
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
    
    public ProductosFacadeTest() {
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void almacenarProductos(){
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
            assertTrue("Se esperaba un grupo de tamaño diferente de objetos persistentes", listaProd.size()==prodAlmacenados.size());
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
    public void probarArrojarLaOperationFailedEXception(){
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
    
}
