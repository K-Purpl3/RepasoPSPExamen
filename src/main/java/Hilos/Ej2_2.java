package Hilos;

public class Ej2_2 {
    static void main(String[] args) {

        // Creamos 3 hilos con diferente tiempo de espera
        Thread hiloMax = new Trabajador(785);
        Thread hiloMid = new Trabajador(982);
        Thread hiloMin = new Trabajador(1368);

        // Les ponemos nombres descriptivos
        hiloMax.setName("Hilo max");
        hiloMid.setName("Hilo medio");
        hiloMin.setName("Hilo min");

        // Establecemos prioridades (máximo, normal, mínimo)
        hiloMax.setPriority(Thread.MAX_PRIORITY);   // valor 10
        hiloMid.setPriority(Thread.NORM_PRIORITY);  // valor 5
        hiloMin.setPriority(Thread.MIN_PRIORITY);   // valor 1

        // Iniciamos los hilos
        hiloMax.start();
        hiloMid.start();
        hiloMin.start();

        // NOTA IMPORTANTE:
        // La prioridad influye, pero NO garantiza el orden de ejecución.
    }
}
