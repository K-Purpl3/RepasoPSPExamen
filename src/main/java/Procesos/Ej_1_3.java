package Procesos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ej_1_3 {
    static void main(String[] args) {

        // Carpeta base donde buscaremos subdirectorios
        File file = new File("C:\\Users");

        // Comprobamos que exista
        if (!file.exists()) {
            System.err.println("No existe");
            return;
        }

        // Lista para almacenar todos los procesos lanzados
        List<Process> process = new ArrayList<>();

        // Recorremos todos los archivos dentro de C:\Users
        for (File file2 : file.listFiles()) {

            // ProcessBuilder para ejecutar "cmd /c dir <ruta>"
            ProcessBuilder processBuilder =
                    new ProcessBuilder("cmd", "/c", "dir", file2.getAbsolutePath());

            try {
                // Lanzamos el proceso
                Process p = processBuilder.start();
                process.add(p);

                System.out.println("Lanzado proceso para: " + file2.getName());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Esperamos a que todos los procesos finalicen
        for (Process p : process) {
            try {
                p.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Terminado");
    }
}
