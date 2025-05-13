package com.mycompany.progconcurrente;

public class ThreadEjemplo extends Thread {

    public static void main(String[] args) {

        miClase hilo1 = new miClase("Jose Maria");

        miClase hilo2 = new miClase("Maria Jose");

        new ThreadEjemplo(hilo1).start();
        new ThreadEjemplo(hilo2).start();
        //Implemento el run() en miClase que es Runnable
        
        

    }

    public ThreadEjemplo(Runnable str) { //Constructor Thread, le cambio el parámetro a Runnable.
        super(str);
    }
    

    /* public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + this.getName());
        }
        System.out.println("Termina thread " + this.getName());
    }
   

    public static void main(String[] args) {
        new ThreadEjemplo("Maria Jose").start();
        new ThreadEjemplo("Jose Maria").start();
        System.out.println("Termina thread main");
    }
     */
}
