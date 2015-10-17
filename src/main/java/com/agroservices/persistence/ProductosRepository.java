/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.persistence;

import com.agroservices.model.Producto;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Andres Barrero
 */
public interface ProductosRepository extends CrudRepository<Producto, Integer>{
    
    @Query("SELECT p.productos.nombre FROM ProductoEnVenta p WHERE p.idProductosEnVenta in "
                + "(SELECT d.detalleFactura.productosEnVenta.idProductosEnVenta FROM Despacho d WHERE d.rutas.transportistas.idTransportistas= :transportistaID AND d.rutas.fechaInicio=:fechaID)")
    public List<Integer> productosPorFecha(@Param("fechaID") Date date, @Param("transportistaID") Integer id);
    
    @Query("SELECT p FROM Producto p WHERE p.nombre like :nombre")
    public List<Producto> validacionProductoPorNombre(@Param("nombre")String nombre);
    
    //Consulta encargada de retornar un producto dado su nombre
    @Query("SELECT p FROM Producto p WHERE p.nombre = ':nombreProducto'")
    public List<Producto> getProductoPorNombre(@Param("nombreProducto") String nombreProducto);
    
    
}
