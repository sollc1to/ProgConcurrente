/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ejercicio6VER;

/**
 *
 * @author PC
 */
public class AvionDespegue implements Runnable{
    TorreControl torre;
    
    
    public AvionDespegue(TorreControl t){
        this.torre = t;
     
        
    }
    
    
    
    public void run(){
        
        
        
        torre.pedirDespegue();

        torre.despegar();
        
        
    }
    
    
    
}
