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
public class Denuncia {
   private String codD;
    private LocalDate fechaDenuncia;
    private String calleX;
    private String calleY;
    private String problema;
    private String prioridad; 
    private OrdenComposicion ordenAsignada;

    public Denuncia(String codD, String problema, String prioridad) {
        this.codD = codD;
        this.problema = problema;
        this.prioridad = prioridad;
        this.fechaDenuncia = LocalDate.now();
        this.ordenAsignada = null;
    }

    public void asignarOrden(OrdenComposicion orden) throws OrdenYaAsignadaException {
        if (this.ordenAsignada != null) {
            throw new OrdenYaAsignadaException("Orden ya asignada previamente");
        }
        this.ordenAsignada = orden;
    }

    // Metodo necesario para el Punto 5 del Testing
    public boolean esPrioridadValida() {
        return "Alta".equals(prioridad) || "Media".equals(prioridad) || "Baja".equals(prioridad);
    }

    public OrdenComposicion getOrdenAsignada() {
        return ordenAsignada;
    }

    public String getCodD() {
        return codD;
    }
}
