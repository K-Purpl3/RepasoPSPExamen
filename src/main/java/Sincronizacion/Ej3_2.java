package Sincronizacion;

public class Ej3_2 {
    static void main(String[] args) throws InterruptedException {
        Contador contadorSinc = new Contador();

        Thread hilos [] = new Thread[100];

        //Hilos usan contador para incremntarlo
        for (int i = 0; i < 100; i ++){
            hilos[i] = new Thread(()->{
                for (int j = 0; j < 1000; j ++){
                    contadorSinc.incrementarSinc();
                }
            });
            hilos[i].start();
        }

        //Esperamos a que los hilos terminen
        for (Thread t : hilos){
            t.join();
        }

        System.out.println("Valor final: " + contadorSinc.getVal());
    }
}

