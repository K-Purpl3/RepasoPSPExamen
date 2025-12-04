package Hilos;

public class Ej2_2 {
    static void main(String[] args) {

         //Creamos lo 3 hilos
        Thread hiloMax = new Trabajador(785);
        Thread hiloMid = new Trabajador(982);
        Thread hiloMin = new Trabajador(1368);

        hiloMax.setName("Hilo max");
        hiloMid.setName("Hilo medio");
        hiloMin.setName("Hilo min");

        //Configuramos las prioridades
        hiloMax.setPriority(Thread.MAX_PRIORITY);
        hiloMid.setPriority(Thread.NORM_PRIORITY);
        hiloMin.setPriority(Thread.MIN_PRIORITY);

        //Ejecutar las tareas
        hiloMax.start();
        hiloMid.start();
        hiloMin.start();

    }
}
