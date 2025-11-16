package ed.u2.sorting;

import java.util.Arrays;


 //1  crea los arreglos de prueba
 //2. llamar a las "herramientas"
 //3. imprimir los resultados

public class SortingDemo {


    public static void main(String[] args) {

        System.out.println("--- DEMOSTRACIÓN DE ALGORITMOS DE ORDENACION ---");

        // 1. definimos los arreglos de prueba

        int[] A = {8, 3, 6, 3, 9};
        int[] B = {5, 4, 3, 2, 1}; // Caso "Peor" (Inverso)
        int[] C = {1, 2, 3, 4, 5}; // Caso "Mejor" (Ya ordenado)
        int[] D = {2, 2, 2, 2};     // Duplicados
        int[] E = {9, 1, 8, 2};

        // --- 2. Probamos InsertionSort ---
        // (tener en cuenta : mostrar traza clara)
        System.out.println("\n== PRUEBA: InsertionSort (Inserción) ==");
        int[] arrA_ins = A.clone(); //  .clone() para no dañar el original
        System.out.println("Original (A): " + Arrays.toString(arrA_ins));
        InsertionSort.sort(arrA_ins, true); //mostrar traza
        System.out.println("Ordenado: " + Arrays.toString(arrA_ins));
        System.out.println("Esperado: [3, 3, 6, 8, 9]");

        // --- 3. Probamos BubbleSort (Arreglo INverso ) ---

        System.out.println("\n== PRUEBA: BubbleSort (Burbuja) - Inverso  ==");
        int[] arrB_bub = B.clone(); // Probamos con el arreglo inverso
        System.out.println("Original (B): " + Arrays.toString(arrB_bub));
        BubbleSort.sort(arrB_bub, true);
        System.out.println("Ordenado: " + Arrays.toString(arrB_bub));
        System.out.println("Esperado: [1, 2, 3, 4, 5]");


        // --- 4. Prueba para BubbleSort  ---
        System.out.println("\n== PRUEBA: BubbleSort (Burbuja)  ==");
        int[] arrC_bub = C.clone(); // probamos con el arreglo  ordenado
        System.out.println("Original (C): " + Arrays.toString(arrC_bub));
        // imprimir solo 1 pasada y luego el mensaje de "Corte temprano"
        BubbleSort.sort(arrC_bub, true);
        System.out.println("Ordenado: " + Arrays.toString(arrC_bub));
        System.out.println("Esperado: [1, 2, 3, 4, 5]");


        // --- 5. Prueba con Duplicados ---
        System.out.println("\n== PRUEBA: SelectionSort con Duplicados ==");
        int[] arrD_sel = D.clone();
        System.out.println("Original (D): " + Arrays.toString(arrD_sel));
        SelectionSort.sort(arrD_sel, true);
        System.out.println("Ordenado: " + Arrays.toString(arrD_sel));
        System.out.println("Esperado: [2, 2, 2, 2]");

        // --- 6. Probamos SelectionSort ---
        // (tener en cuenta: Contabilizar swaps)
        System.out.println("\n== PRUEBA: SelectionSort (Selección) ==");
        int[] arrE_sel = E.clone(); // probamos con otro arreglo
        System.out.println("Original (E): " + Arrays.toString(arrE_sel));
        SelectionSort.sort(arrE_sel, true); //  mostrar traza y swaps
        System.out.println("Ordenado: " + Arrays.toString(arrE_sel));
        System.out.println("Esperado: [1, 2, 8, 9]");

    }
}