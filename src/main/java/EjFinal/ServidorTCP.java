package EjFinal;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorTCP {

    // Lista estática de sockets conectados -> para enviar mensajes a todos
    public static ArrayList<Socket> tabla = new ArrayList<>();

    static void main(String[] args) {

        // Creación del servidor en el puerto 5000
        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            File file = new File("log"); // archivo log (no se usa aquí directamente)

            // Bucle infinito -> el servidor nunca termina
            while (true) {

                System.out.println("Servidor esperando conexión...");

                // accept() bloquea hasta que un cliente se conecta
                Socket clienteSocket = serverSocket.accept();

                // Guardamos el socket del cliente en la lista
                tabla.add(clienteSocket);

                // Creamos un hilo para gestionar al cliente
                HiloServidor hilo = new HiloServidor(clienteSocket);
                hilo.start();  // Iniciamos el hilo
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
