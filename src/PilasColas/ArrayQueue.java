package PilasColas;

public class ArrayQueue {
    private Object[] data;
    private int first;
    private int rear;
    private int size;

    // Constructor
    public ArrayQueue(int capacity) {
        data = new Object[capacity];
        first = -1;
        rear = -1;
        size = 0;
    }

    // Método para obtener el tamaño de la cola
    public int size() {
        return size;
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Método para agregar un elemento a la cola
    public void enqueue(Object item) {
        if (size == data.length) {
            System.out.println("Queue is full");
            return;
        }
        if (isEmpty()) {
            first = 0;
        }
        rear = (rear + 1) % data.length;
        data[rear] = item;
        size++;
    }

    // Método para quitar un elemento de la cola
    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Object temp = data[first];
        data[first] = null; // Opcional: para ayudar al recolector de basura
        first = (first + 1) % data.length;
        size--;
        if (isEmpty()) {
            first = -1;
            rear = -1;
        }
        return temp;
    }

    // Método para ver el primer elemento de la cola sin quitarlo
    public Object first() {
        if (isEmpty()) {
            return null;
        }
        return data[first];
    }
}



// package PilasColas;

// public class ArrayQueue {
//     private Object[] data;
//     private int first;
//     private int rear;
//     private int size;

//     // Constructor
//     public ArrayQueue(int capacity) {
//         data = new Object[capacity];
//         first = -1;
//         rear = -1;
//         System.out.println("Size: " + size());
//     }

//     // Método para obtener el tamaño de la cola
//     public int size() {
//         int temp;
//         temp = data.length - first + rear;
//         temp = temp%data.length + 1;
//         return temp;
//     }

//     // Método para verificar si la cola está vacía
//     public boolean isEmpty() {
//         return size == 0;
//     }

//     // Método para agregar un elemento a la cola
//     public void enqueue(Object item) {
//         if(size() < data.length){
//             rear = (rear + 1) % data.length;
//             data[rear] = item;
//             System.out.println(item);
            
//         }
//     }

//     // Método para quitar un elemento de la cola
//     public Object dequeue() {
//         if (isEmpty()) {
//             return null;
//         }else{
//             Object temp = data[first];
//             data[first] = null;
//             first = (first + 1) % data.length;
//             return temp;
//         }
//     }

//     // Método para ver el primer elemento de la cola sin quitarlo
//     public Object first() {
//         if (isEmpty()) {
//             return null;
//         }
//         return data[first];
//     }
// }

