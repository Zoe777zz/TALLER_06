package ed.u2.sorting;


import java.util.Arrays;

// Traza --> ver cada paso de ordenacion
public final class InsertionSort {

    public static void sort(int[] a, boolean trace) {
        for (int i = 1; i < a.length; i++) { // i= 1 , xq se supone que la primera carta a[0] ya está "ordenada"

            // 'key' es el elemento a insertar
            //8, 3, 6, 3, 9
            //Vuelta 1 (i=1): key se vuelve 3
            //j es un puntero , es decir que apunta a la última carta de la parte ordenada
            int key = a[i];
            int j = i - 1;

            // una posición hacia la derecha.
            while (j >= 0 && a[j] > key) { // si todavia esta dentro del arreglo y si el numero a[j] es mas grande que KEY
                a[j + 1] = a[j]; // Desplaza
                j = j - 1; // j vale 0
            }

            // Coloca 'key' en su posición correcta
            a[j + 1] = key;

            //Imprimir la traza
            if (trace) {
                System.out.println("Iteración " + i + " (insertando " + key + "): " + Arrays.toString(a));
            }
        }
    }
}