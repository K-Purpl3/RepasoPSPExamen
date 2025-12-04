package Sincrozinacion2;

public
class Contador {
    private int valor = 0;

    // Incremento sin sincronización: puede dar resultados incorrectos con varios hilos
    public void incrementar() {
        valor++;
    }

    // Incremento sincronizado: garantiza que solo un hilo acceda a la vez
    public synchronized void incrementarSinc() {
        valor++;
    }

    public int getValor() {
        return valor;
    }
}