package ejercicio_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// Esta clase se ejecuta en un hilo separado para cada cliente.
// Permite que el servidor atienda múltiples clientes simultáneamente.
class ClientHandler implements Runnable {

    private Socket socket;

    public ClientHandler(Socket socket) {
        // Guardamos el socket asociado a este cliente
        this.socket = socket;
    }

    @Override
    public void run() {
        // try-with-resources permite cerrar los flujos automáticamente
        try (
                // Flujo para leer lo que envía el cliente
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );

                // Flujo para escribir de vuelta al cliente
                PrintWriter out = new PrintWriter(
                        socket.getOutputStream(), true
                )
        ) {
            String linea;

            // Bucle que lee líneas mientras el cliente siga conectado
            // readLine() devuelve null si el cliente se desconecta
            while ((linea = in.readLine()) != null) {
                System.out.println("Cliente dijo: " + linea);

                // Enviamos eco (respuesta) al cliente
                out.println("Eco: " + linea);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}