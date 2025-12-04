package Hilos;

public class Ej2_3 {
    static void main(String[] args) throws InterruptedException {

        // Creamos 3 hilos con diferentes velocidades
        Thread hilo1 = new Trabajador(575);
        Thread hilo2 = new Trabajador(1500);
        Thread hilo3 = new Trabajador(2000);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        // join(3000) → el MAIN solo esperará 3 segundos por cada hilo
        // Si un hilo tarda más, el MAIN seguirá sin esperarle.

        hilo1.join(3000);
        hilo2.join(3000);
        hilo3.join(3000);

        // Esto es útil para evitar bloqueos o tiempos de espera infinitos.
    }
}
