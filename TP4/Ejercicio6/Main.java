
package TP4.Ejercicio6;

import java.util.concurrent.Semaphore;

public class Main {
    
    public static void main(String[] args) {
        Semaphore semaforoC = new Semaphore (1);
        Semaphore semaforoT = new Semaphore(1);
        
        //pROBLEMA CON LOS NOMBRES
        Viaje viaje = new Viaje();
       
        
        
        Taxi taxi = new Taxi(viaje);
        
        Thread hiloTaxi = new Thread(taxi);
        
        
        hiloTaxi.start();
        
        
        Thread[] clientes = new Thread [6];
        
        
        for (int i = 0; i < clientes.length; i++) {
            
            clientes[i] = new Thread(new Cliente(viaje),String.valueOf(i));
            
            
        }
          clientes[2].start();
        clientes[3].start();
        clientes[4].start();
        clientes[5].start();
        clientes[0].start();
        clientes[1].start();
        
      
   
        
    }
    
}
