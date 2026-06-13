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
    private LocalDate fechaEfectivaReparacion; // Puede ser nula hasta que se repare
    private String detalle;

    public OrdenComposicion(String nroOrden, String detalle) {
        this.nroOrden = nroOrden;
        this.detalle = detalle;
        this.fechaRepProgramada = LocalDate.now();
        this.fechaEfectivaReparacion = null; // Nula al principio como pide el punto 3
    }

    public void setFechaEfectivaReparacion(LocalDate fecha) {
        this.fechaEfectivaReparacion = fecha;
    }

    public LocalDate getFechaEfectivaReparacion() {
        return fechaEfectivaReparacion;
    }

    public String getNroOrden() {
        return nroOrden;
    }
}
