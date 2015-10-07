package com.agroservices.model;


// Generated 12/09/2015 04:52:35 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Novedades generated by hbm2java
 */
@Entity
@Table(name="Novedades")
public class Novedad  implements java.io.Serializable {


     private Integer idNovedades;
     private Ruta rutas;
     private String descripcion;
     private Date fecha;

    public Novedad() {
    }

    public Novedad(Ruta rutas, String descripcion, Date fecha) {
       this.rutas = rutas;
       this.descripcion = descripcion;
       this.fecha = fecha;
    }
   
     @Id @GeneratedValue

    
    @Column(name="idNovedades", unique=true, nullable=false)
    public Integer getIdNovedades() {
        return this.idNovedades;
    }
    
    public void setIdNovedades(Integer idNovedades) {
        this.idNovedades = idNovedades;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Rutas_idRutas", nullable=false)
    public Ruta getRutas() {
        return this.rutas;
    }
    
    public void setRutas(Ruta rutas) {
        this.rutas = rutas;
    }

    
    @Column(name="descripcion", nullable=false, length=200)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha", nullable=false, length=10)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}

