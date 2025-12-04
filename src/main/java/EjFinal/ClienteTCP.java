package EjFinal;

import java.io.*;
import java.net.Socket;

public class ClienteTCP {

    static void main(String[] args) {

        // Creamos el socket y los streams necesarios
        try (
                Socket socket = new Socket("localhost", 5000);

                // Leer texto que escribe el usuario en consola
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                // Para enviar mensajes al servidor
                PrintWriter clienteToServidor = new PrintWriter(socket.getOutputStream(), true)
        ) {

            String comando;
            String comandoTrozos[];

            System.out.println("Conectando con el servidor...");

            System.out.println("Introduzca el comando que desea ejecutar:");

            // Leemos el comando que quiere ejecutar el usuario
            comando = reader.readLine();

            // Lo troceamos por espacios: ej. "ls -l" -> ["ls", "-l"]
            comandoTrozos = comando.split(" ");

            // Preparamos el proceso con ProcessBuilder
            ProcessBuilder processBuilder = new ProcessBuilder(comandoTrozos);

            // Ejecutamos el comando en el sistema
            Process process = processBuilder.start();

            // Leemos la salida del comando ejecutado
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // ---- HILO PARA ESCUCHAR MENSAJES DEL SERVIDOR ----
            new Thread(() -> {
                try {
                    // Para recibir mensajes del servidor
                    DataInputStream servidorToCliente = new DataInputStream(socket.getInputStream());

                    while (true) {
                        // Leemos mensajes enviados por HiloServidor
                        String msg = servidorToCliente.readUTF();
                        System.out.println(msg);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            // ----------------------------------------------------

            // Enviamos línea por línea la salida del comando al servidor
            String linea;
            while ((linea = br.readLine()) != null) {
                clienteToServidor.println(linea);
            }

        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
