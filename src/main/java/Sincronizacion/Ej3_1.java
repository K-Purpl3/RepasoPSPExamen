package Sincronizacion;

public class Ej3_1 {
    static void main(String[] args) throws InterruptedException {

        Contador contador = new Contador();  // Contador compartido

        Thread hilos[] = new Thread[100];

        // Creamos 100 hilos
        for (int i = 0; i < 100; i++) {

            // Cada hilo incrementa 1000 veces SIN sincronización
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    contador.incrementar();   // ❌ método NO sincronizado
                }
            });

            hilos[i].start(); // Iniciamos el hilo
        }

        // Esperamos a que todos los hilos acaben
        for (Thread t : hilos) {
            t.join();
        }

        // Teóricamente debería ser 100 * 1000 = 100000
        // PERO saldrá menos porque hay condiciones de carrera
        System.out.println("Valor final: " + contador.getVal());
    }
}
