package ejercicio_udp;

import java.net.*;

public class ReceptorUDP {

    public static void main(String[] args) {
        try {
            // DatagramSocket ASOCIADO al puerto 12345
            // Aquí llegarán los paquetes enviados
            DatagramSocket socket = new DatagramSocket(12345);

            // Buffer donde guardaremos el mensaje recibido
            byte[] buffer = new byte[1024];

            // Preparamos un paquete vacío para recibir datos
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("Receptor UDP esperando...");

            // Bloquea hasta que llegue un paquete
            socket.receive(packet);

            // Extraemos el mensaje del paquete
            String mensaje = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Mensaje recibido: " + mensaje);

            // Cerrar socket
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}