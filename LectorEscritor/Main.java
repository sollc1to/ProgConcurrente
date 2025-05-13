/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJericicoConcurrente;

public class Main {
    public static void main(String[] args) {
        Libro libro = new Libro();
        
        Thread escritor1 = new Thread(new Escritor(libro), " "+1);
        Thread escritor2 = new Thread(new Escritor(libro), " "+2);
        Thread escritor3 = new Thread(new Escritor(libro), " "+3);
        
        Thread [ ] lectores = new Thread[10];
        
        
        for (int i = 0; i < lectores.length; i++) {
            
            lectores[i] = new Thread(new Lector(libro), " "+i);
            lectores[i].start();
            
        }
        escritor1.start();
        escritor2.start();
        escritor3.start();
    }
    
}
