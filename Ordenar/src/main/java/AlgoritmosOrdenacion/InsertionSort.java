package AlgoritmosOrdenacion;

public final class InsertionSort {


    public static class Result {
        public long comparisons;  // total de comparaciones
        public long swaps;        // total de desplazamientos d
        public long timeNs;       // tiempo total en nanosegundos
    }

    public static <E extends Comparable<E>> Result sort(E[] array, boolean trace) {

        Result result = new Result();

        // si el arreglo es nulo o tiene un solo elemento no se ordena
        if (array == null || array.length < 2)
            return result;

        long startTime = System.nanoTime();  // inicio de medicion

        int arraySize = array.length;  // tamano del arreglo

        // el algoritmo inicia desde la posicion 1 porque la posicion 0 ya esta ordenada
        for (int i = 1; i < arraySize; i++) {

            E elementoActual = array[i];  // elemento que se debe insertar
            int posicion = i - 1;         // posicion anterior dentro de la parte ordenada

            // desplazamiento de elementos mayores hacia la derecha
            while (posicion >= 0) {

                result.comparisons++;  // se registra cada comparacion

                // si el elemento previo es mayor se desplaza hacia la derecha
                if (array[posicion].compareTo(elementoActual) > 0) {

                    array[posicion + 1] = array[posicion];  // desplazamiento
                    result.swaps++;  // se registra el movimiento
                    posicion--;      // avanza a la siguiente posicion

                } else {
                    break;  // no es necesario seguir comparando
                }
            }

            // se coloca el elemento actual en su posicion correcta
            array[posicion + 1] = elementoActual;

            // impresion de traza si esta activada
            if (trace) {
                System.out.println("iteracion " + i + " insertando " + elementoActual);
            }
        }

        long endTime = System.nanoTime();  // fin de medicion
        result.timeNs = endTime - startTime;  // tiempo total del algoritmo

        return result;  // retorno de metricas
    }
}
