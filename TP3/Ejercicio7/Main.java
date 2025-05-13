package TP3.Ejercicio7;

public class Main {

    public static void main(String[] args) {
        //Imprime B luego de que imprimio A y dps sigue imprimiendo A

        miTurno turno = new miTurno();

        imprimirLetra A, B, C;

        A = new imprimirLetra(4, turno);
        B = new imprimirLetra(2, turno);
        C = new imprimirLetra(2, turno);

        Thread imprimirA = new Thread(A,"A");
        Thread imprimirB = new Thread(B,"B");
        Thread imprimirC = new Thread(C,"C");

        imprimirA.start();
        imprimirB.start();
        imprimirC.start();

    }

}
