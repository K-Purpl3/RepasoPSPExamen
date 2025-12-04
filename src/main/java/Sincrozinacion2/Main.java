package Sincrozinacion2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();
        int repeticiones = 100_000;

        // Creamos varios hilos que incrementan el contador
        Thread hilo1 = new HiloContador(contador, repeticiones, false);
        Thread hilo2 = new HiloContador(contador, repeticiones, false);

        hilo1.start();
        hilo2.start();

        // Esperamos a que terminen
        hilo1.join();
        hilo2.join();

        System.out.println("Valor final sin sincronización: " + contador.getValor());

        // Ahora con sincronización
        Contador contadorSinc = new Contador();
        Thread hilo3 = new HiloContador(contadorSinc, repeticiones, true);
        Thread hilo4 = new HiloContador(contadorSinc, repeticiones, true);

        hilo3.start();
        hilo4.start();

        hilo3.join();
        hilo4.join();

        System.out.println("Valor final con sincronización: " + contadorSinc.getValor());
    }
}