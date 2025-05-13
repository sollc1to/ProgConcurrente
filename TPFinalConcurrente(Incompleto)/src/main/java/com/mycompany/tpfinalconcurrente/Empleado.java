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
public class Empleado implements Runnable{
    ParqueDiversiones parque;
    Exchanger <String> cambiarPremio;
    
    public Empleado(ParqueDiversiones parque, Exchanger e){
        this.parque  = parque;
        this.cambiarPremio = e;
    }
    
    public void run(){
        int i = 0;
        
        while(true){
            if (i % 3 == 0) {
                try {
                    cambiarPremio.exchange("PREMIO CHICO");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else if ( i %2 == 0){
                try {
                    cambiarPremio.exchange("PREMIO MEDIANO");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                try {
                    cambiarPremio.exchange("PREMIO GRANDE");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            i++;
        }
    }
    
}
