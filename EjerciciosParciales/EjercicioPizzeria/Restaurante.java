/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPizzeria;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Restaurante {

    Queue<String> cola = new LinkedList<>(); //Cola de pedidos.
    Semaphore pedidos = new Semaphore(1), cocineroVeggie = new Semaphore(0), cocineroPizza = new Semaphore(0), repartidor = new Semaphore(0), mostrador = new Semaphore(20);
    Semaphore contador = new Semaphore(1), modificadorCola = new Semaphore(1);
    int cantidadViajesRepartidor;

    //Primero se realiza el pedido.
    public void tomarPedido(String nombre, String tipo) {
        try {
            pedidos.acquire();

            System.out.println("El cliente" + nombre + " pide pizza " + tipo);
            modificadorCola.acquire();
            cola.add("Cliente:" + nombre + "pedido: " + tipo); //Agrego el pedido a la lista.
            modificadorCola.release();

            if (tipo.equals("veggie")) {

                cocineroVeggie.release();

            } else {

                cocineroPizza.release();
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Restaurante.class.getName()).log(Level.SEVERE, null, ex);
        }
        pedidos.release();
    }
    public void cocinarPizzaVeggie() {
        try {
            cocineroVeggie.acquire();
            System.out.println("Cocinero preparando pedido vegetariano.");
        } catch (InterruptedException ex) {
            Logger.getLogger(Restaurante.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  

    public void cocinarPizza() {
        try {
            cocineroPizza.acquire();
            System.out.println("Cocinero preparando pedido normal.");
        } catch (InterruptedException ex) {
            Logger.getLogger(Restaurante.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void terminarPedido() {

        System.out.println("El cocinero termino el pedido" + cola.peek());

        try {
            contador.acquire();
            if (cantidadViajesRepartidor == 10) {
                System.out.println("El cocinero esta haciendo una pizza para el repartidor..");

            }
            contador.release();
            mostrador.acquire(); //Ocupo un lugar del mostrador.
            repartidor.release(); //El repartidor deja de esperar.
        } catch (InterruptedException ex) {
            Logger.getLogger(Restaurante.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void repartirPedido() {
        try {
            repartidor.acquire();

            System.out.println("El repartidor agarra un pedido.");
            contador.acquire();
            if (cantidadViajesRepartidor == 10) {
                System.out.println("El repartidor descansará un rato...");
                Thread.sleep(2500);
                System.out.println("El repartidor esta comiendo la pizza que le dejaron :D");
                Thread.sleep(2500);
                cantidadViajesRepartidor = 0;

            }
            cantidadViajesRepartidor++;
            contador.release();
            mostrador.release();

            System.out.println("Llevando el pedido al cliente...");
        } catch (InterruptedException ex) {
            Logger.getLogger(Restaurante.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void entregarPedido(){
        System.out.println("El pedido fue entregado a" + cola.peek());
        try {
            modificadorCola.acquire();
            cola.remove();
            modificadorCola.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Restaurante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
