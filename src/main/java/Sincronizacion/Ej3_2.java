package Sincronizacion;

public class Ej3_2 {
    static void main(String[] args) throws InterruptedException {

        Contador contadorSinc = new Contador();  // Contador compartido

        Thread hilos[] = new Thread[100];

        // Creamos 100 hilos
        for (int i = 0; i < 100; i++) {

            // Cada hilo incrementa 1000 veces usando el método sincronizado
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    contadorSinc.incrementarSinc();  // ✔️ método sincronizado
                }
            });

            hilos[i].start();
        }

        // Esperamos a que todos terminen
        for (Thread t : hilos) {
            t.join();
        }

        // Ahora sí: 100 * 1000 = 100000
        System.out.println("Valor final: " + contadorSinc.getVal());
    }
}
