package EjercicioParicalEmbotelladora;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlantaEmbotelladora {

    boolean vino = false, agua = false;
    int cantidadVino = 0, cantidadAgua = 0, cantAlmacen = 0;
    Semaphore embotellarVino = new Semaphore(1), embotellarAgua = new Semaphore(1), empaquetador = new Semaphore(0), almacen = new Semaphore(1);
    Semaphore transportador = new Semaphore(0);

    public void iniciarEmbotelladoVino() {
        try {
            embotellarVino.acquire();

            cantidadVino++;
        } catch (InterruptedException ex) {
            Logger.getLogger(PlantaEmbotelladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Cantidad vino: " + cantidadVino + "/ 10");

    }

    public void iniciarEmbotelladoAgua() {

        try {
            embotellarAgua.acquire();

            cantidadAgua++;
        } catch (InterruptedException ex) {
            Logger.getLogger(PlantaEmbotelladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Cantidad agua: " + cantidadAgua + "/10");
    }

    public void terminarEmbotelladoVino() {
        if (cantidadVino == 10) {
            this.vino = true;
            empaquetador.release();

        } else {
            embotellarVino.release();
        }
    }

    public void terminarEmbotelladoAgua() {
        if (cantidadAgua == 10) {
            this.agua = true;
            this.empaquetador.release();

        } else {
            embotellarAgua.release();
        }
    }

    public void iniciarEmpaque() {

        try {
            empaquetador.acquire();
            almacen.acquire();
            if (vino) {
                System.out.println("Empaquetando vino. /n -----");
                cantidadVino = 0;

            } else if (agua) {
                System.out.println("Empaquetando agua. /n ------");
                cantidadAgua = 0;
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(PlantaEmbotelladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void terminarEmpaque() {
        cantAlmacen++;
        System.out.println("La caja se esta colocando en el almacen. /n ----- " + (cantAlmacen) +  " / 10");

        

        if (cantAlmacen == 10) {
            transportador.release();

        }
        if (vino && cantidadVino == 0) {
            vino = false;

            embotellarVino.release();

        } else if (agua && cantidadAgua == 0) {
            agua = false;
            embotellarAgua.release();

        }
        almacen.release();

    }

    public void transportarCajas() {
        try {
            transportador.acquire();
            System.out.println("El transportador inicio su recorrido. " + almacen + "/10. Almacen lleno.");
        } catch (InterruptedException ex) {
            Logger.getLogger(PlantaEmbotelladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Iniciado viaje....");
    }

    public void terminarTransporteCajas() {
        try {
            System.out.println("El transportador termino");

            almacen.acquire();
            cantAlmacen = 0;
            almacen.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(PlantaEmbotelladora.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
