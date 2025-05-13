/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ejercicio7;

/**
 *
 * @author PC
 */
public class Pasajero implements Runnable{
    Puerto puerto;
    
    
    public Pasajero(Puerto p){
        this.puerto = p;
    }
    
    public void run(){
        puerto.subirPasajero();
        
        puerto.bajarPersona();
    }
    
}
