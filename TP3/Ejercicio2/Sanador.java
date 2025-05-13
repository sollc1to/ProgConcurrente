/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ejercicio2;

/**
 *
 * @author PC
 */
public class Sanador implements Runnable{

    String name;
    Energia energia;

    public Sanador(String nombre, Energia energia) {
        this.name = nombre;
        this.energia = energia;

    }
    
    public void run(){
        
        for (int i = 0; i < 10; i++) {
            this.energia.sumar();
            System.out.println("Criatura sanadora suma.." + energia.getCantidad());
            
        }
        
        
    }

 
    
    
    

}
