package Heap;

public class Heap {
    public Object[] A;  // Arreglo para almacenar los elementos del heap
    public int size;     // Número de elementos en el heap

    public Heap(int capacity) {
        A = new Object[capacity];
        size = 0;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    // Implementación del MAX-HEAPIFY
    public void maxHeapify(int i, int heapSize) {
        int l = left(i);
        int r = right(i);
        int largest;

        if (l < heapSize && (int) A[l] > (int) A[i]) {
            largest = l;
        } else {
            largest = i;
        }

        if (r < heapSize && (int) A[r] > (int) A[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest, heapSize);
        }
    }

    // Construye un MAX-HEAP a partir de un arreglo dado B
    public void buildMaxHeap(Object[] B) {
        size = B.length;
        A = B;

        for (int i = (size / 2) - 1; i >= 0; i--) {
            maxHeapify(i, size);
        }
    }

    // Ordena el arreglo usando el HEAP-SORT
    public void heapSort() {
        buildMaxHeap(A);

        for (int i = size - 1; i > 0; i--) {
            swap(0, i);
            size--;
            maxHeapify(0, size);
        }
    }

    public void swap(int i, int j) {
        Object temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    
}
