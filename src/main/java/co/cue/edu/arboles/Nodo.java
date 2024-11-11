package co.cue.edu.arboles;

/**
 * Definición de la clase Nodo
 */
class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}
