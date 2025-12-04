package ejercicio_tcp;

import java.io.*;
import java.net.*;

public class ClienteTCP {

    public static void main(String[] args) {
        // Creamos un Socket que se conecta al servidor en localhost:12345
        // Este constructor ya establece la conexión TCP
        try (Socket socket = new Socket("localhost", 12345)) {

            // PrintWriter -> para enviar datos al servidor
            // true -> autoflush (envía automáticamente después de println)
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true
            );

            // BufferedReader -> para leer la respuesta del servidor
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            // Enviamos un mensaje al servidor
            out.println("Hola desde el cliente TCP!");

            // Leemos la respuesta del servidor (readLine() bloquea hasta recibir algo)
            String respuesta = in.readLine();
            System.out.println("Servidor respondió: " + respuesta);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
