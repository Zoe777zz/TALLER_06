package ArchivosCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CitaCSVReader {

    // carga un archivo csv y devuelve un arreglo de citas
    public static Cita[] cargar(String ruta) {

        ArrayList<Cita> lista = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {

            lector.readLine(); // se omite la linea de encabezado

            String linea;

            while ((linea = lector.readLine()) != null) {

                // se separan los datos usando ;
                String[] partes = linea.split(";");

                String id = partes[0];
                String fechaHora = partes[1];
                String motivo = partes[2];

                Cita c = new Cita(id, fechaHora, motivo);
                lista.add(c);
            }

        } catch (Exception e) {
            System.out.println("error al leer archivo " + ruta);
        }

        return lista.toArray(new Cita[0]);
    }
}
