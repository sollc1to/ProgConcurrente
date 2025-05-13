/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ejercicio4;

/**
 * 
 *
 * @author PC
 */
public class Main {

    public static void main(String[] args) {
        Area area = new Area(10);

        Visitante visitante1 = new Visitante("1", 1, area);
        Visitante visitante2 = new Visitante("2", 2, area);
        Visitante visitante3 = new Visitante("3", 3, area);
        Visitante visitante4 = new Visitante("4", 4, area);
        Visitante visitante5 = new Visitante("5", 5, area);
              Visitante visitante6 = new Visitante("4", 5, area);
        Visitante visitante7 = new Visitante("5", 4, area);
                Visitante visitante8 = new Visitante("8", 8, area);
Visitante visitante9 = new Visitante("9", 3, area);
Visitante visitante10 = new Visitante("10",6, area);
Visitante visitante11 = new Visitante("11", 7, area);
Visitante visitante12 = new Visitante("12", 5, area);
Visitante visitante13 = new Visitante("13",1, area);
Visitante visitante14 = new Visitante("14", 9, area);

Thread hilo8 = new Thread(visitante8);
Thread hilo9 = new Thread(visitante9);
Thread hilo10 = new Thread(visitante10);
Thread hilo11 = new Thread(visitante11);
Thread hilo12 = new Thread(visitante12);
Thread hilo13 = new Thread(visitante13);
Thread hilo14 = new Thread(visitante14);

        Thread hilo1 = new Thread(visitante1);
        Thread hilo2 = new Thread(visitante2);
        Thread hilo3 = new Thread(visitante3);

        Thread hilo4 = new Thread(visitante4);
        Thread hilo5 = new Thread(visitante5);
        
        Thread hilo6 = new Thread(visitante6);
        
        Thread hilo7 = new Thread(visitante7);
        
         hilo6.start();
        hilo7.start();
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
       
        


hilo8.start();
hilo9.start();
hilo10.start();
hilo11.start();
hilo12.start();
hilo13.start();
hilo14.start();
      
    }

}
