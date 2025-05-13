/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ejercicio4;

/**
 *
 * @author PC
 */
public class Cliente implements Runnable {

    GestorImpresoras gestor;
    public Cliente(GestorImpresoras gestor) {
        this.gestor = gestor;

    }

    public void run(){
        gestor.quieroImprimir();
      
        
        

    }

}
