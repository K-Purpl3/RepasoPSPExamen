package Procesos;

import java.io.*;

public class Ej1_2 {
    static void main(String[] args) {
        try {
            File file = new File("resultado_ping.txt");

            // 1. Crear ProcessBuilder indicando comando y argumentos por separado.
            //    "ping -n 4 127.0.0.1"
            ProcessBuilder builder = new ProcessBuilder(
                    "ping", "-n", "4", "127.0.0.1"
            );

            // 2. Redirigir la salida estándar del proceso a un archivo.
            //    IMPORTANTE: debe configurarse ANTES de ejecutar start()
            if (file.exists()) {
                // Si ya existe -> añadimos al final
                builder.redirectOutput(ProcessBuilder.Redirect.appendTo(file));
            } else {
                // Si no existe -> lo creamos
                builder.redirectOutput(file);
            }

            // 3. Iniciar el proceso y obtener el objeto Process
            System.out.println("Ejecutando ping ...");
            Process process = builder.start();

            // 4. Esperamos a que termine y capturamos código de salida
            int codSalida = process.waitFor();
            if (codSalida == 0) {
                System.out.println("Ejecución correcta del programa");
            } else {
                System.err.println("Error en la ejecución. Código: " + codSalida);
            }

            // 5. Leemos el archivo generado por el comando ping
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line); // mostramos cada línea
            }

            reader.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
