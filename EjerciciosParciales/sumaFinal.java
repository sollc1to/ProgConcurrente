/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

/**
 *
 * @author PC
 */
public class sumaFinal {
    
    int suma;
    
    public sumaFinal(){
        suma = 0;
    }
    
    public synchronized void agregarCantidad(int sumaParcial){
        
        System.out.println("Suma final " + suma + " suma parcial: " + sumaParcial);
        suma = suma + sumaParcial;
        
        System.out.println("Suma final total " + suma);
    }
    
    public int sumaFinal(){
        
        return suma;
    }
    
    
}
