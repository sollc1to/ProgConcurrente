/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioFilmacion;

import java.util.concurrent.locks.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompaniaFilmacion {

    Lock lock = new ReentrantLock();
    Condition traductor = lock.newCondition();

    Lock lock2 = new ReentrantLock();
    Condition socioEspaño = lock2.newCondition();
    Condition socioIngles = lock2.newCondition();
    boolean leerE = false, leerI = false, tradu = false;
    int capitulosEspañol = 0, capitulosIngles = 0;

    public void filmarCapitulo() {
        lock.lock();

        try {
            System.out.println("Un nuevo capitulo en español se esta filmando");

        } finally {
            lock.unlock();
        }
    }

    public void terminarFilmarCap() {
        lock.lock();
        try {
            capitulosEspañol++;
            System.out.println("El filmador termino de filmar el capitulo " + capitulosEspañol);

            tradu = true;
            traductor.signalAll();

            lock2.lock();
            try {
                leerE = true;
                socioEspaño.signalAll();

            } finally {
                lock2.unlock();
            }
        } finally {
            lock.unlock();
        }
    }

    public void iniciarTraduccion() {
        lock.lock();

        try {
            while (capitulosEspañol == 0 || !tradu) {
                traductor.await();

            }
            
            tradu = false;
            
            capitulosIngles++;
            System.out.println("Se esta traduyendo el capitulo " + capitulosIngles);

        } catch (InterruptedException ex) {
            Logger.getLogger(CompaniaFilmacion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock.unlock();
        }
    }

    public void terminarTraduccion() {
        lock.lock();

        try {
            
            System.out.println("Se termino de traducir el capitulo " + capitulosIngles);
         
            

            lock2.lock();

            try {
                leerI = true;
                socioIngles.signalAll();
            } finally {
                lock2.unlock();
            }

        } finally {
            lock.unlock();
        }
    }

    public void verCapEspañol(int cap) {
        lock2.lock();
        try {

            while (!leerE) {
                socioEspaño.await();
            }

            System.out.println("El socio " + Thread.currentThread().getName() + " esta viendo el capitulo en español" + capitulosEspañol);

        } catch (InterruptedException ex) {
            Logger.getLogger(CompaniaFilmacion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock2.unlock();
        }
    }

    public void terminarCapEspañol() {
        lock2.lock();
        try {
            System.out.println("El socio " + Thread.currentThread().getName() + " termino de ver el capitulo en español.");
        } finally {
            lock2.unlock();
        }
    }

    public void verCapEIngles(int cap) {
        lock2.lock();
        try {

            while (!leerI) {
                socioIngles.await();
            }

            System.out.println("El socio " + Thread.currentThread().getName() + " esta viendo el capitulo en ingles " + capitulosIngles + " cap: " + cap);

        } catch (InterruptedException ex) {
            Logger.getLogger(CompaniaFilmacion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock2.unlock();
        }
    }

    public void terminarCapIngles() {
        lock2.lock();
        try {
            System.out.println("El socio " + Thread.currentThread().getName() + " termino de ver el capitulo en ingles. " + capitulosIngles);
        } finally {
            lock2.unlock();
        }
    }

}
