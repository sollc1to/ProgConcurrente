/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioHacerAgua;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author PC
 */
public class Espacio {

    Lock lock1 = new ReentrantLock();
    Lock lock3 = new ReentrantLock();

    int cantidadAgua = 0, maxAgua;

    Condition oxigeno = lock1.newCondition();
    Condition hidrogeno = lock1.newCondition();
    Condition esperar = lock1.newCondition();
    Condition esperarHacerAgua = lock3.newCondition();

    int cantOxigeno = 0, cantHidrogeno = 0;

    public Espacio(int maxAgua) {
        this.maxAgua = maxAgua;

    }

    public void Olisto() {
        lock1.lock();

        try {
            while (cantOxigeno == 1) {
                oxigeno.await();
            }

            cantOxigeno++;
            System.out.println("Oxigeno " + cantOxigeno);

            if (cantOxigeno == 1 && cantHidrogeno == 2) { //Si estan los necesarios, realiza agua
                hacerAgua();

            } else {
                esperar.await();

            }
        } catch (InterruptedException e) {

        } finally {
            lock1.unlock();

        }
    }

    public void Hlisto() {
        lock1.lock();

        try {
            while (cantHidrogeno == 2) {
                hidrogeno.await();
            }
            cantHidrogeno++;
            System.out.println("Hidrogeno " + cantHidrogeno + "/2");
            if (cantOxigeno == 1 && cantHidrogeno == 2) {
                hacerAgua();

            } else {
                esperar.await();

            }
        } catch (InterruptedException e) {

        } finally {
            lock1.unlock();
        }
    }

    public void hacerAgua() {
        lock3.lock();

        try {

            cantidadAgua++;
            System.out.println("Se hace agua :). Cantidad agua: " + cantidadAgua + "/" + maxAgua);

            if (cantidadAgua == maxAgua) {

                System.out.println("Se lleno el recipiente.. cantidad agua: 0");
                cantidadAgua = 0;

            }

            cantOxigeno = 0;
            cantHidrogeno = 0;
            lock1.lock();
            try {

                oxigeno.signalAll();
                hidrogeno.signalAll();
                esperar.signalAll();

            } catch (Exception e) {

            } finally {
                lock1.unlock();
            }

        } finally {

            lock3.unlock();

        }

    }

}
