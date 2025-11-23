package AlgoritmosOrdenacion;

public final class SelectionSort {

    // clase simple para almacenar las metricas del algoritmo
    public static class Result {
        public long comparisons;  // total de comparaciones
        public long swaps;        // total de intercambios
        public long timeNs;       // tiempo total en nanosegundos
    }


    public static <E extends Comparable<E>> Result sort(E[] array, boolean trace) {

        Result result = new Result();

        // si el arreglo es nulo o demasiado pequeno se devuelve sin ordenar
        if (array == null || array.length < 2)
            return result;

        long startTime = System.nanoTime();  // inicio de medicion

        int arraySize = array.length;  // tamano del arreglo

        // Bucle externo separacion entre la parte ordenada y la desordenada
        for (int i = 0; i < arraySize - 1; i++) {

            int indiceMinimo = i;  // posicion donde esta el elemento mas pequeno encontrado

            // busca el elemento minimo en la parte no ordenada del arreglo
            for (int j = i + 1; j < arraySize; j++) {

                result.comparisons++;  // cada iteracion representa una comparacion

                // si se encuentra un elemento mas pequeno se actualiza la posicion minima
                if (array[j].compareTo(array[indiceMinimo]) < 0) {
                    indiceMinimo = j;
                }
            }

            // si el minimo no esta en la posicion correcta se realiza un intercambio
            if (indiceMinimo != i) {
                E temporal = array[i];
                array[i] = array[indiceMinimo];
                array[indiceMinimo] = temporal;

                result.swaps++;  // se registra el intercambio
            }

            // impresion de traza si esta activada
            if (trace) {
                System.out.println("iteracion " + i + " minimo colocado en posicion " + i);
            }
        }

        long endTime = System.nanoTime();  // fin de medicion
        result.timeNs = endTime - startTime;  // tiempo total registrado

        return result;  // retorno de metricas
    }
}
