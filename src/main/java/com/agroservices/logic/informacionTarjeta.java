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
    private int añoVencimiento;
    
    
    /**
     * Creador de la clase informacionTarjeta
     * @param numero
     * @param codigo
     * @param mesVencimiento
     * @param añoVencimiento 
     */
    public informacionTarjeta(int numero, int codigo, int mesVencimiento, int añoVencimiento){
        this.numero = numero;
        this.codigo = codigo;
        this.mesVencimiento = mesVencimiento;
        this.añoVencimiento = añoVencimiento;
    }
    
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

    public int getAñoVencimiento() {
        return añoVencimiento;
    }

    public void setAñoVencimiento(int añoVencimiento) {
        this.añoVencimiento = añoVencimiento;
    }
    
    
            
    
}
