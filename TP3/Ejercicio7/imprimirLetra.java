/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ejercicio7;

/**
 *
 * @author PC
 */
public class imprimirLetra implements Runnable {

    private int cantidad;
    private miTurno miturno;

    public imprimirLetra(int c, miTurno turno) {
        cantidad = c;
        miturno = turno;
    }

    public void run() {

        while (!(miturno.esMiTurno())) { //Mientras no sea mi turno, se duerme.
            

        }
        
        miturno.imprimir(cantidad);

    }

   

}
