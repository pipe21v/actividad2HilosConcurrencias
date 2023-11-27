package clase;

import java.util.List;

/**
 *
 * @author Luis Felipe
 */
public class Cajera implements Runnable {
   private String nombre;

    public Cajera(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // método para procesar comprar
    public void procesarCompra(Cliente cliente) {
        System.out.println(nombre + " está procesando la compra de " + cliente.getNombre());

        List<Producto> productos = cliente.getProductos();

        for (Producto producto : productos) {
            System.out.println("Escaneando producto: " + producto.getNombre());
            // Aquí simplemente imprimimos información sobre el producto.
            try {
                // aqui simulamos el tiempo de procesamiento de cada producto
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        double costoTotal = calcularCostoTotal(productos);
        System.out.println("Costo total de la compra: $" + costoTotal);
    }

    // Método para calcular el costo total de la compra
    private double calcularCostoTotal(List<Producto> productos) {
        double costoTotal = 0;
        for (Producto producto : productos) {
            costoTotal += producto.getPrecio();
        }
        return costoTotal;
    }

    // Método run del hilo
    @Override
    public void run() {
    }
   
}
