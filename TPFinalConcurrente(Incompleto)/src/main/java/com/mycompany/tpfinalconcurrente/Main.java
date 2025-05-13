/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpfinalconcurrente;

import java.util.concurrent.Exchanger;

/**
 *
 * @author PC
 */
public class Main {
    public static void main(String[] args) {
        
        ParqueDiversiones parque = new ParqueDiversiones();
        
        Thread reloj = new Thread(new Reloj(parque));
        reloj.start();
        Exchanger <String> cambiar = new Exchanger();
        
        Thread visitante = new Thread(new Visitante(parque,cambiar));
        Thread encargado = new Thread(new Empleado(parque,cambiar));
        
        visitante.start();encargado.start();
        
        
        
        
        
    }
    
}
