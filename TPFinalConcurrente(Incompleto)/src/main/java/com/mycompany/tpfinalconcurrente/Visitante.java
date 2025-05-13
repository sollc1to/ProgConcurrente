/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpfinalconcurrente;

import java.util.concurrent.Exchanger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Visitante implements Runnable{
    
    ParqueDiversiones parque;
    Exchanger <String> cambiarFicha;
    
    public Visitante(ParqueDiversiones parque, Exchanger e){
        this.parque  = parque;
        this.cambiarFicha = e;
    }
    
    public void run(){
        int i = 0;
        while(true){
            try {
                String p = cambiarFicha.exchange("FICHA " + i);
                System.out.println(p);
                i++;
            } catch (InterruptedException ex) {
                Logger.getLogger(Visitante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
