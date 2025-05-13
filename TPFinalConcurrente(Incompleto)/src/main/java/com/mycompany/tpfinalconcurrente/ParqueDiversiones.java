/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpfinalconcurrente;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ParqueDiversiones {

    private LocalTime hora = LocalTime.of(00, 00, 00);
    private int horaAux, cantidadMoli;
    private Semaphore cantidadMolinetes = new Semaphore(0); //Debe ser constante.
    private Semaphore abrirComercio = new Semaphore(0);
    private int cantidadGente = 0;
    private Semaphore molineteDisponible = new Semaphore(0);
    private Exchanger<String> juegoPremio = new Exchanger() ;

    public void actualizarHora(LocalTime horaA) {

        this.hora = horaA;

        horaAux = hora.getHour();

        if (horaAux == 9) {
            System.out.println("Hora actual: " + hora.toString());
            abrirComercio.release();

        }
        //Si hora == 9, abren los comercios. 
        //Si hora == 18, se cierra el parque.
        //Si hora == 19, no puede entrar mas gente a las actividades.
        //Si  hora == 23, no debería haber nadie.

        System.out.println(horaAux);

    }

    public void abrirComercio() { //Un empleado abrirá y cerrará los distintos comercios.
        try {
            //Se abre una vez q son las 9 .

            abrirComercio.acquire();
            System.out.println("El parque de diversiones abre :) pueden ingresar visitantes.");
            cantidadMolinetes.release(cantidadMoli);

        } catch (InterruptedException ex) {
            Logger.getLogger(ParqueDiversiones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ingresarParque() {

        try {
            cantidadMolinetes.acquire();
            System.out.println("El visitante  " + Thread.currentThread().getName() + " ingreso al parque.");

            cantidadMolinetes.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(ParqueDiversiones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cambiarFicha() {
        String premio = "";
        try {
            premio = juegoPremio.exchange("Ficha");
            System.out.println("El visitante " + Thread.currentThread().getName() + " cambio su ficha por un premio: " + premio);
        } catch (InterruptedException ex) {
            Logger.getLogger(ParqueDiversiones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cambiarPremio() {
        String premio = "";
        int i = (int) Math.random() * 3;
        try {
            if (i == 0) {
                premio = "Premio chico.";

            } else if (i == 1) {
                premio = "Premio mediano.";
            } else {

                premio = "Premio grande";
            }

            juegoPremio.exchange(premio);
            System.out.println("El encargado intercambió un premio :D");

        } catch (InterruptedException ex) {
            Logger.getLogger(ParqueDiversiones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
