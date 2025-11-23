package ArchivosCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class InventarioCSVReader {

    // carga un archivo csv y devuelve un arreglo de inventarios
    public static Inventario[] cargar(String ruta) {

        ArrayList<Inventario> lista = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(ruta))) {

            lector.readLine(); // omitir encabezado
            String linea;

            while ((linea = lector.readLine()) != null) {

                String[] partes = linea.split(";");

                String id = partes[0];
                String nombre = partes[1];
                int cantidad = Integer.parseInt(partes[2]);

                Inventario it = new Inventario(id, nombre, cantidad);
                lista.add(it);
            }

        } catch (Exception e) {
            System.out.println("error al leer archivo " + ruta);
        }

        return lista.toArray(new Inventario[0]);
    }
}
