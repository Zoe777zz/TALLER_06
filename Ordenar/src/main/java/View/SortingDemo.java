package View;

import ArchivosCSV.Cita;
import ArchivosCSV.CitaCSVReader;
import ArchivosCSV.Paciente;
import ArchivosCSV.PacienteCSVReader;
import ArchivosCSV.Inventario;
import ArchivosCSV.InventarioCSVReader;

import AlgoritmosOrdenacion.BubbleSort;
import AlgoritmosOrdenacion.InsertionSort;
import AlgoritmosOrdenacion.SelectionSort;

import java.util.Arrays;

public class SortingDemo {

    // interfaz funcional usada para ejecutar un algoritmo generico

    @FunctionalInterface
    interface SortExecutor<E> {
        E run(Object[] data);
    }

    // ejecuta un algoritmo 10 veces sobre copias del dataset para obtener estabilidad
    // luego ordena los tiempos y retorna la mediana como valor representativo
    private static <E> E ejecutarPruebas(Object[] original, SortExecutor<E> executor) {

        E[] resultados = (E[]) new Object[10]; // almacena los resultados de cada ejecucion

        for (int r = 0; r < 10; r++) {

            // se copia el arreglo original para no modificar los datos
            Object[] copia = Arrays.copyOf(original, original.length);

            // se ejecuta el algoritmo de ordenacion sobre la copia
            resultados[r] = executor.run(copia);
        }

        // se ordenan los resultados segun el tiempo registrado por cada algoritmo
        Arrays.sort(resultados, (a, b) -> {
            try {
                long t1 = (long) a.getClass().getField("timeNs").get(a);
                long t2 = (long) b.getClass().getField("timeNs").get(b);
                return Long.compare(t1, t2);
            } catch (Exception e) {
                return 0;
            }
        });

        return resultados[3]; // retorna la mediana
    }

    // metodo principal donde inicia la ejecucion
    public static void main(String[] args) {

        // la leyenda se imprime solo una vez al inicio
        imprimirLeyenda();

        // carga de archivos csv dentro de la carpeta archivos
        Cita[] citas100 = CitaCSVReader.cargar("archivos/citas_100.csv");
        Cita[] citasOrd = CitaCSVReader.cargar("archivos/citas_100_casi_ordenadas.csv");
        Paciente[] pacientes500 = PacienteCSVReader.cargar("archivos/pacientes_500.csv");
        Inventario[] inv500 = InventarioCSVReader.cargar("archivos/inventario_500_inverso.csv");

        // ejecucion de los algoritmos en cada dataset
        ejecutarDataset("citas 100", citas100);
        ejecutarDataset("citas 100 casi ordenadas", citasOrd);
        ejecutarDataset("pacientes 500", pacientes500);
        ejecutarDataset("inventario 500 inverso", inv500);
    }

    // ejecuta bubble insertion y selection sobre un dataset y muestra los resultados en tabla
    public static void ejecutarDataset(String titulo, Object[] data) {

        System.out.println("\n==============================");
        System.out.println("dataset: " + titulo);
        System.out.println("==============================");

        // ejecucion de bubble sort
        BubbleSort.Result rBubble = ejecutarPruebas(data,
                copia -> BubbleSort.sort((Comparable[]) copia, false));

        // ejecucion de insertion sort
        InsertionSort.Result rInsert = ejecutarPruebas(data,
                copia -> InsertionSort.sort((Comparable[]) copia, false));

        // ejecucion de selection sort
        SelectionSort.Result rSelect = ejecutarPruebas(data,
                copia -> SelectionSort.sort((Comparable[]) copia, false));

        // imprime los resultados en formato tabla
        imprimirTablaResumen(titulo, rBubble, rInsert, rSelect);
    }

    // muestra el significado de cada columna una sola vez
    private static void imprimirLeyenda() {
        System.out.println("\nleyenda de columnas");
        System.out.println("+----------------+-----------------------------------+");
        System.out.println("| columna        | significado                       |");
        System.out.println("+----------------+-----------------------------------+");
        System.out.println("| tiempo(ns)     | duracion total del algoritmo      |");
        System.out.println("| comparac       | total de comparaciones realizadas |");
        System.out.println("| swaps          | total de intercambios ejecutados  |");
        System.out.println("| status         | estado final del algoritmo        |");
        System.out.println("+----------------+-----------------------------------+");
    }

    // imprime los resultados de bubble insertion y selection en una tabla organizada
    private static void imprimirTablaResumen(String titulo,
                                             BubbleSort.Result rBubble,
                                             InsertionSort.Result rInsert,
                                             SelectionSort.Result rSelect) {

        System.out.println("\n>>> " + titulo + "\n");

        ConsoleTable table = new ConsoleTable();

        // encabezado de la tabla
        table.addRow("algoritmo", "tiempo(ns)", "comparac", "swaps", "status");

        // datos de bubble sort
        table.addRow("bubble",
                String.valueOf(rBubble.timeNs),
                String.valueOf(rBubble.comparisons),
                String.valueOf(rBubble.swaps),
                "ok");

        // datos de insertion sort
        table.addRow("insertion",
                String.valueOf(rInsert.timeNs),
                String.valueOf(rInsert.comparisons),
                String.valueOf(rInsert.swaps),
                "ok");

        // datos de selection sort
        table.addRow("selection",
                String.valueOf(rSelect.timeNs),
                String.valueOf(rSelect.comparisons),
                String.valueOf(rSelect.swaps),
                "ok");

        table.print(); // muestra la tabla formateada
    }
}
