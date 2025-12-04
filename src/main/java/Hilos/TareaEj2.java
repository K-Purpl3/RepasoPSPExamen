package Hilos;

public class TareaEj2 implements Runnable {

    @Override
    public void run() {

        // Cada hilo cuenta hasta 10
        for (int i = 1; i <= 10; i++) {

            // Mostramos el ID del hilo y el contador
            System.out.println("Hilo " + Thread.currentThread().getId() +
                    ": Contador " + i);

            try {
                // Simulamos trabajo durmiendo entre 200 y 800 ms
                Thread.sleep((int)(Math.random() * (800 - 200 + 1) + 200));
            } catch (InterruptedException e) {
                // Si nos interrumpen, dejamos el hilo marcado como interrumpido
                Thread.currentThread().interrupt();
            }
        }
    }
}
