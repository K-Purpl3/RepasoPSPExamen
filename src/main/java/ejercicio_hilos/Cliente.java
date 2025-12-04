package ejercicio_hilos;

public class Cliente implements Runnable {

    // Cada cliente tiene acceso a la misma cuenta compartida
    private CuentaBancaria cuenta;
    private String nombre;
    private int cantidad;

    // Constructor: se asigna la cuenta, nombre y cantidad a retirar
    public Cliente(CuentaBancaria cuenta, String nombre, int cantidad) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    // El metodo run() es lo que ejecutará el hilo cuando se active
    @Override
    public void run() {
        // Se llama al metodo sincronizado de la cuenta
        cuenta.retirar(nombre, cantidad);
    }
}
