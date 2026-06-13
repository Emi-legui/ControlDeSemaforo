/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controldesemaforo;

/**
 *
 * @author Noxie-PC
 */
public class Luz {
    private String nroSerie;
    private String empresaFabricadora;
    private String tipo;
    private String color;

    public Luz(String nroSerie, String color) {
        this.nroSerie = nroSerie;
        this.color = color;
        this.empresaFabricadora = "Fabrica Generica";
        this.tipo = "LED";
    }

    public String getColor() {
        return color;
    }
}
