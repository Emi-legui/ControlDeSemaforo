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
public class Semaforo {
    private int nro;
    private String estado;
    private String ubicacion;
    private String tipoFaro; // Basic LED o Smart LED
    
    // Atributos extra para Testing 
    private List<Luz> luces;
    private List<Denuncia> historicoDenuncias;

    public Semaforo(int nro, String tipoFaro) {
        this.nro = nro;
        this.tipoFaro = tipoFaro;
        this.estado = "Descompuesto";
        this.luces = new ArrayList<>();
        this.historicoDenuncias = new ArrayList<>();
        
        // Composicion estricta: Se crean las 3 luces en conjunto con el semaforo
        luces.add(new Luz("SERIE-" + nro + "-R", "Rojo"));
        luces.add(new Luz("SERIE-" + nro + "-A", "Amarillo"));
        luces.add(new Luz("SERIE-" + nro + "-V", "Verde"));
    }

    public List<Luz> getLuces() {
        return luces;
    }

    public List<Denuncia> getHistoricoDenuncias() {
        return historicoDenuncias;
    }

    public void agregarDenuncia(Denuncia d) {
        this.historicoDenuncias.add(d);
    }

    public int getNro() {
        return nro;
    }
}
