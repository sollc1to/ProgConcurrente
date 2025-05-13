/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ejercicio4;

/**
 *
 * @author PC
 */
public class Visitante implements Runnable {

    String nombre;
    int lugar;
    Area area;

    public Visitante(String unNombre, int lugar, Area area) {

        nombre = unNombre;
        this.lugar = lugar;
        this.area = area;
    }

    public void run() {

        area.reservarArea(this, lugar);

    }

    public String getNombre() {
        return this.nombre;
    }

}
