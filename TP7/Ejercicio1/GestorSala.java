/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP7.Ejercicio1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class GestorSala {

    private int cantidadMaxima, cantidadMaximaTemperatura, temperatura, umbral, cantidadActual, cantidadJubilados, cantidadPersonas;
    private int cantidadOriginal;
   
    private Lock condicion = new ReentrantLock();
    private Condition jubilados = condicion.newCondition();
    private Condition personas = condicion.newCondition();

    public GestorSala(int c, int cT, int umbral) {

        this.cantidadMaxima = c;
        this.cantidadMaximaTemperatura = cT;
        cantidadOriginal = c;
        this.umbral = umbral;
        this.temperatura = 20;
        this.cantidadActual = 0;
        cantidadJubilados = 0;
        cantidadPersonas = 0;

    }

    public void entrarSalaJubilado() {
        condicion.lock();
        cantidadJubilados++;
        try {
            while (cantidadActual == cantidadMaxima ) {
                System.out.println("El jubilado" + Thread.currentThread().getName() + " no puede ingresar a la sala..");

                jubilados.await(); //Espera en el ocnjunto de personas..

            }
            
            cantidadJubilados--;

            cantidadActual++;

            System.out.println("El jubilado " + Thread.currentThread().getName() + " entro. Cantidad Personas: " + cantidadActual);

        } catch (InterruptedException e) {

        } finally {
            condicion.unlock();
        }

    }

    public void entrarSala() {
        condicion.lock();
        cantidadPersonas++;

        try {
            while (cantidadActual >= cantidadMaxima || (cantidadJubilados > 0)) {
                System.out.println("La persona " + Thread.currentThread().getName() + " no puede ingresar a la sala..");

                personas.await(); //Espera en el ocnjunto de personas..

            }
            cantidadPersonas--;

            cantidadActual++;

            System.out.println("La persona " + Thread.currentThread().getName() + " entro. Cantidad Personas: " + cantidadActual);

        } catch (InterruptedException e) {

        } finally {
            condicion.unlock();
        }

    }

    public void salirSala() {
        condicion.lock();

        try {
            cantidadActual--;
            System.out.println("La persona " + Thread.currentThread().getName() + " se va de la sala. Cantidad Personas: " + cantidadActual);

            if (cantidadJubilados > 0){ //Priorizamos los jubilados
                jubilados.signal();
                
            }else if( cantidadPersonas > 0){
                personas.signal();
            }
        } finally {
            condicion.unlock();

        }

    }
    
    
    public void actualizarTemperatura(int temperatura){
       
        condicion.lock();
        
        try{
            
            this.temperatura = temperatura;
            
            if (temperatura > umbral) {
                cantidadOriginal = cantidadMaxima;
                
                cantidadMaxima = cantidadMaximaTemperatura;
                System.out.println("Se actualizao la cantidad maxima a" + cantidadMaxima);
                
            }else{
                cantidadMaxima = cantidadOriginal;
            }
            System.out.println("La temperatura se actualiza a " + temperatura);
        }finally{
            
            condicion.unlock();
            
        }
        
    }

}
