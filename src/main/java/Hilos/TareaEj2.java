package Hilos;

public class TareaEj2 implements Runnable{
    @Override
    public void run() {
        //Codigo del hilo
        for (int i = 1; i <= 10; i++){
            System.out.println("Hilo "+Thread.currentThread().getId() +": Contador " + i);
            try {
                Thread.sleep((int)(Math.random() * (800 - 200 + 1) + 200)); // Simula el tiempo de la tarea
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

}
