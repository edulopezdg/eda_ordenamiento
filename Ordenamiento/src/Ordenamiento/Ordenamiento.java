package Ordenamiento;

import java.util.Arrays;
import java.util.Random;

public class Ordenamiento {

    //Atributos
    private int[] datos;

    //Creamos un metodo para cargar el arreglo con 10000 numeros aleatorios
    public void carga() {
        datos = new int[5000];
        Random random = new Random();
        for (int i = 0; i < datos.length; i++) {
            datos[i] = random.nextInt(10000);
        }
    }

    //Creamos un metodo para para mostrar el contenido del arreglo
    public void muestra() {
        int contador = 0;
        for (int dato : datos) {
            System.out.print(dato + "| ");
            contador++;
            if (contador % 10 == 0) {
                System.out.println(); // Salto de línea después de cada grupo de 10 números
            }
        }
    }

    //Implementamos el algoritmo de ordenamiento BubbleSort
    public void bubbleSort() {
        int n = datos.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (datos[j] > datos[j + 1]) {
                    // Intercambiamos datos[j] y datos[j+1]
                    int temp = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = temp;
                }
            }
        }
    }

    //Implementamos el algoritmo de ordenamiento Insertion Sort
    public void insertionSort() {
        int n = datos.length;
        for (int i = 1; i < n; ++i) {
            int key = datos[i];
            int j = i - 1;

            //Aqui vamos a mover los elementos de datos[0..i-1] que son mayores que key
            // a una posicion adelante de su posición actual
            while (j >= 0 && datos[j] > key) {
                datos[j + 1] = datos[j];
                j = j - 1;
            }
            datos[j + 1] = key;
        }
    }

    // Implementamos el algoritmo de ordenamiento Shell Sort
    public void shellSort() {
        int n = datos.length;
        // Iniciar con un intervalo grande, luego reducir el intervalo
        for (int intervalo = n / 2; intervalo > 0; intervalo /= 2) {
            // Hacer un insertion sort para cada intervalo
            for (int i = intervalo; i < n; i++) {
                int temp = datos[i];
                int j;
                for (j = i; j >= intervalo && datos[j - intervalo] > temp; j -= intervalo) {
                    datos[j] = datos[j - intervalo];
                }
                datos[j] = temp;
            }
        }
    }

    //Implementamos el algoritmo de ordenamiento Shell Sort Bucket Sort
    public void bucketSort() {
        int n = datos.length;
        int max = getMax(datos);
        int[] cubeta = new int[max + 1];

        for (int i = 0; i <= max; i++) {
            cubeta[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            cubeta[datos[i]]++;
        }

        int pos = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < cubeta[i]; j++) {
                datos[pos++] = i;
            }
        }
    }

    private int getMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    //Implementamos el metodo de ordenamiento QuickSort
    public void quickSort() {
        quickSort(0, datos.length - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);

            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = datos[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (datos[j] < pivot) {
                i++;

                int temp = datos[i];
                datos[i] = datos[j];
                datos[j] = temp;
            }
        }

        int temp = datos[i + 1];
        datos[i + 1] = datos[high];
        datos[high] = temp;

        return i + 1;
    }

    //Metodo de busqueda lineal
    public void busquedaLineal(int dato) {
        boolean flag = false;

        for (int i = 0; i < datos.length; i++) {

            if (dato == datos[i]) {
                System.out.println("el dato fue encontrado en:" + " [" + i + "]");
                flag = true;
            }

        }
        if (!flag) {
            System.out.println("No se encontro el dato");
        }
    }

    //Metodo de busqueda binaria
    public void busquedaBinaria(int dato) {

        int mitad = (datos.length / 2) - 1;
        boolean flag = false;

        if (dato <= mitad) {
            for (int i = 0; i <= mitad; i++) {
                if (datos[i] == dato) {
                    System.out.println("Se encontro el elemento en:" + i);
                    flag = true;
                }
            }
        } else {

            for (int i = mitad; i < datos.length; i++) {
                if (datos[i] == dato) {
                    System.out.println("Se encontro el dato en:" + i);
                    flag = true;
                }
            }

        }
        if (!flag) {
            System.out.println("No se encontro el dato");
        }
    }
}
