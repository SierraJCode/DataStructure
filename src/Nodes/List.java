package Nodes;

public class List {
    private Node head;
    private Node tail;
    private int size;

    public List() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void setSize(int s){
        size = s;
    }
    
    public Node getFirst(){
        return head;
    }
    
    public Node getLast(){
        return tail;
    }
    
    public void addFirst(Object data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    public void addLast(Object data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }
    
    public Object removeFirst() {
        if (!isEmpty()) {
            Node temp = head;
            head = temp.getNext();
            temp.setNext(null);
            size--;
            return temp.getData();
        } else {
            return null;
        }
    }
    
    public Object removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (size == 1) {
            return removeFirst();
        } else {
            Node temp = tail;
            Node anterior = head;
            while (anterior.getNext() != tail) {
                anterior = anterior.getNext();
            }
            anterior.setNext(null);
            tail = anterior;
            size--;
            return temp.getData();
        }
    }

    public void fullNodes() {
        Node actualNode = head;
        while (actualNode != null) {
            System.out.print(actualNode.getData() + " \n");
            actualNode = actualNode.getNext();
        }
    }

    public Object[] getContents() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.getNext();
        }

        Object[] contents = new Object[size];
        current = head;
        int index = 0;
        while (current != null) {
            contents[index++] = current.getData();
            current = current.getNext();
        }
        return contents;
    }

    public Object remove(Node n){
        if (n == head) {
            removeFirst();
        }else if (n == tail) {
            removeLast();
        }else{
            Node temp = head.getNext();
            while (n != temp) {
                temp = temp.getNext();
                removeFirst();
            }
            removeFirst();
            return removeFirst();

        }
        return null;
    }

    public Object remove(Object n){
        Node actual = head;
        while(actual!=null){
            if (actual.getData().equals(n)) {
                return remove(actual);
            }
            actual = actual.getNext();
        }
        return null;
    }
    
}