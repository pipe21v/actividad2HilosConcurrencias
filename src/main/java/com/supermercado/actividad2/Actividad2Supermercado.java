package com.supermercado.actividad2;

import clase.Cajera;
import clase.Cliente;
import clase.Producto;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Luis Felipe
 */
public class Actividad2Supermercado {

    public static void main(String[] args) {
        // Crear productos
        Producto producto1 = new Producto("Manzana", 2000);
        Producto producto2 = new Producto("Pera", 1800);
        Producto producto3 = new Producto("Piña", 4500);
        Producto producto4 = new Producto("Banano", 600);
        Producto producto5 = new Producto("Sandia", 8000);
        Producto producto6 = new Producto("Melon", 5000);
        
        // Crear clientes y asignar productos
        Cliente cliente1 = new Cliente("Luis Felipe Ladino", Arrays.asList(producto5, producto2));
        Cliente cliente2 = new Cliente("Juan Esteban Gomez", Arrays.asList(producto3, producto1, producto6));
        Cliente cliente3 = new Cliente("Luz Elena Monsalve", Arrays.asList(producto2, producto1, producto5));
        Cliente cliente4 = new Cliente("Jose Luis Ladino", Arrays.asList(producto4, producto1, producto3));
        

        // Crear cajeras
        Cajera cajera1 = new Cajera("Pepita Perez");
        Cajera cajera2 = new Cajera("Pepito Perez");
        Cajera cajera3 = new Cajera("Juanita Diaz");

        // Crear lista de cajeras y clientes
        List<Cajera> cajeras = Arrays.asList(cajera1, cajera2, cajera3);
        List<Cliente> clientes = Arrays.asList(cliente1, cliente2, cliente3, cliente4);

        // Ejecutar la simulación con hilos
        ExecutorService executorService = Executors.newFixedThreadPool(cajeras.size());

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < cajeras.size(); i++) {
            executorService.execute(new EjecutarCajera(cajeras.get(i), clientes.get(i)));
        }

        // Cerrar el ExecutorService después de que todos los hilos hayan terminado
        executorService.shutdown();

        try {
            // Esperar a que todos los hilos terminen o esperar un tiempo límite
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Calcular tiempo total
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Tiempo total de cobro: " + totalTime + " milisegundos");
    }
}

