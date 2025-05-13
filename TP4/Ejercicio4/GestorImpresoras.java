package TP4.Ejercicio4;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        while (impresoras[i].impresoraOcupada()) {
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
