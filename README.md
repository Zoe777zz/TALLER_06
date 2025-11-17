# TALLER_05
Implementar y comparar tres algoritmos de ordenación in-place sobre arreglos pequeños, y validar su funcionamiento con trazas y casos de prueba reproducibles.

**Autores:**

* Soledad Buri
* Gyna Yupanqui 

--- 
# Decisiones de Diseño  

*  **Clases de Utilidad:** Se implemento InsertionSort, SelectionSort y BubbleSort como clases con métodos estáticos debido a que no es necesario crear ibjetos para poder ordenar un arreglo.
*  **Trazas:** Se añadio un paráremtro Boolean en cada método sort, lo que permite usar el algoritmo de forma silenciosa.
*  **Manejo de datos:** En la clase principal SortingDemo, se uso el método .clone() antes de enviar los arreglos a ordenar lo que asegura qu el arreglo no se modifique permitiendo reutilizarlo son interferencias.

----
# Modo de ejecución 

**Modo 1**
1. Buscar la carpeta src/ed/u2/sorting/
2. Compilar 
3. Ejecutar (Se mostrata en la salida los casos requeridos)

**Modo 2**
1. Clonar el repositorio
2. Abirir en un IDE
3. Ejecutar **SortingDemo**
4. Se mostrara en consola los algoritmos de ordenación requeridos

---
# Manejo de Casos Borde 
Se consideraron y probaron los siguientes casos especiales para asegurar la robustez:
* **Arreglos Nulos:** Se incluyó una validación inicial (if (a == null) return;) en todos los algoritmos para evitar errores de tipo NullPointerException si se reciben datos vacíos.
* **Arreglos Ya Ordenados:** Se probó específicamente BubbleSort con un arreglo ordenado [1, 2, 3, 4, 5] para verificar que la optimización de "corte temprano" detuviera el algoritmo en la primer pasada.
* **Elementos Duplicados:** Se realizaron pruebas con arreglos como [2, 2, 2, 2] para confirmar que los algoritmos ne se encuentren en bucles infinitos y manejen correctamente los valores iguales. 

