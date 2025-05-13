/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ejercicio4;

/**
 *
 * @author PC
 */
public class Area {

    Visitante[] espacioDisponible;

    public Area(int tamañoParque) {

        espacioDisponible = new Visitante[tamañoParque];

    }

    public void reservarArea(Visitante visitante, int indice) {

        if (espacioDisponible[indice] == null) {
            espacioDisponible[indice] = visitante;
            System.out.println("Visitante " + visitante.getNombre()+ "Reservó el area" + indice);

        } else {

            System.out.println("No hay espacio disponible..");

        }

    }

    public String toString() {
        String cadena = "";

        for (int i = 0; i < 10; i++) {
            if (espacioDisponible[i] != null) {
                cadena = cadena + espacioDisponible[i].getNombre();

            }else{
                
                cadena = cadena + "null";
            }

        }
        
        return cadena;

    }

}
