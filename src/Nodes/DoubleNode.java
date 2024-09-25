package Nodes;

public class DoubleNode {
    private Object data;
    private DoubleNode prev;
    private DoubleNode next;

    // Constructor sin parámetros
    public DoubleNode() {
        this.data = null;
        this.prev = null;
        this.next = null;
    }

    // Constructor con un parámetro
    public DoubleNode(Object d) {
        this.data = d;
        this.prev = null;
        this.next = null;
    }

    // Método para establecer el dato
    public void setData(Object d) {
        this.data = d;
    }

    // Método para establecer el siguiente nodo
    public void setNext(DoubleNode n) {
        this.next = n;
    }

    // Método para establecer el nodo anterior
    public void setPrev(DoubleNode p) {
        this.prev = p;
    }

    // Método para obtener el dato
    public Object getData() {
        return this.data;
    }

    // Método para obtener el siguiente nodo
    public DoubleNode getNext() {
        return this.next;
    }

    // Método para obtener el nodo anterior
    public DoubleNode getPrev() {
        return this.prev;
    }
}

