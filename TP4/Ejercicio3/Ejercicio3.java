package TP4.Ejercicio3;

import java.util.concurrent.Semaphore;

public class Ejercicio3 {

    /*Implementar el código correspondiente para lograr la sincronización de tres
procesos (P1,P2,P3) de forma que se establezca el orden de ejecución P1, P3 y
P2. Así primero se ejecuta P1 y cuando finaliza P1 se puede ejecutar P3 y
cuando finaliza P3 se puede ejecutar P2 y cuando finaliza P2 se puede ejecutar
P1 y así sucesivamente.*/
    public static void main(String[] args) {
        //Creo mis 3 semaforos, P1 P3 y P2.
        Semaphore semaforo1 = new Semaphore(1);
        Semaphore semaforo2 = new Semaphore(0);
        Semaphore semaforo3 = new Semaphore(0);
        
        Proceso proceso1 = new Proceso(semaforo1,semaforo3);
        Proceso proceso2 = new Proceso(semaforo3,semaforo2);
        Proceso proceso3 = new Proceso(semaforo2,semaforo1);
        
        
        
        Thread hilo1 = new Thread(proceso1,"1");
        Thread hilo2 = new Thread(proceso2,"3");
        Thread hilo3 = new Thread(proceso3,"2");
        
      
        hilo1.start();hilo2.start();hilo3.start();
        
        
        
        
        
        
    }

}
