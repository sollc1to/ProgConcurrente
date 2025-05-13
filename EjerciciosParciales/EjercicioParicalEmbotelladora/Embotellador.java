/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioParicalEmbotelladora;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author PC
 */
public class Embotellador implements Runnable{
    PlantaEmbotelladora planta;
    Random random = new Random();
    boolean tipo = random.nextBoolean();
    
    public Embotellador(PlantaEmbotelladora p){
        this.planta = p;
        
        
    }
    public void run(){
        
        
           try {
               
               
                if (tipo) {
                        
                    planta.iniciarEmbotelladoAgua();
                      Thread.sleep((int) (Math.random() * 2500));
                      planta.terminarEmbotelladoAgua();
           
         
            
                }else{
                        
                    planta.iniciarEmbotelladoVino();
                      Thread.sleep((int) (Math.random() * 3000));
                      planta.terminarEmbotelladoVino();
           
                    
                }
              
            } catch (InterruptedException ex) {
                Logger.getLogger(Embotellador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        
        
        
    }
    
}
