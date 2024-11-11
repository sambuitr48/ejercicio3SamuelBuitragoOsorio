package co.cue.edu.arboles;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase principal con el menú para probar el programa
 */
public class VerificacionRaizArbol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();

        // Insertar nodos aleatorios para crear el árbol
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            arbol.insertar(random.nextInt(100));
        }

        System.out.println("Árbol binario generado: ");
        arbol.mostrarArbol();

        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Verificar si un nodo es la raíz del árbol");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor del nodo a verificar: ");
                    int valor = scanner.nextInt();
                    Nodo nodo = buscarNodo(arbol.raiz, valor);
                    if (nodo != null) {
                        boolean esRaiz = arbol.esRaizValida(nodo);
                        System.out.println("¿El nodo con valor " + valor + " es la raíz del árbol? " + esRaiz);
                    } else {
                        System.out.println("Nodo con valor " + valor + " no encontrado en el árbol.");
                    }
                    break;
                case 2:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 2);
        scanner.close();
    }

    public static Nodo buscarNodo(Nodo nodo, int valor) {
        if (nodo == null || nodo.valor == valor) {
            return nodo;
        }
        if (valor < nodo.valor) {
            return buscarNodo(nodo.izquierdo, valor);
        } else {
            return buscarNodo(nodo.derecho, valor);
        }
    }
}