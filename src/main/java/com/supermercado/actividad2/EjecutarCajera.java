package com.supermercado.actividad2;

import clase.Cajera;
import clase.Cliente;

/**
 *
 * @author Luis Felipe
 */
public class EjecutarCajera implements Runnable{
    private Cajera cajera;
    private Cliente cliente;

    public EjecutarCajera(Cajera cajera, Cliente cliente) {
        this.cajera = cajera;
        this.cliente = cliente;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();

        // Lógica de procesamiento de compra
        cajera.procesarCompra(cliente);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Tiempo de cobro para " + cliente.getNombre() + ": " + totalTime + " milisegundos");
    }
}

