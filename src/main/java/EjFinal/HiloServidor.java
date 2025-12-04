package EjFinal;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;

public class HiloServidor extends Thread {

    // Flujo de entrada para leer lo que envía el cliente
    DataInputStream entrada;
    Socket socket = null;

    // Constructor: recibe el socket del cliente que se acaba de conectar
    public HiloServidor(Socket s) {
        socket = s;  // Guardamos el socket para este hilo

        try {
            // Obtenemos el flujo de entrada (datos enviados por el cliente)
            entrada = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.err.println("Error de entrada: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        // Archivo donde guardaremos los datos recibidos (log)
        File file = new File("log");
        String mensaje = "";

        // try-with-resources: cierra automáticamente los streams cuando termine
        try (
                // Convertimos DataInputStream -> BufferedReader para usar readLine()
                BufferedReader br = new BufferedReader(new InputStreamReader(entrada));

                // FileWriter en modo append (true) -> escribe al final del archivo
                FileWriter fw = new FileWriter(file, true)
        ) {

            // Mientras el cliente siga enviando líneas...
            while ((mensaje = br.readLine()) != null) {

                // Guardamos en el log: IP del cliente + mensaje
                fw.write(socket.getInetAddress() + ": " + mensaje + System.lineSeparator());
            }

        } catch (IOException e) {

            enviarMensaje("Error con el archivo log");
        }

        // Cuando el cliente termina, enviamos un mensaje a TODOS los clientes conectados
        enviarMensaje("Se ejecutó el comando y se ha guardado en el log");
    }

    // Envía un mensaje a TODOS los clientes conectados (broadcast)
    private void enviarMensaje(String mensajeToCliente) {

        // Recorremos la lista de sockets conectados que mantiene ServidorTCP
        var iterator = ServidorTCP.tabla.iterator();
        while (iterator.hasNext()) {
            try {
                Socket s = iterator.next();

                // Salida hacia el cliente
                DataOutputStream serverToClient = new DataOutputStream(s.getOutputStream());

                // Enviamos el mensaje
                serverToClient.writeUTF(mensajeToCliente);

            } catch (SocketException se) {
                System.err.println("Socket exception: " + se.getMessage());
            } catch (IOException e) {
                System.err.println("IO exception: " + e.getMessage());
            }
        }
    }
}
