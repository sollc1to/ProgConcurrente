/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ejercicio1;

/**
 *
 * @author PC
 */
public class GestorPiscina {
    //Estara de mas la psicina no? puedo utilizarla solo como un semaforo?

    Piscina piscina;

    public GestorPiscina(Piscina piscina) {
        this.piscina = piscina;

    }

    public void quieroIngresarPiscina() {

        piscina.ingresarPiscina();
        piscina.salirPiscina();

    }

}
