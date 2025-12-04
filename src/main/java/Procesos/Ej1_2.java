package Procesos;

import java.io.*;

public class Ej1_2 {
    static void main(String[] args) {
        try {
            File file = new File("resultado_ping.txt");

            // 1. Crear una instancia de Proceses builder, separamos el comando de los argumentos
            ProcessBuilder builder = new ProcessBuilder("ping","-n","4","127.0.0.1");

            // 2. Redirigimos la salida a un archivo, es importante antes de iniciar el proceso dejarlo configurado
            if (file.exists()){
                builder.redirectOutput(ProcessBuilder.Redirect.appendTo(file)); //Permitimos que si el achivo existe se escriba en la lina de abajo
            }else {
                builder.redirectOutput(file);
            }

            // 3. Iniciar el proceso. Esto devuelve un objeto Process
            System.out.println("Ejecutando ping ...");
            Process process = builder.start(); // Le pasamos al process el objeto process del processBuilder

            // 4. Caputarmos el código de salida
            int codSalida = process.waitFor();
            if (codSalida == 0){
                System.out.println("Ejecución correcta de el programa");
            }else {
                System.err.println("Error de ejecución. Código de error: "+codSalida);
            }

            BufferedReader reader = new BufferedReader(new FileReader(file)); // Usamos FileReader para leer los archivos
            String line;
            while ( (line = reader.readLine()) != null ) {
                System.out.println(line);
            }

            //Cerramos el reader al terminar
            reader.close();
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
