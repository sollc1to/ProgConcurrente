/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ejercicio2.Semaforos;

/**
 *
 * @author PC
 */
public class Main {
        public static void main(String[] args) {
        SalaEstudio sala = new SalaEstudio(10);
        
        Thread[] estudiantes = new Thread[15];
        
        
        for (int i = 0; i < estudiantes.length; i++) {
            estudiantes[i] = new Thread(new Estudiante(sala),""+i);
            estudiantes[i].start();
            
        }
    }
    
    
}
