package Procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej_1 {
    static void main(String[] args) {
        try {
            // 1. Obtener la instancia de Runtime
            Runtime runtime = Runtime.getRuntime();

            // 2. Elegir comando según sistema operativo
            String comando;

            if (System.getProperty("os.name").startsWith("Windows")) {
                comando = "powershell.exe Get-Date"; // Windows
            } else {
                comando = "date";                     // Linux/Mac
            }

            // 3. Ejecutamos el comando
            Process process = runtime.exec(comando);

            // 4. Capturamos la salida del comando (stdout)
            System.out.println("Salida del comando " + comando + ":");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            // 5. Esperamos a que el proceso acabe y verificamos el resultado
            int codSalida = process.waitFor();
            if (codSalida == 0) {
                System.out.println("\nComando ejecutado correctamente");
            } else {
                System.err.println("\nError al ejecutar. Código: " + codSalida);
            }

            reader.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
