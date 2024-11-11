package co.cue.edu.arboles;

import java.util.ArrayList;
import java.util.Random;

/**
 * Definición de la clase ÁrbolBinario
 */
class ArbolBinario {
    Nodo raiz;
    Random random = new Random();

    public ArbolBinario() {
        raiz = new Nodo(generarValorAleatorio());
    }

    private int generarValorAleatorio() {
        return random.nextInt(100);
    }

    /**
     * Método para verificar si un nodo es la raíz de un árbol binario válido
     */
    public boolean esRaizValida(Nodo nodo) {
        return nodo == raiz;
    }

    /**
     * Método para insertar un nodo en el árbol
     */
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }
        if (valor < actual.valor) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, valor);
        } else if (valor > actual.valor) {
            actual.derecho = insertarRecursivo(actual.derecho, valor);
        }
        return actual;
    }

    /**
     * Representación gráfica del árbol en formato simétrico
     */
    public void mostrarArbol() {
        if (raiz == null) return;

        int maxLevel = obtenerNivelMaximo(raiz);
        mostrarArbolRecursivo(new ArrayList<Nodo>() {{ add(raiz); }}, 1, maxLevel);
    }

    private void mostrarArbolRecursivo(ArrayList<Nodo> nodos, int nivel, int nivelMax) {
        if (nodos.isEmpty() || sonTodosNulos(nodos)) return;

        int floor = nivelMax - nivel;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        imprimirEspacios(firstSpaces);

        ArrayList<Nodo> nuevosNodos = new ArrayList<>();
        for (Nodo nodo : nodos) {
            if (nodo != null) {
                System.out.print(nodo.valor);
                nuevosNodos.add(nodo.izquierdo);
                nuevosNodos.add(nodo.derecho);
            } else {
                nuevosNodos.add(null);
                nuevosNodos.add(null);
                System.out.print(" ");
            }
            imprimirEspacios(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodos.size(); j++) {
                imprimirEspacios(firstSpaces - i);
                if (nodos.get(j) == null) {
                    imprimirEspacios(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodos.get(j).izquierdo != null) System.out.print("/");
                else imprimirEspacios(1);

                imprimirEspacios(i + i - 1);

                if (nodos.get(j).derecho != null) System.out.print("\\");
                else imprimirEspacios(1);

                imprimirEspacios(endgeLines + endgeLines - i);
            }
            System.out.println();
        }

        mostrarArbolRecursivo(nuevosNodos, nivel + 1, nivelMax);
    }

    private void imprimirEspacios(int count) {
        for (int i = 0; i < count; i++) System.out.print(" ");
    }

    private int obtenerNivelMaximo(Nodo nodo) {
        if (nodo == null) return 0;
        return Math.max(obtenerNivelMaximo(nodo.izquierdo), obtenerNivelMaximo(nodo.derecho)) + 1;
    }

    private boolean sonTodosNulos(ArrayList<Nodo> nodos) {
        for (Nodo nodo : nodos) {
            if (nodo != null) return false;
        }
        return true;
    }
}
