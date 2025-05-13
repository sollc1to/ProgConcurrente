/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ejercicio5;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class GestorImpresoras {
    
    Impresora[] impresoras;
   
    Semaphore buscarImpresora = new Semaphore(1);
  

    public GestorImpresoras(Impresora[] impresoras) {
        this.impresoras = impresoras;

    }

    public void quieroImprimir() {

        System.out.println("El cliente " + Thread.currentThread().getName() + " Quiere imprimir.");

        try {
            buscarImpresora.acquire(); //Buscamos impresora
            buscarImpresora();
            
            

        } catch (InterruptedException ex) {
            Logger.getLogger(GestorImpresoras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void buscarImpresora() {
        int i = 0;

        while (!impresoras[i].impresoraLibreDeTipo(Thread.currentThread().getName())) {
            i++;

            if (i == impresoras.length) {
                i = 0;

            }

        }
        
        
         impresoras[i].usarImpresora(); //Ocupo esta impresora.
        
        //Mientras otro cliente puede seguir utlizando otra. 
        
        buscarImpresora.release();
        
        
        
        try {
            Thread.sleep((int) (Math.random() * 1000) + 1); //Ponemos otro tiempo para simular la impresión
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorImpresoras.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        impresoras[i].liberarImpresora();
        
  
        //Una vez q encuentra una, la ocupa.

    }
    

}

    


