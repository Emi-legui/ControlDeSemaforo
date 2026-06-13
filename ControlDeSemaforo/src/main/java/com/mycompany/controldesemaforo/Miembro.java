/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controldesemaforo;

/**
 *
 * @author Noxie-PC
 */
public class Miembro {
    private int id;
    private String nombre;
    private String puesto;
    private boolean libre; // Atributo extra requerido para testing

    public Miembro(int id, String nombre, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.libre = false; // Inicia ocupado trabajando
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }
}
