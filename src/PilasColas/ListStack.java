package PilasColas;

import Nodes.List;

public class ListStack {
    private List data;

    public ListStack(){
        data = new List();
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public void push(Object e){
        data.addFirst(e);
    }

    public Object pop(){
        return data.removeFirst();
    }

    public Object top(){
        if (!isEmpty()) {
            return data.getFirst().getData();
        }else{
            return null;
        }
    }

    public Object[] getContents(){
        return data.getContents();
    }
}
