/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ejercicio2;

/**
 *
 * @author PC
 */
public class Energia {
     int cantidad;
    
    public Energia(){
        
        this.cantidad = 10;
    }
    public int getCantidad(){
        
        return this.cantidad;
    }
    
   
    public void restar(){
        
        this.cantidad = cantidad - 3;
    }
    public void sumar(){
        this.cantidad = cantidad + 3;
    }
   
    
    
}
