package TP5.Ejercicio7;

public class Persona implements Runnable {

    private ParqueAcuatico p;

    public Persona(ParqueAcuatico parque) {
        this.p = parque;

    }
    public void run(){
        p.subirEscalon();
        
        p.bajarTobogan();
        System.out.println("El cliente" + Thread.currentThread().getName( ) + " bajo del tobogan :))");
    }

}
