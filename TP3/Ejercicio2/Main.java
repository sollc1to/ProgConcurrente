/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ejercicio2;

/**
 *
 * @author PC
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Energia energia = new Energia();

        CriaturaOscura oscura = new CriaturaOscura("Oscura", energia);
        Sanador sanad = new Sanador("Sanador", energia);

        Thread hilo1 = new Thread(oscura);
        Thread hilo2 = new Thread(sanad);

        hilo1.start();
        hilo2.start();
        hilo1.join();
        hilo2.join();

        System.out.println("Energia " + energia.getCantidad());

    }

}
