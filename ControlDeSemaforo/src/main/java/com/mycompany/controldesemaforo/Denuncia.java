/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controldesemaforo;

/**
 *
 * @author Noxie-PC
 */
public class Denuncia {
    // Atributos 
    private int id;
    private String descripcion;
    
    private OrdenComposicion ordenAsignada; 

    // Constructor
    public Denuncia(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.ordenAsignada = null; 
    }


    public void asignarOrden(OrdenComposicion orden) throws OrdenYaAsignadaException {
        if (this.ordenAsignada != null) {
            throw new OrdenYaAsignadaException("Orden ya asignada previamente");
        }
        this.ordenAsignada = orden;
    }

    // Getters y Setters 
    public OrdenComposicion getOrdenAsignada() {
        return ordenAsignada;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
