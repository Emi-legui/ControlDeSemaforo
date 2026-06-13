/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controldesemaforo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Noxie-PC
 */
public class EquipoControl {
    private String codigo;
    private String especialidad;
    private String estado; // Libre, Ocupado
    private List<Miembro> miembros;

    public EquipoControl(String codigo, String especialidad) {
        this.codigo = codigo;
        this.especialidad = especialidad;
        this.estado = "Ocupado";
        this.miembros = new ArrayList<>();
        
        // Inicializa con 4 miembros obligatorios como pide el enunciado
        miembros.add(new Miembro(1, "Juan Soler", "Responsable"));
        miembros.add(new Miembro(2, "Pedro Gomez", "Tecnico"));
        miembros.add(new Miembro(3, "Luis Perez", "Tecnico"));
        miembros.add(new Miembro(4, "Ana Lopez", "Asistente"));
    }

    public void finalizarReparacion() {
        this.estado = "Libre";
        for (Miembro m : miembros) {
            m.setLibre(true); // Pasa todos los miembros a true
        }
    }

    public String getEstado() {
        return estado;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }
}
