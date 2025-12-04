package ejercicio_tcp;

import java.io.*;
import java.net.*;

public class ServidorTCP {

    public static void main(String[] args) {
        // ServerSocket escucha en el puerto 12345
        try (ServerSocket ss = new ServerSocket(12345)) {
            System.out.println("Servidor TCP esperando...");

            // accept() bloquea hasta que un cliente se conecta
            Socket socket = ss.accept();
            System.out.println("Cliente conectado.");

            // Flujo para leer lo que envía el cliente
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            // Flujo para enviar datos al cliente
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true
            );

            // Leemos el mensaje del cliente
            String mensaje = in.readLine();
            System.out.println("Recibido: " + mensaje);

            // Enviamos una respuesta
            out.println("Mensaje recibido por el servidor.");

            // Cerramos el socket del cliente
            socket.close();
            System.out.println("Conexión cerrada.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
