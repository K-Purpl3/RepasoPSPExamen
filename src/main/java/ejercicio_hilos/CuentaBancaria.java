package ejercicio_hilos;

public class CuentaBancaria {
    private int saldo;

    public CuentaBancaria(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Metodo sincronizado -> solo 1 hilo puede entrar aquí a la vez

    // Esto evita una condición de carrera al modificar el saldo

    public synchronized void retirar(String nombre, int cantidad) {
        System.out.println(nombre + " intenta retirar " + cantidad);

        // Comprobamos si hay saldo suficiente
        if (saldo >= cantidad) {

            // Simulamos un retardo típico de una operación bancaria
            // para forzar que dos hilos intenten entrar a la vez
            try { Thread.sleep(200); } catch (InterruptedException e) {}

            // Operación crítica: modificar saldo
            saldo -= cantidad;

            System.out.println(" -> " + nombre + " retiró " + cantidad +
                    " | Saldo restante: " + saldo);
        } else {
            // No hay suficiente dinero
            System.out.println(" -> No hay suficiente saldo para " + nombre);
        }
    }
}
