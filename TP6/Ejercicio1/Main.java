/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ejercicio1;

/**
 *
 * @author PC
 */
public class Main {
    public static void main(String[] args) {
        
        GestionarTrafico g = new GestionarTrafico();
        
        
        Thread[] cocheS = new Thread[8];
        Thread [] cocheN = new Thread[6];
     
        
        
        
        for (int i = 0; i < cocheS.length; i++) {
            cocheS[i] = new Thread(new CocheSur(g),""+i);
            cocheS[i].start();
            
        }
            for (int i = 0; i < cocheN.length; i++) {
            cocheN[i] = new Thread(new CocheNorte(g),""+i);
            cocheN[i].start();
            
        }
        
        
    }
    
}
