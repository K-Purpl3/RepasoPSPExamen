package Hilos;

public class Ej2_3 {
    static void main(String[] args) throws InterruptedException {
        //Creamos los hilos
        Thread hilo1 = new Trabajador(575);
        Thread hilo2 = new Trabajador(1500);
        Thread hilo3 = new Trabajador(2000);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        //Le decimos al hilo en cuanto tiempo debe terminar
        hilo1.join(3000);
        hilo2.join(3000);
        hilo3.join(3000);
    }
}
