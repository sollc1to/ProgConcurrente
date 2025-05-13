/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioFilmacion;

/**
 *
 * @author PC
 */
public class Main {
    public static void main(String[] args) {
        CompaniaFilmacion c = new CompaniaFilmacion();
        Thread filmador = new Thread(new Filmador(c));
        filmador.start();
        Thread [] traductor = new Thread[2];
        
        traductor[0] = new Thread(new Traductor(c));
        traductor[0].start();
        traductor[1] = new Thread(new Traductor(c));
        traductor[1].start();
        
        Thread[] socios = new Thread[10];
        
        for (int i = 0; i < socios.length; i++) {
            socios[i] = new Thread(new Socio(c),""+i);
            socios[i].start();
            
        }
        
        
        
        
        
        
    }
    
}
