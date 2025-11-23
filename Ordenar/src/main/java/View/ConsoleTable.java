package View;

import java.util.ArrayList;
import java.util.List;

public class ConsoleTable {

    // lista de filas que componen la tabla
    private final List<String[]> rows = new ArrayList<>();

    // agrega una nueva fila a la tabla
    public void addRow(String... cols) {
        rows.add(cols);
    }

    // imprime la tabla completa con bordes y columnas alineadas
    public void print() {

        // arreglo para almacenar el ancho maximo de cada columna
        int[] columnWidths = new int[rows.get(0).length];

        // calcular el ancho mas grande por columna
        for (String[] row : rows) {
            for (int c = 0; c < row.length; c++) {
                columnWidths[c] = Math.max(columnWidths[c], row[c].length());
            }
        }

        // separador superior
        printSeparator(columnWidths);

        // imprime cada fila de la tabla
        for (int r = 0; r < rows.size(); r++) {
            printRow(rows.get(r), columnWidths);

            // imprime un separador despues del encabezado
            if (r == 0) {
                printSeparator(columnWidths);
            }
        }

        // separador inferior
        printSeparator(columnWidths);
    }

    // imprime una fila con formato y alineacion
    private void printRow(String[] row, int[] widths) {
        System.out.print("|");
        for (int c = 0; c < row.length; c++) {
            System.out.print(" " + padRight(row[c], widths[c]) + " |");
        }
        System.out.println();
    }

    // imprime una linea separadora segun el ancho de cada columna
    private void printSeparator(int[] widths) {
        System.out.print("+");
        for (int w : widths) {
            System.out.print("-".repeat(w + 2) + "+");
        }
        System.out.println();
    }

    // rellena texto con espacios a la derecha para alinear columnas
    private String padRight(String text, int length) {
        while (text.length() < length) {
            text += " ";
        }
        return text;
    }

    // imprime la descripcion de cada columna una sola vez
    public static void imprimirLeyenda() {
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
}
