
package TP5.Ejercicio2;

public class Mozo implements Runnable{
    Bar bar;
    
    public Mozo(Bar bar){
        this.bar = bar;
        
        
        
    }
    
    public void run(){
        
        while(true){
            
            
            bar.servir();
            
            
            
            
        }
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
