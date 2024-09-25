package Run;
import Heap.*;
import java.util.Arrays;
import java.util.Random;

public class RunHeap {

    public RunHeap(){
        int n = 7;
        Object[] array = generateRandomArray(n);
        System.out.println("Arreglo original: " + Arrays.toString(array));
        Heap heap = new Heap(n);

        heap.buildMaxHeap(array);
        System.out.println("MAX-HEAP después de buildMaxHeap: " + Arrays.toString(heap.A));

        heap.heapSort();
        System.out.println("Arreglo ordenado con heapSort: " + Arrays.toString(heap.A));

        PriorityQueue pq = new PriorityQueue(n);

        System.out.println("MAX-HEAP-INSERT");
        for (Object value : array) {
            pq.maxHeapInsert(value);
            System.out.println("Inserted: " + value + " -> Heap: " + Arrays.toString(pq.heap.A));
        }

        System.out.println("Maximum element: " + pq.heapMaximum());
        System.out.println("Extracted max: " + pq.heapExtractMax());
        System.out.println("Heap after extracting max: " + Arrays.toString(pq.heap.A));
    }

    private static Object[] generateRandomArray(int n) {
        Random rand = new Random();
        Object[] array = new Object[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(100);  // Valores aleatorios entre 0 y 99
        }
        return array;
    }
}
