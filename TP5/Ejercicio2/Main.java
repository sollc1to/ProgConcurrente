/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ejercicio2;

/**
 *
 * @author PC
 */
public class Main {

    public static void main(String[] args) {

        Bar bar = new Bar();

        Mozo mozo = new Mozo(bar);
        Cocinero cocinero = new Cocinero(bar);

        Thread hiloM = new Thread(mozo);
        Thread hiloC = new Thread(cocinero);

        Thread clientes[] = new Thread[4];

        clientes[0] = new Thread(new Empleado(bar, 1),"A");

        clientes[1] = new Thread(new Empleado(bar, 3),"B");
        clientes[2] = new Thread(new Empleado(bar, 3),"C");
        clientes[3] = new Thread(new Empleado(bar, 1),"D");
        
        for (int i = 0; i < 4; i++) {
            clientes[i].start();
            
        }
        hiloM.start();
        hiloC.start();

    }

}
