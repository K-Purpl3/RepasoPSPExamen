package ejercicio_udp;

import java.net.*;

public class EmisorUDP {

    public static void main(String[] args) {

        try {
            // DatagramSocket SIN puerto -> el sistema asigna uno automáticamente
            // Es el socket desde el cual vamos a ENVIAR paquetes
            DatagramSocket socket = new DatagramSocket();

            // Mensaje que vamos a enviar
            String mensaje = "Hola desde el emisor UDP!";
            byte[] buffer = mensaje.getBytes();   // Convertimos a bytes (UDP trabaja con bytes)

            // Dirección IP a la que enviamos
            InetAddress ip = InetAddress.getByName("localhost");

            // Creamos un paquete UDP:
            //  - datos (buffer)
            //  - longitud del buffer
            //  - IP destino
            //  - puerto destino (12345)
            DatagramPacket packet =
                    new DatagramPacket(buffer, buffer.length, ip, 12345);

            // Enviamos el paquete por la red
            socket.send(packet);

            System.out.println("Mensaje UDP enviado.");

            // Cerramos el socket del emisor
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
