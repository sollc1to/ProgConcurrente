/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP7.Ejercicio3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author PC
 */
public class Cocina {

    private int carne, vegetales, pasta;

    private Lock lock = new ReentrantLock();

    private Condition esperaCarne = lock.newCondition();
    private Condition esperaVegetal = lock.newCondition();
    private Condition esperaPasta = lock.newCondition();

    public Cocina(int c, int v, int p) {
        this.carne = c;
        this.vegetales = v;
        this.pasta = p;
    }

    public void prepararVegetales() {
        lock.lock();

        try {
            while (vegetales == 0) {
                System.out.println("No hay vegetales disponibles para el cocinero " + Thread.currentThread().getName());

                esperaVegetal.await();
            }

            vegetales--;
            System.out.println("El cocinero " + Thread.currentThread().getName() + " obtuvo sus vegetales. Cantidad vegetales: " + vegetales);

        } catch (InterruptedException e) {

        } finally {

            lock.unlock();
        }

    }

    public void prepararCarne() {
        lock.lock();

        try {
            while (carne == 0) {
                System.out.println("No hay carne disponible para el cocinero " + Thread.currentThread().getName());

                esperaCarne.await();
            }

            carne--;
            System.out.println("El cocinero " + Thread.currentThread().getName() + " obtuvo su carne. Cantidad carne " + carne);

        } catch (InterruptedException e) {

        } finally {

            lock.unlock();
        }

    }

    public void prepararPasta() {
        lock.lock();

        try {
            while (pasta == 0) {
                System.out.println("No hay pasta disponible para el cocinero " + Thread.currentThread().getName());

                esperaCarne.await();
            }

            pasta--;
            System.out.println("El cocinero " + Thread.currentThread().getName() + " obtuvo su pasta. Cantidad pasta: " + pasta);

        } catch (InterruptedException e) {

        } finally {

            lock.unlock();
        }

    }

    public void reponerAlimento(boolean vegetal, boolean car, boolean past) {
        lock.lock();

        try {
            System.out.println("El cocinero " + Thread.currentThread().getName() + " esta reponiendo..");

            if (vegetal) {
                vegetales++;
                System.out.println(Thread.currentThread().getName() + " repuso vegetales. Cantidad vegetales: " + vegetales);
                esperaVegetal.signal();

            }
            if (car) {
                carne++;
                System.out.println(Thread.currentThread().getName() + " repuso carne. Cantidad carne: " + carne);
                esperaCarne.signal();

            }
            if (past) {
                pasta++;
                System.out.println(Thread.currentThread().getName() + " repuso pasta. Cantidad pasta: " + pasta);
                esperaPasta.signal();

            }
        } finally {
            lock.unlock();
        }

    }

}
