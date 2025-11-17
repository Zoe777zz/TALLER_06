package ed.u2.sorting;

import java.util.Arrays;

public final class BubbleSort {

    public static void sort(int[] a, boolean trace) {

        if (a == null)
            return; // caso borde
        int n = a.length; // guarda el tamaño total del arreglo

        //Bucle Externo (i): Controla el número de pasadas.
        // se tiene n' elementos, con 'n-1' pasadas se asegura de que se ordene

        for (int i = 0; i < n - 1; i++) {



            boolean swapped = false; //bandera de "Corte Temprano" --> noti cuando se ordena
            // Bucle Interno (j):  compara vecinos desde el inicio (j=0) hasta el final de la sección "desordenada"
            // 'n-1' es para no pasarse del limite (al hacer j+1)
            //  El '-i'  ignora los últimos 'i' elementos  porque ya estan ordenados
            for (int j = 0; j < n - 1 - i; j++) {


                // compara el elemento actual (j) con su vecino (j+1)

                if (a[j] > a[j + 1]) { // El de la izquierda es más grande  que el de la derecha
                    // desordenados, se hace un "swap" (intercambio)
                    // guarda el valor de la izquierda en una variable temporal
                    int temp = a[j];
                    //copia el valor de la derecha en la posicion de la izquierda
                    a[j] = a[j + 1];
                    //pone el valor temporal  en la derecha
                    a[j + 1] = temp;


                    swapped = true; // movio algo
                }
            }

            // Imprimir la traza DESPUÉS de cada pasada completa (bucle 'i')
            if (trace) {
                System.out.println("Pasada " + (i + 1) + ": " + Arrays.toString(a));
            }


            if (!swapped) {
                if (trace) {
                    System.out.println("Corte temprano en pasada " + (i+1) + ": Arreglo ya ordenado.");
                }
                break; // rompe el bucle externo 'i'. Terminamos el trabajo
            }
        }
    }
}
