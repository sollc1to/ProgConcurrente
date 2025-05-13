package EjercicioAnimalitos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Casa {

    private Semaphore mayor = new Semaphore(0), banquito = new Semaphore(4), esperandoComida = new Semaphore(0),contador = new Semaphore(1);
    private int esperando = 0;

    public void sentarseBanquito() {
        try {
            banquito.acquire();
            contador.acquire();
            esperando++;
            contador.release();
            System.out.println("El animalito " + Thread.currentThread().getName() + " se canso y se sento en el banquito a esperar la comida");
            if (esperando == 1) {
                mayor.release();

            }
            esperandoComida.acquire();

            System.out.println("El animalito " + Thread.currentThread().getName() + " esta comiendo");

        } catch (InterruptedException ex) {
            Logger.getLogger(Casa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void terminarComer() {
        System.out.println("El animalito" + Thread.currentThread().getName() + " termino de comer y se va del banquito");
        banquito.release();
    }

    public void prepararComida() {
        try {
            mayor.acquire();
            System.out.println("El mayor esta preparando la comida");
        } catch (InterruptedException ex) {
            Logger.getLogger(Casa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void servirComida() {
        try {
            System.out.println("El mayor esta sirviendo la comida..");
            for (int i = 0; i < esperando; i++) {
                esperandoComida.release();
                
            }
            contador.acquire();
            esperando = 0;
            contador.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Casa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
