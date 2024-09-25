package Nodes;

import Usuario.Usuario;

public class DoubleList {
    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    // Constructor sin parámetros
    public DoubleList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Método para obtener el tamaño de la lista
    public int size() {
        return size;
    }

    // Método para verificar si la lista está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Método para obtener el primer nodo de la lista
    public DoubleNode first() {
        return head;
    }

    // Método para obtener el último nodo de la lista
    public DoubleNode last() {
        return tail;
    }

    // Método para agregar un nodo al principio de la lista
    public void addFirst(Object e) {
        DoubleNode n = new DoubleNode(e);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.setNext(head);
            head.setPrev(n);
            head = n;
        }

        size++;
    }

    // Método para agregar un nodo al final de la lista
    public void addLast(Object e) {
        DoubleNode n = new DoubleNode(e);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            tail.setNext(n);
            n.setPrev(tail);
            tail = n;
        }

        size++;
    }

    // Método para eliminar el primer nodo de la lista
    public Object removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            DoubleNode temp = head;
            head = temp.getNext();
            if (head != null) {
                head.setPrev(null);
            } else {
                tail = null; // La lista se vacía
            }
            temp.setNext(null);
            size--;
            return temp.getData();
        }
    }

    // Método para eliminar el último nodo de la lista
    public Object removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            DoubleNode temp = tail;
            tail = temp.getPrev();
            if (tail != null) {
                tail.setNext(null);
            } else {
                head = null; // La lista se vacía
            }
            temp.setPrev(null);
            size--;
            return temp.getData();
        }
    }

    // Método para eliminar un nodo específico de la lista
    public Object remove(DoubleNode n) {

        if (n == head) {
            return removeFirst();
        } else if (n == tail) {
            return removeLast();
        } else {
            Object data = n.getData();
            DoubleNode p = n.getPrev();
            DoubleNode nx = n.getNext();

            if (p != null) {
                p.setNext(nx);
            }
            if (nx != null) {
                nx.setPrev(p);
            }
            
            n.setNext(null);
            n.setPrev(null);
            size--;

            return data;
        }
    }

    public Object remove(Object n){
        DoubleNode actual = head;
        while(actual!=null){
            if (actual.getData().equals(n)) {
                return remove(actual);
            }
            actual = actual.getNext();
        }
        return null;
    }

    public void addBefore(DoubleNode n, Object e) {
        if (n == head) {
            addFirst(e);
        } else {
            DoubleNode m = new DoubleNode(e);
            DoubleNode p = n.getPrev();
            p.setNext(m);
            m.setPrev(p);
            m.setNext(n);
            n.setPrev(m);
            size++;
        }
    }

    public void addAfter(DoubleNode n, Object e){
        if (n == tail) {
            addLast(e);
        } else {
            DoubleNode m = new DoubleNode(e);
            DoubleNode nx = n.getNext();
            n.setNext(m);
            m.setPrev(n);
            m.setNext(nx);
            nx.setPrev(m);
            size++;
        }
    }

    public void fullNodes() {
        DoubleNode actualNode = head;
        while (actualNode != null) {
            System.out.print(actualNode.getData() + "\n");
            actualNode = actualNode.getNext();
        }
    }
    
    // Método de burbuja para ordenar la lista por cédula
    public void bubbleSortByCedula() {
        if (isEmpty()) return;
    
        boolean swapped;
        do {
            swapped = false;
            DoubleNode current = head;
    
            while (current.getNext() != null) {
                Usuario user1 = (Usuario) current.getData();
                Usuario user2 = (Usuario) current.getNext().getData();
    
                if (user1.getId() > user2.getId()) {
                    // Intercambiar los nodos
                    Object tempData = current.getData();
                    current.setData(current.getNext().getData());
                    current.getNext().setData(tempData);
    
                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);
    }
    
}