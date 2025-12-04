package Hilos;

public class Ej2 {
    static void main(String[] args) throws InterruptedException {

        int numHilos = 20;                 // Número de hilos que vamos a crear
        Thread[] threads = new Thread[numHilos];  // Array para guardarlos

        // Creamos e iniciamos los hilos
        for (int i = 0 ; i < numHilos; i++) {

            // Cada hilo ejecuta una instancia de TareaEj2 (Runnable)
            TareaEj2 tarea = new TareaEj2();
            threads[i] = new Thread(tarea);

            threads[i].start(); // Llama internamente al metodo run() del Runnable
        }

        // Esperamos a que los hilos terminen usando join()
        // IMPORTANTE: join() hace que el hilo MAIN espere a que cada uno termine
        for (int i = 1; i < numHilos; i++) {
            threads[i].join();
        }
    }
}
