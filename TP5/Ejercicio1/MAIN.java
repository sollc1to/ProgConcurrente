
package TP5.Ejercicio1;

public class MAIN {
    
    
    public static void main(String[] args) {
        Piscina piscina = new Piscina();
        
        GestorPiscina gestor = new GestorPiscina(piscina);
        
        
        Thread[] clientes = new Thread[8];
        
        
        
        for (int i = 0; i < clientes.length; i++) {
            
            
            clientes[i] = new Thread(new Cliente(gestor), String.valueOf(i));
            clientes[i].start();
            
        }
        
    }
    
}
