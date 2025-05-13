
package TP5.Ejercicio5VER;

public class VendedorTickets implements Runnable{
    
    private Estacion estacion;
    
    
    public VendedorTickets(Estacion est){
        this.estacion = est;
    }
    
    
    public void run(){
        
        
        
        while(true){
            estacion.venderTicket();
        }
    }
    
    
}
