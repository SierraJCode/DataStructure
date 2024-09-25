package Trees;

public class BSTEntry {
    private Object data;
    private int k;

    public BSTEntry(Object d, int k) {
        this.data = d;
        this.k = k;
    }

    public Object getData() {
        return data;
    }

    public int getKey() {
        return k;
    }

    public void setData(Object d) {
        this.data = d;
    }

    public void setKey(int k) {
        this.k = k;
    }
}
