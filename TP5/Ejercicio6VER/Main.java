/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ejercicio6VER;

/**
 *
 * @author PC
 */
public class Main {
    public static void main(String[] args) {
        TorreControl torre = new TorreControl();
        
        
        Thread [] avionA = new Thread[15];
        
        
        for (int i = 0; i < avionA.length; i++) {
            avionA[i] = new Thread(new AvionAterrizaje(torre),""+i);
            
            avionA[i].start();
            
        }
        Thread [] avionD = new Thread[5];
        
        
        for (int i = 0; i < avionA.length; i++) {
            avionD[i] = new Thread(new AvionDespegue(torre),""+i);
            
            avionD[i].start();
            
        }
        
        
        
    }
    
}
