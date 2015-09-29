package com.agroservices.model;


// Generated 12/09/2015 04:52:35 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TransaccionesBancarias generated by hbm2java
 */
@Entity
@Table(name="TransaccionesBancarias")
public class TransaccionBancaria  implements java.io.Serializable {


     private Integer idTransaccionesBancarias;
     private String codAprobacion;
     private Date dineroConsignado;
     private Set <Factura>facturases = new HashSet<Factura>(0);

    public TransaccionBancaria() {
    }

	
    public TransaccionBancaria(String codAprobacion, Date dineroConsignado) {
        this.codAprobacion = codAprobacion;
        this.dineroConsignado = dineroConsignado;
    }
    public TransaccionBancaria(String codAprobacion, Date dineroConsignado, Set facturases) {
       this.codAprobacion = codAprobacion;
       this.dineroConsignado = dineroConsignado;
       this.facturases = facturases;
    }
   
     @Id @GeneratedValue

    
    @Column(name="idTransaccionesBancarias", unique=true, nullable=false)
    public Integer getIdTransaccionesBancarias() {
        return this.idTransaccionesBancarias;
    }
    
    public void setIdTransaccionesBancarias(Integer idTransaccionesBancarias) {
        this.idTransaccionesBancarias = idTransaccionesBancarias;
    }

    
    @Column(name="codAprobacion", nullable=false, length=20)
    public String getCodAprobacion() {
        return this.codAprobacion;
    }
    
    public void setCodAprobacion(String codAprobacion) {
        this.codAprobacion = codAprobacion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="dineroConsignado", nullable=false, length=10)
    public Date getDineroConsignado() {
        return this.dineroConsignado;
    }
    
    public void setDineroConsignado(Date dineroConsignado) {
        this.dineroConsignado = dineroConsignado;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="transaccionesBancarias")
    public Set<Factura> getFacturases() {
        return this.facturases;
    }
    
    public void setFacturases(Set <Factura>facturases) {
        this.facturases = facturases;
    }




}


