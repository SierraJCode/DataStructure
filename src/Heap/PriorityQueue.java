package Heap;

public class PriorityQueue {
    public Heap heap;  // Instancia de la clase HEAP para manejar la cola de prioridad

    // Constructor que inicializa el heap con la capacidad dada
    public PriorityQueue(int capacity) {
        heap = new Heap(capacity);
    }

    // Inserta un nuevo elemento en la cola de prioridad
    public void maxHeapInsert(Object key) {
        // Aumenta el tamaño del heap
        if (heap.size == heap.A.length) {
            throw new IllegalStateException("Heap is full");
        }

        // Agrega el nuevo elemento al final del heap
        heap.A[heap.size] = key;
        heap.size++;

        // Ajusta el heap para mantener la propiedad de MAX-HEAP
        int i = heap.size - 1;
        while (i > 0 && (int) heap.A[heap.parent(i)] < (int) heap.A[i]) {
            heap.swap(i, heap.parent(i));
            i = heap.parent(i);
        }
    }

    // Extrae el máximo elemento de la cola de prioridad
    public int heapExtractMax() {
        if (heap.size < 1) {
            throw new IllegalStateException("Heap underflow");
        }

        int max = (int) heap.A[0];
        heap.A[0] = heap.A[heap.size - 1];
        heap.size--;
        heap.maxHeapify(0, heap.size);

        return max;
    }

    // Devuelve el máximo elemento sin extraerlo
    public int heapMaximum() {
        if (heap.size < 1) {
            throw new IllegalStateException("Heap is empty");
        }

        return (int) heap.A[0];
    }
}
