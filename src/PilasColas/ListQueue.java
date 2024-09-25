package PilasColas;

import Nodes.List;

public class ListQueue {
    private List data;
    private int size;
    
    public ListQueue(){
        data = new List();
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(Object e){
        data.addLast(e);
    }

    public Object dequeue(){
        return data.removeFirst();
    }

    public Object first(){
        return data.getFirst().getData();
    }

    public Object[] getContents(){
        return data.getContents();
    }
}
