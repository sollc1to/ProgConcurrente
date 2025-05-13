/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ejercicio7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Encargado implements Runnable{
    
    private ParqueAcuatico p;
    
    public Encargado(ParqueAcuatico parque){
        this.p = parque;
        
    }
    public void run(){
        
        p.habilitarToboganes();
        System.out.println("El encargado habilito los toboganes");
        
        
        while (true){
            p.asignarTobogan();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Encargado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
