/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progconcurrente;

public class CajeroThread extends Thread {

    private String nombre;
    private ClienteThread[] ArrCliente;
    private long initialTime;
// Constructor, y métodos de acceso

    public CajeroThread(String nombre, ClienteThread[] cliente, long tiempo) {
        this.nombre = nombre;

        this.ArrCliente = cliente;
        this.initialTime = tiempo;

    }

    public void run() {
        int j = 0;
        ClienteThread cliente = null;

        while (this.ArrCliente[j] != null) {
            cliente = this.ArrCliente[j];
            System.out.println("El cajero " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                    + cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
            for (int i = 0; i < cliente.getCarroCompra().length; i++) {
                this.esperarXSegundos(cliente.getCarroCompra()[i]);
                System.out.println("Procesado el producto " + (i + 1) + "del cliente " + cliente.getNombre()
                        + "->Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
            }
            System.out.println("El cajero" + this.nombre + "HA TERMINADO DE PROCESAR " + cliente.getNombre() + " EN EL TIEMPO: "
                    + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
            j++;
        }//Agrego un arreglo en caso de q un cajero quiera atender a varios clientes. 
    }

    private void esperarXSegundos(int segundos) {

        try {
            Thread.sleep(segundos*1000);
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido");

        }

    }

}
