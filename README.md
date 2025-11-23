# TALLER_06
Ejecutar y analizar comparativamente los algoritmos de Burbuja, Selección e Inserción sobre casos de prueba, para determinar cuándo conviene cada uno en función de tamaño, grado de orden y duplicados.

**Autores:**

* Soledad Buri
* Gyna Yupanqui 

--- 
# Descripción

Este taller compara tres algoritmos clasicos de ordenacion BubbleSort, InsertionSort y SelecntionSort los cuales fueron instrumentados para registar:
* Tiempo
* Comparaciones realizadas
* Swaps (movimientos)
* Mediana de ejecuciones
  
Esta comparación se relaiza sobre 4 datasets con características diferentes de 100 y 500 datos.

----
# Estructura de Proyecto
* AlgoritmosOrdenacion/
  
  BubbleSort.java/
  InsertionSort.java/
  SelectionSort.java
* ArchivosCSV/
  
  Cita.java
  Paciente.java/
  Inventario.java
* View/
  
  SortingDemo.java/
  ConsoleTable.java

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
## Matriz de recomendacion de algoritmos

| Algoritmo           | Dataset pequeño  | Dataset mediano   | Dataset grande  | Datos casi ordenados  | Datos inversos  | Comentario general  |
|---------------------|------------------|-------------------|-----------------|-----------------------|-----------------|---------------------|
| **Bubble Sort**     | Malo             | Muy malo          | Peor            | Bueno                 | Muy malo        | No recomendado salvo para enseñanza |
| **Insertion Sort**  | Muy bueno        | Bueno             | Malo            | Excelente             | Malo            | Ideal para listas casi ordenadas |
| **Selection Sort**  | Regular          | Regular           | Regular         | Regular               | Regular         | Útil cuando se requieren mínimos swaps |


