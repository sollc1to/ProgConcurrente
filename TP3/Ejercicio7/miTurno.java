/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ejercicio7;

/**
 *
 * @author PC
 */
public class miTurno {

    private String miturno;
    private String siguienteTurno;

    public miTurno() {

        miturno = "A";

    }

    public String getTurno() {
        return miturno;
    }

    public synchronized boolean esMiTurno() { //Pongo synchronized ya que pudo haber impreso A, y luego cambiar el turno a B
        //Entonces puede imprimir B sin que A haya terminado.
        boolean turno = false;
        if (Thread.currentThread().getName().equals(miturno)) {
            turno = true;
            
            

        } 
        return turno;

    }
     public synchronized void imprimir(int cantidad ) { //Este metodo 
        int i = 0;
        while (i < cantidad) { //Una vez que sea i turno, continuo con la ejecucion. 

            System.out.println(miturno);
            i++;
        }
        
        //Luego que imprime, modifica el turno
        setTurno();

    }

    public synchronized void setTurno() {

        if (miturno.equals("A")) {

            miturno = "B";

        } else if (miturno.equals("B")) {

            miturno = "C";

        } else if (miturno.equals("C")) {

            miturno = "A";
        }

    }

}
