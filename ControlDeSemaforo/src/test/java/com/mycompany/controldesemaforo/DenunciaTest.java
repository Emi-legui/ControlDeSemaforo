/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.controldesemaforo;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author Noxie-PC
 */
public class DenunciaTest {
    
   // Variables de instancia globales para el entorno de pruebas (Punto 1)
    private GestionSemaforosService service;
    private Semaforo semaforoDefecto;

    // 1. Configuracion del Entorno de Pruebas (Ciclo de Vida)
    @BeforeEach
    public void setUp() {
        service = new GestionSemaforosService();
        semaforoDefecto = new Semaforo(101, "Smart LED");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Finalizacion de una prueba individual de control de semaforos.");
    }

    // 2. Prueba de Composicion Estricta (Semaforo y Luz)
    @Test
    public void testComposicionEstrictaSemaforoyLuz() {
        // Verifica que la lista de luces tenga un tamano igual a 3
        assertEquals(3, semaforoDefecto.getLuces().size());

        // Verifica mediante assertSame que la referencia en la posicion 0 sea la misma
        Luz luzPosicionCero = semaforoDefecto.getLuces().get(0);
        assertSame(luzPosicionCero, semaforoDefecto.getLuces().get(0));
    }

    // 3. Prueba de Robustez ante Duplicados (assertThrows y @Timeout)
    @Test
    @Timeout(value = 400, unit = TimeUnit.MILLISECONDS)
    public void testRobustezAnteDuplicadosYTimeout() {
        Denuncia denuncia = new Denuncia("DEN-001", "Foco rojo quemado", "Alta");
        OrdenComposicion orden1 = new OrdenComposicion("ORD-100", "Cambio de lampara");
        OrdenComposicion orden2 = new OrdenComposicion("ORD-200", "Revision general");

        // Asignamos la primera orden de manera habitual
        try {
            service.asignarOrden(denuncia, orden1);
        } catch (OrdenYaAsignadaException e) {
            fail("No deberia lanzar excepcion con la primera orden");
        }

        // Verifica que dispare OrdenYaAsignadaException al intentar asociar una segunda orden
        assertThrows(OrdenYaAsignadaException.class, () -> {
            service.asignarOrden(denuncia, orden2);
        });
    }

    // 4. Prueba de Flujo de Reparacion Exitoso (assertTrue y assertEquals)
    @Test
    public void testFlujoReparacionExitoso() {
        EquipoControl equipo = new EquipoControl("EQ-07", "Mantenimiento LED");
        
        // El responsable finaliza la reparacion (cambia estado y libera miembros)
        equipo.finalizarReparacion();

        // Comprobar que el estado del equipo cambio a "Libre"
        assertEquals("Libre", equipo.getEstado());

        // Recorrer la lista de los 4 miembros y validar que isLibre() sea verdadero
        assertEquals(4, equipo.getMiembros().size());
        for (Miembro miembro : equipo.getMiembros()) {
            assertTrue(miembro.isLibre());
        }
    }

    // 5. Prueba Parametrizada de Prioridades (@ParameterizedTest)
    @ParameterizedTest
    @ValueSource(strings = {"Alta", "Media", "Baja"})
    public void testPrioridadesValidas(String prioridadValida) {
        // Instancia una denuncia para cada prioridad del ValueSource
        Denuncia d = new Denuncia("DEN-TEMP", "Semaforo apagado", prioridadValida);
        
        // Verifica que retorne true para cada uno de los casos
        assertTrue(d.esPrioridadValida());
    }

    // 6. Prueba de Metricas Estadisticas e Historial (assertEquals)
    @Test
    public void testMetricasEstadisticasHistorial() {
        // Registramos 3 denuncias diferentes asociadas al mismo semaforo
        Denuncia d1 = new Denuncia("D1", "No cambia a verde", "Media");
        Denuncia d2 = new Denuncia("D2", "Optica rota", "Baja");
        Denuncia d3 = new Denuncia("D3", "Cuenta regresiva tildada", "Alta");

        semaforoDefecto.agregarDenuncia(d1);
        semaforoDefecto.agregarDenuncia(d2);
        semaforoDefecto.agregarDenuncia(d3);

        // Invocamos al metodo del servicio que calcula las estadisticas
        int resultadoDevuelto = service.calcularEstadisticasReparacion(semaforoDefecto);

        // Verificamos que el resultado sea exactamente 3
        assertEquals(3, resultadoDevuelto);
    }
    
}
