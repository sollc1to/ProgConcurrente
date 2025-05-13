/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioObservatorio;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Sala {

    private int cantMaxima = 50, cantVisitantes = 0, cantInvestigadores = 0, cantMantenimiento = 0, cantSilla = 0;
    //Como los de mantenimiento ingresan periodicamente, hago q ingresen cada 30 personas. 
  

    public synchronized void ingresarVisitante() {
        while (cantVisitantes == cantMaxima || cantInvestigadores > 0 || cantMantenimiento > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Sala.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        cantVisitantes++;
      
        System.out.println("El visitante" + Thread.currentThread().getName() + " ingresó a la sala. Cantidad visitantes: " + cantVisitantes + "/" + cantMaxima);

    }

    public synchronized void salirVisitante() {
        System.out.println("El visitante " + Thread.currentThread().getName() + " se va de la sala");
        cantVisitantes--;
    
        if (cantVisitantes == 0) {
            notifyAll();

        }
    }

    public synchronized void ingresarSillaRueda() {

        while (cantVisitantes >= 30 || cantInvestigadores > 0 || cantMantenimiento > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Sala.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        cantSilla++;
        cantVisitantes++;
        cantMaxima = 30;
        System.out.println("El visitante c silla de ruedas ingreso.");
        System.out.println("Cantidad de visitantes " + cantVisitantes + "/" + cantMaxima);

    }

    public synchronized void salirSillaRueda() {

        System.out.println("La persona c silla de rueda" + Thread.currentThread().getName() + " se va de la sala.");
        cantVisitantes--;
        cantSilla--;

        System.out.println("Cantidad visitantes" + cantVisitantes + "/" + cantMaxima);
        if (cantSilla == 0) {
            cantMaxima = 50;

        }
      

        if (cantVisitantes == 0) {
            notifyAll();

        }

    }

    public synchronized void ingresarMantenimiento() {

        while (cantVisitantes > 0 || cantInvestigadores > 0 || cantMantenimiento == cantMaxima) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Sala.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        System.out.println("La persona de mantenimiento " + Thread.currentThread().getName() + " ingreso a la sala.");
        cantMantenimiento++;
        System.out.println("Cantidad de mantenimiento: " + cantMantenimiento + "/" + cantMaxima);

    }

    public synchronized void salirMantenimiento() {
        System.out.println("La persona de mantenimiento " + Thread.currentThread().getName() + " se va");

        cantMantenimiento--;
        System.out.println("Cantidad de mantenimiento: " + cantMantenimiento + "/" + cantMaxima);
        if (cantMantenimiento == 0) {
            
            notifyAll();

        }

    }

    public synchronized void ingresarInvestigador() {

        while (cantInvestigadores > 0 || cantMantenimiento > 0 || cantVisitantes > 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Sala.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        System.out.println("Ingreso el investigador " + Thread.currentThread().getName());
        cantInvestigadores++;

    }

    public synchronized void salirInvestigador() {

        System.out.println("El investigador " + Thread.currentThread().getName() + " se va");
        cantInvestigadores--;

        notifyAll();
    }

}
