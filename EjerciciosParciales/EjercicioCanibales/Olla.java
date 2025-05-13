/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioCanibales;

import java.util.concurrent.locks.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Olla {

    int raciones = 20;
    boolean avisarCocinero = false;

    Lock lock = new ReentrantLock();

    Condition comer = lock.newCondition();
    Condition cocinar = lock.newCondition();
    Condition esperarComida = lock.newCondition();

    public void empezarComer() {
        lock.lock();
        try {
            while (raciones == 0) {
                if (!avisarCocinero) {
                    System.out.println("El canibal " + Thread.currentThread().getName() + " avisa al cocinero que no hay comida.");
                    avisarCocinero = true;
                    cocinar.signal();
                    esperarComida.await();

                } else {
                    comer.await();
                }

            }
            System.out.println("El canibal " + Thread.currentThread().getName() + " esta comiendo");
            raciones--;
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();

        }
    }

    public void terminarComer() {
        lock.lock();
        try {

            System.out.println("El canibal " + Thread.currentThread().getName() + " termino de comer");


        } finally {
            lock.unlock();
        }

    }

    public void empezarCocinar() {
        lock.lock();

        try {

            while (raciones > 0) {
                cocinar.await();

            }
            System.out.println("El cocinero esta reponiendo raciones");
            raciones = 20;
        } catch (InterruptedException ex) {
            Logger.getLogger(Olla.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock.unlock();
        }
    }

    public void terminarCocinar() {
        lock.lock();
        try {
            System.out.println("El cocinero termino.");
            esperarComida.signal();
            comer.signalAll();

        } finally {
            lock.unlock();
        }

    }

}
