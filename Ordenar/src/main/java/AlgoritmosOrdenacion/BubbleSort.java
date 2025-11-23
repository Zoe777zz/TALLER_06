package AlgoritmosOrdenacion;

public class BubbleSort {

    // clase que almacena las metricas generadas por el algoritmo
    public static class Result {
        public long comparisons;   // total de comparaciones
        public long swaps;         // total de intercambios
        public long timeNs;        // tiempo total de ejecucion en nanosegundos
    }

    public static <E extends Comparable<E>> Result sort(E[] array, boolean trace) {

        Result result = new Result();  // objeto donde se guardan las metricas

        // si el arreglo es nulo o tiene un solo elemento no necesita ordenarse
        if (array == null || array.length < 2)
            return result;

        long startTime = System.nanoTime();  // marca el inicio de la medicion

        int arraySize = array.length;  // tamano del arreglo

        // bucle externo controla las pasadas completas
        for (int pass = 0; pass < arraySize - 1; pass++) {

            boolean huboIntercambio = false;  // indica si hubo al menos un swap en esta pasada


            for (int index = 0; index < arraySize - 1 - pass; index++) {

                result.comparisons++;  // aumenta el contador de comparaciones

                // compareTo permite comparar elementos genericos
                if (array[index].compareTo(array[index + 1]) > 0) {

                    // intercambio de posiciones
                    E temporal = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temporal;

                    result.swaps++;  // aumenta el contador de swaps
                    huboIntercambio = true;  // indica que hubo intercambio
                }
            }

            // imprime la traza si esta activada
            if (trace) {
                System.out.println("pasada " + (pass + 1));
            }

            // si no hubo intercambios el arreglo ya esta ordenado
            if (!huboIntercambio)
                break;
        }

        long endTime = System.nanoTime();  // marca el final de la medicion
        result.timeNs = endTime - startTime;  // tiempo total de ejecucion

        return result;  // devuelve las metricas
    }
}
