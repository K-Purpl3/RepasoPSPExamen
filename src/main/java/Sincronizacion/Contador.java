package Sincronizacion;

public class Contador {
    private int val = 0;   // Variable compartida entre muchos hilos

    // ❌ Método SIN sincronizar
    // Varios hilos pueden entrar a la vez y modificar 'val' al mismo tiempo.
    // Esto provoca condiciones de carrera -> resultados incorrectos.
    public void incrementar() {
        val++;
    }

    // ✔️ Método sincronizado
    // Solo un hilo puede ejecutar este método al mismo tiempo.
    // Garantiza consistencia del valor.
    public synchronized void incrementarSinc() {
        val++;
    }

    // Método para obtener el valor final
    public int getVal() {
        return val;
    }
}
