/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controldesemaforo;

import java.time.LocalDate;

/**
 *
 * @author Noxie-PC
 */
public class OrdenComposicion {
    private String nroOrden;
    private LocalDate fechaRepProgramada;
    private String detalle;

    // Constructor 
    public OrdenComposicion(String nroOrden, String detalle) {
        this.nroOrden = nroOrden;
        this.detalle = detalle;
        this.fechaRepProgramada = LocalDate.now();
    }

    // Getters y Setters
    public String getNroOrden() {
        return nroOrden;
    }

    public String getDetalle() {
        return detalle;
    }
}
