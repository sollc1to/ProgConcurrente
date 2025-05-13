/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ejercicio5;

/**
 *
 * @author PC
 */
public class Vehiculo {
    int patente, km, combustible;

    public void setPatente(int patente) {
        this.patente = patente;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPatente() {
        return patente;
    }

    public int getKm() {
        return km;
    }

    public int getCombustible() {
        return combustible;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public Vehiculo(int patente,int combustible,int km) {
        this.patente = patente;
        this.km = km;
        this.combustible = combustible;
     
    }
    String modelo, marca; 
    
}
