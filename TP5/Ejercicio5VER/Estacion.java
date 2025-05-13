/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ejercicio5VER;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Estacion {

    private int permisos, tickets;
    private Semaphore cantidadPasajeros = new Semaphore(0), compraHabilitada = new Semaphore(1);
    private Semaphore vendedor = new Semaphore(0), bajarseTren = new Semaphore(0);

    public Estacion(int tickets) {
        this.tickets = tickets;
        this.permisos = tickets;

    }

    public void comprarTickets() {

        try {
            compraHabilitada.acquire(); //Toma el permiso de la compra.
            System.out.println("El cliente" + Thread.currentThread().getName() + " quiere comprar un ticket.");

        } catch (InterruptedException ex) {
            Logger.getLogger(Estacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        vendedor.release(); //Le da un permiso al vendedor para que le venda un ticket.
        
    }
    public void subirseTren(){
        
        cantidadPasajeros.release();
        
        System.out.println("El pasajero " + Thread.currentThread().getName() + " se subio al tren");
        
    }
    public void bajarseTren() {
        try {
            
            bajarseTren.acquire();
            tickets++;

        } catch (InterruptedException ex) {
            Logger.getLogger(Estacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        System.out.println("El cliente " + Thread.currentThread().getName() + "se bajo del tren.");

    }

    public void venderTicket() {

        try {
            vendedor.acquire();
            
             if (tickets > 0) { //Si todavía hay cantidad de tickets disponibles, vende un ticket.
                tickets--;
               System.out.println("El pasajero " + Thread.currentThread().getName() + " compro un ticket " + tickets);

               
                
            }else if(tickets == 0){
                
                tickets = permisos -1; //Igualmente vende el ticket, reinicia la cuenta de los tickets para la vuelta.
                
                System.out.println("El pasajero " + Thread.currentThread().getName() + " no podra viajar hasta que el tren termine su recorrido. " + tickets);
                
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Estacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        compraHabilitada.release();

    }

    public void realizarRecorrido() {

        try {
            cantidadPasajeros.acquire(permisos);
            compraHabilitada.acquire();
            System.out.println("La cantidad de tickets se lleno");
            System.out.println("El tren esta viajando...");

        } catch (InterruptedException ex) {
            Logger.getLogger(Estacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void terminarRecorrido() {

        System.out.println("El tren esta terminando su recorrido....");

        for (int i = 0; i < permisos; i++) {
           
            bajarseTren.release();

        }
        
        tickets = permisos;
        
        compraHabilitada.release();


    }

}
