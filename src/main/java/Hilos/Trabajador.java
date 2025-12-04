package Hilos;

public class Trabajador extends Thread{
    private int esperar;
    public Trabajador(int esperar){
        this.esperar = esperar;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++){
            System.out.println("Hilo "+Thread.currentThread().getId() +": Contador " + i);
            try {
                Thread.sleep(esperar); // Simula el tiempo de la tarea
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
