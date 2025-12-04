package Hilos;

public class Ej2 {
    static void main(String[] args) throws InterruptedException {

        int numHilos = 20;
        Thread[] threads = new Thread[numHilos];

        // Creamos las instancias de los hilos, pasando la tarea a Runnable
        for (int i = 0 ; i < numHilos; i ++){
            TareaEj2 tarea = new TareaEj2();
            threads[i] = new Thread(tarea);
            threads[i].start(); //Invocamos al método run() de la tarea
        }

        // Esperamos a que los hilos terminen usando join().
        for (int i = 1; i < numHilos; i ++){
            threads[i].join();
        }
    }
}
