
package TP4.Ejercicio7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Empleado implements Runnable {
    //Semaforo empleado y semaforoMozo
    Bar bar;
    

    public Empleado(Bar bar) {
        this.bar = bar;
       
    }

    public void run() {
        //llamarMozo.
       
        bar.sentarse();
        bar.llamarMozo();
        
        try {
            System.out.println("El cliente  " +Thread.currentThread().getName() + "Esta comiendo.");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        bar.irme();
        
        


    }

}
