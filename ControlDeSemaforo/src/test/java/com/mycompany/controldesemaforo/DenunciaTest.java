/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.controldesemaforo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Noxie-PC
 */
public class DenunciaTest {
    
   @Test
    public void testAsignarOrdenExcepcionSiYaTieneOrden() {
        // 1. Escenario (Arrange): Creamos la denuncia y dos ordenes de reparacion
        Denuncia denuncia = new Denuncia(1, "Semaforo de Av. Illia intermitente");
        OrdenComposicion orden1 = new OrdenComposicion("ORD-001", "Revision de focos LED");
        OrdenComposicion orden2 = new OrdenComposicion("ORD-002", "Cambio de plaqueta");

        // 2. Ejecucion parcial: Asignamos la primera orden sin problemas
        try {
            denuncia.asignarOrden(orden1);
        } catch (OrdenYaAsignadaException e) {
            fail("No deberia lanzar excepcion al asignar la primera orden");
        }

        // 3. Verificacion (Assert): Intentamos asignar una segunda orden y verificamos la excepcion
        assertThrows(OrdenYaAsignadaException.class, () -> {
            denuncia.asignarOrden(orden2);
        });
    }
}
