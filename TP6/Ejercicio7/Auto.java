/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ejercicio7;

/**
 *
 * @author PC
 */
public class Auto implements Runnable{
    Puerto puerto;
    
    
    public Auto(Puerto p){
        this.puerto = p;
    }
    
    public void run(){
        puerto.subirAuto();
        
        puerto.bajarAuto();
    }
    
}
