/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ejercicio3;

/**
 *
 * @author PC
 */
public class Hamster implements Runnable{

    String nombre;
    ElPlato comer;
    LaRueda correr;
    ElDescanso descansar;

    public Hamster(String nombre, ElPlato comer, LaRueda correr, ElDescanso descansar) {
        this.nombre = nombre;
        this.comer = comer;
        this.correr = correr;
        this.descansar = descansar;
    }

    public String getNombre() {
        return nombre;
    }

    public void run() {

        
        comer.comer(nombre);
        correr.correr(nombre);
        descansar.descansar(nombre);

    }

    
}
