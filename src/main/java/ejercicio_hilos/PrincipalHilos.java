package ejercicio_hilos;

public class PrincipalHilos {

    public static void main(String[] args) {

        CuentaBancaria cuenta = new CuentaBancaria(10);

        // Cada hilo ejecutará el metodo run() de Cliente
        Thread c1 = new Thread(new Cliente(cuenta, "Cliente 1", 5));
        Thread c2 = new Thread(new Cliente(cuenta, "Cliente 2", 5));
        Thread c3 = new Thread(new Cliente(cuenta, "Cliente 3", 5));

        // Iniciamos los hilos (empiezan en paralelo)
        c1.start();
        c2.start();
        c3.start();
    }
}
