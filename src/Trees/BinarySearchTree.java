package Trees;

public class BinarySearchTree extends BinaryTree {

    public BinarySearchTree() {
        super();
    }

    // Método para encontrar un nodo por clave
    public Node find(int k) {
        return findNode(root, k);
    }

    private Node findNode(Node v, int k) {
        if (v == null) {
            return null;
        }
        
        BSTEntry entry = (BSTEntry) v.getData();
        
        if (entry.getKey() == k) {
            return v;
        } else if (k < entry.getKey()) {
            return findNode(v.getLeft(), k);
        } else {
            return findNode(v.getRight(), k);
        }
    }

    // Método para insertar un nuevo nodo
    public void insert(Object e, int k) {
        BSTEntry entry = new BSTEntry(e, k);
        if (isEmpty()) {
            addRoot(entry);
        } else {
            insertNode(root, entry);
        }
    }

    private void insertNode(Node v, BSTEntry entry) {
        if (entry.getKey() < ((BSTEntry) v.getData()).getKey()) {
            if (hasLeft(v)) {
                insertNode(v.getLeft(), entry);
            } else {
                insertLeft(v, entry);
            }
        } else {
            if (hasRight(v)) {
                insertNode(v.getRight(), entry);
            } else {
                insertRight(v, entry);
            }
        }
    }

    public Node findMax() {
        return findMax(root);
    }
    
    private Node findMax(Node node) {
        if (node == null) {
            return null; // Árbol vacío
        }
        while (node.getRight() != null) {
            node = node.getRight(); // Navega a la derecha hasta encontrar el máximo
        }
        return node; // Retorna el nodo con la clave más grande
    }
    
    public Node findMin() {
        return findMin(root);
    }
    
    private Node findMin(Node node) {
        if (node == null) {
            return null; // Árbol vacío
        }
        while (node.getLeft() != null) {
            node = node.getLeft(); // Navega a la izquierda hasta encontrar el mínimo
        }
        return node; // Retorna el nodo con la clave más pequeña
    }

    // Método para eliminar un nodo por clave
    public Object remove(int k) {
        Node nodeToRemove = find(k);
        if (nodeToRemove != null) {
            Object data = nodeToRemove.getData();
            remove(nodeToRemove);
            return data;
        }
        return null; // No se encontró el nodo
    }
}
