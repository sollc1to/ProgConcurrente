/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioObservatorio;

/**
 *
 * @author PC
 */
public class Main {
    public static void main(String[] args) {
        Sala sala = new Sala();
        
        Thread[] investigadores = new Thread[30];
        Thread[] mantenimiento = new Thread[50];
        Thread [] visitantes = new Thread [150];
        
        for (int i = 0; i < investigadores.length; i++) {
            investigadores[i] = new Thread(new Investigador(sala), ""+i);
            investigadores[i].start();
            
        }
         for (int i = 0; i < mantenimiento.length; i++) {
            mantenimiento[i] = new Thread(new Mantenimiento(sala), ""+i);
            mantenimiento[i].start();
            
        }
          for (int i = 0; i < visitantes.length; i++) {
            visitantes[i] = new Thread(new Visitante(sala), ""+i);
            visitantes[i].start();
            
        }
    }
    
}
