package Procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej_1 {
    static void main(String[] args) {
        try{
            // 1. Obtenemos la instancia de Runtime
            Runtime runtime = Runtime.getRuntime();

            // 2. Para obtener la fecha en windows / ubuntu
            String comando;
            if (System.getProperty("os.name").startsWith("Windows")){
                comando = "powershell.exe Get-Date";
            }else {
                comando = "date";
            }
            Process process = runtime.exec(comando);

            // 3. Capturar la salida estandar
            System.out.println("Salida del comando "+comando+":");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linea;

            while ((linea = reader.readLine()) != null){
                System.out.println(linea);
            }

            // 4. Esparar a que termine el proceso
            int codSalida = process.waitFor();
            if (codSalida == 0){
                System.out.println("\nComando ejecutado correctamente");
            }else {
                System.err.println("\nError en la ejecucion del comando. Código de error: "+codSalida);
            }

            reader.close();

        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}