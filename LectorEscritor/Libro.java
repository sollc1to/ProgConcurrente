/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJericicoConcurrente;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Libro {

    private int cantidadLectores = 0, cantidadEscritores = 0;
    private int cantidadPaginas = 0, paginasMax = 0;
    private Semaphore escritor = new Semaphore(1), lector = new Semaphore(1);
    
    
    
    public boolean yaEscrito(){
        
        
        return(cantidadPaginas != 0);
        
   
        
    }
    
    public boolean paginasMaxima(){
        
        return(paginasMax == cantidadPaginas);
    }
    
    

    public void quieroEscribir() {
        
        try {
            //Una vez  que llega un escritor, este tiene prioridad.
            System.out.println("El escritor" + Thread.currentThread().getName() + " quiere escribir...");


            escritor.acquire();
            lector.acquire();
            
            System.out.println("El escritor " + Thread.currentThread().getName() + " esta escribiendo...");
            

            cantidadEscritores++;

            

        } catch (InterruptedException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public void terminarEscibir() {
         

            System.out.println("El escritor" + Thread.currentThread().getName() + " termino de escribir.");

            cantidadEscritores--;
            if (cantidadEscritores == 0) {
                lector.release(); //Si no hay ningun lector, libera a los lectores.

            }
            escritor.release();
            
            
       
        


    }

    public void quieroLeer() {
        try {
            System.out.println("El lector " + Thread.currentThread().getName() + " quiere leer");

            
            escritor.acquire();
            lector.acquire();
            
            
            System.out.println("El lector " + Thread.currentThread().getName() + " esta leyendo...");

            cantidadLectores++;
            
           




        } catch (InterruptedException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void terminarLeer() {

        cantidadLectores--;
        
        System.out.println("El escritor" + Thread.currentThread().getName() + " termino de leer");

        if (cantidadLectores == 0) { //Si hay un escritor esperando, bloquea la entrada.
            escritor.release();

        }
        
        
        lector.release();


    }

}
