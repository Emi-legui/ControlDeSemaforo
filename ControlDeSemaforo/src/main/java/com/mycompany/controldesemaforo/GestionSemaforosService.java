/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controldesemaforo;

/**
 *
 * @author Noxie-PC
 */
public class GestionSemaforosService {
    // Metodo de negocio para asociar orden a denuncia
    public void asignarOrden(Denuncia denuncia, OrdenComposicion orden) throws OrdenYaAsignadaException {
        denuncia.asignarOrden(orden);
    }

    // Metodo de negocio para el historial estadistico
    public int calcularEstadisticasReparacion(Semaforo semaforo) {
        return semaforo.getHistoricoDenuncias().size();
    }
}
