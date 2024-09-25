package PilasColas;

public class ArrayStack {
    private Object[] data;
    private int top;

    // Constructor
    public ArrayStack(int capacity) {
        data = new Object[capacity];
        top = -1;
    }

    // Método para obtener el tamaño de la pila
    public int size() {
        return top + 1;
    }

    // Método para verificar si la pila está vacía
    public boolean isEmpty() {
        return top == -1;
    }

    // Método para agregar un elemento a la pila
    public void push(Object item) {
        if (top < data.length - 1) {
            top++;
            data[top] = item;
        }else{
            System.out.println("Stack overflow");
        }
    }

    // Método para quitar un elemento de la pila
    public Object pop() {
        if (!isEmpty()) {
            Object temp = data[top];
            data[top] = null;
            top--;
            return temp;
        }else{
            return null;
        }
    }

    // Método para ver el elemento en la cima de la pila sin quitarlo
    public Object top() {
        if (!isEmpty()) {
            return data[top];            
        }else{
            return null;
        }
    }
}