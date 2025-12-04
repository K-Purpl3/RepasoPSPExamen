package Hilos;

public class Trabajador extends Thread {

    private int esperar;   // Tiempo de espera entre iteraciones

    public Trabajador(int esperar) {
        this.esperar = esperar;
    }

    @Override
    public void run() {

        // Cada hilo imprime 3 contadores
        for (int i = 1; i <= 3; i++) {
            System.out.println("Hilo " + Thread.currentThread().getId() +
                    ": Contador " + i);

            try {
                Thread.sleep(esperar);  // Simula una tarea que tarda X ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
