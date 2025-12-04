package Procesos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ej_1_3 {
    static void main(String[] args) {
        File file = new File("C:\\Users");

        //Comprobamos que user existe
        if (!file.exists()){
            System.err.println("No existe");
        }

        // Creamos una lista de proceseos
        List<Process> process = new ArrayList<>();

        for (File file2 : file.listFiles()){
            ProcessBuilder processBuilder;

            processBuilder = new ProcessBuilder("cmd","/c","dir",file2.getAbsolutePath());


            try {
                //Lanzar proceso
                Process p = processBuilder.start();
                process.add(p);
                System.out.println("Lanzar proceso para: "+file2.getName());
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        for (Process p : process){
            try {
                p.waitFor();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("Terminado");
    }
}
