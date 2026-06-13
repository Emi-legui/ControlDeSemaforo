/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.controldesemaforo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Noxie-PC
 */
public class DenunciaTest {
    
    public DenunciaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of asignarOrden method, of class Denuncia.
     */
    @Test
    public void testAsignarOrden() throws Exception {
        System.out.println("asignarOrden");
        OrdenComposicion orden = null;
        Denuncia instance = null;
        instance.asignarOrden(orden);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esPrioridadValida method, of class Denuncia.
     */
    @Test
    public void testEsPrioridadValida() {
        System.out.println("esPrioridadValida");
        Denuncia instance = null;
        boolean expResult = false;
        boolean result = instance.esPrioridadValida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrdenAsignada method, of class Denuncia.
     */
    @Test
    public void testGetOrdenAsignada() {
        System.out.println("getOrdenAsignada");
        Denuncia instance = null;
        OrdenComposicion expResult = null;
        OrdenComposicion result = instance.getOrdenAsignada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCodD method, of class Denuncia.
     */
    @Test
    public void testGetCodD() {
        System.out.println("getCodD");
        Denuncia instance = null;
        String expResult = "";
        String result = instance.getCodD();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
