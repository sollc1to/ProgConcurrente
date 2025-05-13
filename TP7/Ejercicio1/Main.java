
package TP7.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        
        GestorSala gestor = new GestorSala(15,10,35);
        
        
        Thread[] personas = new Thread[20];
        
        Thread [] jubilados = new Thread[15];
        Thread gestorT = new Thread(new ControlTemperatura(gestor));
        
        gestorT.start();
        
        for (int i = 0; i < personas.length; i++) {
            personas[i] = new Thread(new Persona(gestor), "P"+i);
            personas[i].start();
            
        }
        
        
        for (int i = 0; i < jubilados.length; i++) {
            jubilados[i] = new Thread(new Jubilado(gestor), "J"+i);
            jubilados[i].start();
            
        }
        
        
        
        
        
        
    }
    
}
