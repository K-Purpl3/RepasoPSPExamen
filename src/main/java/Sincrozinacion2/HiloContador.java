package Sincrozinacion2;


public class HiloContador extends Thread {
    private Contador contador;
    private int repeticiones;
    private boolean usarSincronizacion;

    public HiloContador(Contador contador, int repeticiones, boolean usarSincronizacion) {
        this.contador = contador;
        this.repeticiones = repeticiones;
        this.usarSincronizacion = usarSincronizacion;
    }

    @Override
    public void run() {
        for (int i = 0; i < repeticiones; i++) {
            if (usarSincronizacion) {
                contador.incrementarSinc();
            } else {
                contador.incrementar();
            }
        }
    }
}