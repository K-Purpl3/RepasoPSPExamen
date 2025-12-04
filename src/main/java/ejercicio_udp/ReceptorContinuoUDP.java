package ejercicio_udp;

import java.net.*;

public class ReceptorContinuoUDP {

    public static void main(String[] args) {
        try {
            // Socket escuchando el puerto 12345
            DatagramSocket socket = new DatagramSocket(12345);
            byte[] buffer = new byte[1024];

            System.out.println("Receptor UDP continuo iniciado...");

            // Bucle infinito para recibir múltiples mensajes
            while (true) {

                // Crear un DatagramPacket para recibir los datos
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // Esperamos un paquete (método bloqueante)
                socket.receive(packet);

                // Convertimos el contenido en String
                String mensaje = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Recibido: " + mensaje);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}