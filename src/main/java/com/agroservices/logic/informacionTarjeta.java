/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agroservices.logic;

/**
 *
 * @author Andres
 */
public class informacionTarjeta {
    
    private int numero;
    private int codigo;
    private int mesVencimiento;
    private int anoVencimiento;
    
    
    /**
     * Creador de la clase informacionTarjeta
     * @param numero
     * @param codigo
     * @param mesVencimiento
     * @param anoVencimiento 
     */
    public informacionTarjeta(int numero, int codigo, int mesVencimiento, int anoVencimiento){
        this.numero = numero;
        this.codigo = codigo;
        this.mesVencimiento = mesVencimiento;
        this.anoVencimiento = anoVencimiento;
    }
    
    public informacionTarjeta(){}
    /**
     * 
     * Setters and getters de la clase 
     */

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getMesVencimiento() {
        return mesVencimiento;
    }

    public void setMesVencimiento(int mesVencimiento) {
        this.mesVencimiento = mesVencimiento;
    }

    public int getAnoVencimiento() {
        return anoVencimiento;
    }

    public void setAnoVencimiento(int añoVencimiento) {
        this.anoVencimiento = añoVencimiento;
    }
    
    
            
    
}
