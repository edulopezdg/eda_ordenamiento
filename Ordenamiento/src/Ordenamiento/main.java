package Ordenamiento;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
              
        Ordenamiento arreglo = new Ordenamiento();
        Scanner scanner = new Scanner(System.in);
        //Declaramos la variable opcion
        char opcion;
        
        //Llamamos al metodo que va a cargar el arreglo
        arreglo.carga();
        do {            
            
            //Mostramos el arreglo sin ordenar
            arreglo.muestra();

            System.out.println("\nElija el metodo de ordenamiento:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Shell Sort");
            System.out.println("4. Bucket Sort");
            System.out.println("5. Quick Sort");
            System.out.println("6. Busqueda Lineal");
            System.out.println("7. Busqueda Binaria\n");

            int metodo = scanner.nextInt();

            switch (metodo) {
                case 1:
                    arreglo.carga();
                    long startTime = System.currentTimeMillis(); // Inicio del contador de tiempo
                    arreglo.bubbleSort();
                    long endTime = System.currentTimeMillis(); // Fin del contador de tiempo
                    //Mostramos el arreglo ordenado
                    arreglo.muestra();
                    System.out.println("\nTiempo de ejecucion: " + (endTime - startTime) + " milisegundos");
                    break;
                case 2:
                    arreglo.carga();
                    long startTime1 = System.currentTimeMillis(); // Inicio del contador de tiempo
                    arreglo.insertionSort();
                    long endTime1 = System.currentTimeMillis(); // Fin del contador de tiempo
                    //Mostramos el arreglo ordenado
                    arreglo.muestra();
                    System.out.println("\nTiempo de ejecucion: " + (endTime1 - startTime1) + " milisegundos");
                    break;
                case 3:
                    arreglo.carga();
                    long startTime2 = System.currentTimeMillis(); // Inicio del contador de tiempo
                    arreglo.shellSort();
                    long endTime2 = System.currentTimeMillis(); // Fin del contador de tiempo
                    //Mostramos el arreglo ordenado
                    arreglo.muestra();
                    System.out.println("\nTiempo de ejecucion: " + (endTime2 - startTime2) + " milisegundos");
                    break;
                case 4:
                    arreglo.carga();
                    long startTime3 = System.currentTimeMillis(); // Inicio del contador de tiempo
                    arreglo.bucketSort();
                    long endTime3 = System.currentTimeMillis(); // Fin del contador de tiempo
                    //Mostramos el arreglo ordenado
                    arreglo.muestra();
                    System.out.println("\nTiempo de ejecucion: " + (endTime3 - startTime3) + " milisegundos");
                    break;
                case 5:
                    arreglo.carga();
                    long startTime4 = System.currentTimeMillis(); // Inicio del contador de tiempo
                    arreglo.quickSort();
                    long endTime4 = System.currentTimeMillis(); // Fin del contador de tiempo
                    //Mostramos el arreglo ordenado
                    arreglo.muestra();
                    System.out.println("\nTiempo de ejecucion: " + (endTime4 - startTime4) + " milisegundos");
                    break;
                case 6:
                    long startTime5 = System.currentTimeMillis(); // Inicio del contador de tiempo
                    arreglo.busquedaLineal(1);
                    long endTime5 = System.currentTimeMillis(); // Fin del contador de tiempo
                    System.out.println("\nTiempo de ejecucion: " + (endTime5 - startTime5) + " milisegundos");
                    break;
                case 7:
                    long startTime6 = System.currentTimeMillis(); // Inicio del contador de tiempo
                    arreglo.busquedaBinaria(1);
                    long endTime6 = System.currentTimeMillis(); // Fin del contador de tiempo
                    System.out.println("\nTiempo de ejecucion: " + (endTime6 - startTime6) + " milisegundos");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

            System.out.println("\nDesea ordenar otro arreglo? (s/n)");
            opcion = scanner.next().charAt(0);
        } while (opcion == 's' || opcion == 'S');
    }
}


