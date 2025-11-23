package ArchivosCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class PacienteCSVReader {

    // carga un archivo csv y devuelve un arreglo de pacientes
    public static Paciente[] cargar(String ruta) {

        ArrayList<Paciente> lista = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {

            lector.readLine(); // omitir encabezado
            String linea;

            while ((linea = lector.readLine()) != null) {

                String[] partes = linea.split(";");

                String id = partes[0];
                String nombre = partes[1];
                int edad = Integer.parseInt(partes[2]);

                Paciente p = new Paciente(id, nombre, edad);
                lista.add(p);
            }

        } catch (Exception e) {
            System.out.println("error al leer archivo " + ruta);
        }

        return lista.toArray(new Paciente[0]);
    }
}
