/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ejercicio1;

/**
 *
 * @author PC
 */
public class Cliente implements Runnable{
    GestorPiscina gestor;
    
    public Cliente(GestorPiscina gestor){
        this.gestor = gestor;
        
    }
    
    public void run(){
        
        gestor.quieroIngresarPiscina();
        
        
    }
    
}
