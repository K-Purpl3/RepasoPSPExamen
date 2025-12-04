package Sincronizacion;

public class Contador {
    private int val = 0;

    //Al no poner la synchronized los hilos acceden de forma desordenada a la variable val, haciendo que el resultado no sea el esperado
    public void incrementar(){
        val ++;
    }

    //Sincronizamos el acceso a la variable val, de manera que no se pisan los hilos
    public synchronized void incrementarSinc(){
        val ++;
    }

    public int getVal(){
        return val;
    }
}
