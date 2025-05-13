/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ejercicio6VER;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class TorreControl {

    private Semaphore mutex = new Semaphore(1), aterrizaje = new Semaphore(0), despegue = new Semaphore(0), pista = new Semaphore(1);

    private int cantidadAterrizajes, esperandoAterrizar, esperandoDespegar;
    public TorreControl(){
        
    }

    public void pedirAterrizaje() {
        try {
            mutex.acquire(); //Exclusion mutua. Este es el semaforo compartido, llegan de a uno. 

            System.out.println("El avion " + Thread.currentThread().getName() + " quiere aterrizar...");
            esperandoAterrizar++; //Incrementa el contador de aterrizajes en espera.
              System.out.println(" esprando " + esperandoAterrizar);

            if (cantidadAterrizajes == 10) { //Si hubieron 10 aterrizajes, y hay uno (o mas) esperando para despegar
                despegue.release(); //Le da un permiso al que quiera despegar...

            } else {
                aterrizaje.release();
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(TorreControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        mutex.release();

    }

    public void aterrizar() {
        try {
            aterrizaje.acquire();
            pista.acquire();

            System.out.println("El avion " + Thread.currentThread().getName() + " esta aterrizando...");
            

            cantidadAterrizajes++;

            esperandoAterrizar--;
            
            System.out.println("Aterrizajes" + cantidadAterrizajes + " esprando " + esperandoAterrizar);

        } catch (InterruptedException ex) {
            Logger.getLogger(TorreControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if (cantidadAterrizajes == 10 ) {
            despegue.release();
            
        }else{
            aterrizaje.release();
            
        }
        
            pista.release();
          
        
        

    }
    public void pedirDespegue(){
        
        try {
            mutex.acquire();
            System.out.println("El avion " + Thread.currentThread().getName() + " quiere despegar...");
            esperandoDespegar++;
            System.out.println("Espernado despegar" + esperandoDespegar);
            
            if (esperandoAterrizar == 0 || cantidadAterrizajes == 10) { //Si no hay ningun avion queriendo aterrizar, entonces puede despegar.
                despegue.release();
                
            }
         
        } catch (InterruptedException ex) {
            Logger.getLogger(TorreControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        mutex.release();
        
    }
    
    
    
    public void despegar(){
        try {
            despegue.acquire();
            pista.acquire();
            System.out.println("El avion " + Thread.currentThread().getName() + " esta despegando...");
          
            esperandoDespegar--;
                        System.out.println("Espernado despegar AAA" + esperandoDespegar);

        } catch (InterruptedException ex) {
            Logger.getLogger(TorreControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         
        
        System.out.println("El avion " + Thread.currentThread().getName() + " termino de despegar.");
        
        pista.release();
    }

}
