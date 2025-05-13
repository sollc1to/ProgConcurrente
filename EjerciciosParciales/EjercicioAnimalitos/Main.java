/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioAnimalitos;

/**
 *
 * @author PC
 */
public class Main {

    public static void main(String[] args) {
        Casa casa = new Casa();

        Thread animalMayor = new Thread(new AnimalMayor(casa));

        animalMayor.start();

        Thread[] animaleschiquitos = new Thread[20];

        for (int i = 0; i < animaleschiquitos.length; i++) {
            animaleschiquitos[i] = new Thread(new AnimalChiquito(casa), "" + i);
            animaleschiquitos[i].start();

        }
    }

}
