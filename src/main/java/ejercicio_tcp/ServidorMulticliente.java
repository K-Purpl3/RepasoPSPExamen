package ejercicio_tcp;

import java.io.*;
import java.net.*;

public class ServidorMulticliente {

    public static void main(String[] args) throws IOException {

        // ServerSocket escucha conexiones entrantes en el puerto 12345
        ServerSocket ss = new ServerSocket(12345);
        System.out.println("Servidor multicliente iniciado.");

        // Bucle infinito para aceptar clientes continuamente
        while (true) {
            // accept() bloquea hasta que un cliente se conecta
            Socket socket = ss.accept();

            // Cada cliente se atiende en un hilo separado
            // Esto permite que múltiples clientes se conecten simultáneamente
            new Thread(new ClientHandler(socket)).start();
        }
    }
}