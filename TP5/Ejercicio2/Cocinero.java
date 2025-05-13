/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ejercicio2;

/**
 *
 * @author PC
 */
public class Cocinero implements Runnable{
    private Bar bar;
    
    public Cocinero(Bar bar){
        this.bar = bar;
    }
    
    public void run(){
        
        while(true){
            bar.cocinar();
        }
        
    }
    
    
}
