/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progconcurrente;

/**
 *
 * @author PC
 */
public class ClienteThread {

    private String nombre;
    private int[] carroCompra;
// Constructor y métodos de acceso

    public ClienteThread(String nombre, int[] carro) {

        this.nombre = nombre;
        this.carroCompra = carro;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCarroCompra(int[] carroCompra) {
        this.carroCompra = carroCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getCarroCompra() {
        return carroCompra;
    }

}
