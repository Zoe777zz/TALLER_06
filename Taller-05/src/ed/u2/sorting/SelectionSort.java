package ed.u2.sorting;

import java.util.Arrays;


public final class SelectionSort {

    public static void sort(int[] a, boolean trace) {
        if (a == null) // borde
            return;

        int n = a.length;

        // contar los intercambios
        int swapCount = 0;

        // controla la "posición ordenada" (i)
        // bucle 'i' marca la frontera entre lo "ordenado" (izquierda)
        // y lo "desordenado" (derecha)
        for (int i = 0; i < n - 1; i++) {


            // supongo el minimo es el primer elemento de la parte "desordenada" (justo  en 'i').
            int minIndex = i;

            // Bucle interno: busca en el resto del arreglo (de i+1 hasta el final) para encontrar si hay un numeero mas pequeño que el que ya tiene
            for (int j = i + 1; j < n; j++) {

                // Si encontramos un número más pequeño que nuestro  minimo actual
                if (a[j] < a[minIndex]) {
                    // actualizamos el indice  de donde esta ese nuevo minimo
                    minIndex = j;
                }
            }

            // 2. Intercambiar (Swap)
            // al salir del bucle 'j', 'minIndex' apunta  a la posición del número más pequeño de toda la sección desordenada

            // hago el intercambio si el mínimo no esta ya  en su sitio (es decir, si i y minIndex son diferentes)
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;

                swapCount++; // contamos el intercambio
            }

            // Imprimir
            if (trace) {
                System.out.println("Iteración " + i + " (mínimo " + a[i] + " puesto en pos " + i + "): " + Arrays.toString(a));
            }
        }

        if (trace) {
            System.out.println("Total de intercambios (swaps) realizados: " + swapCount);
        }
    }
}
