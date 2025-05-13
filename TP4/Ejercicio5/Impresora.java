/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ejercicio5;

import java.util.concurrent.Semaphore;

/**
 *
 * @author PC
 */
public class Impresora {

    String tipo;
    Semaphore semaforo;
    int nombre;
    boolean libre;


    public Impresora(int nombreI, String tipo) {
        this.semaforo = new Semaphore(1); //Cada impresora cuenta c un permiso ya que estan desocupadas.
        this.nombre = nombreI;
        libre = true;
        this.tipo = tipo;
       
    }
    
    
    
    public  boolean impresoraLibreDeTipo(String tipoC){
        return (libre && (tipoC.equals(tipo) || tipoC.equals("X")));
        
        
        
    }
    

    public void usarImpresora() {
        try {
            
            semaforo.acquire(); //La impresora que esta desocupada puede utilizarse.
            libre = false;
            System.out.println("El cliente " + Thread.currentThread().getName() + " Esta utilizando la impresora " + nombre + " De tipo" + tipo);
            Thread.sleep((int) (Math.random() * 1000) + 1);

        } catch (InterruptedException e) {
            System.out.println("Error...");
        }

    }

    public void liberarImpresora() {

        System.out.println("El cliente " + Thread.currentThread().getName() + " terminó de utilizar la impresora " + nombre);
        libre = true;
        
        semaforo.release();
        

    }
}
