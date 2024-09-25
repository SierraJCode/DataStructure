package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    // Clase Nodo para representar los nodos del árbol
    public static class Node {
        public Object data;
        public Node left, right;

        public Node(Object data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Object getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public Node root;
    public int size;

    // Constructor vacío
    public BinaryTree() {
        root = null;
        size = 0;
    }

    // Tamaño del árbol
    public int size() {
        return size;
    }

    // Verificar si el árbol está vacío
    public boolean isEmpty() {
        return size == 0;
    }

    // Métodos booleanos
    public boolean isRoot(Node v) {
        return v == root;
    }

    public boolean isInternal(Node v) {
        return hasLeft(v) || hasRight(v);
    }

    public boolean hasLeft(Node v) {
        return v.getLeft() != null;
    }

    public boolean hasRight(Node v) {
        return v.getRight() != null;
    }

    // Métodos de altura y profundidad
    public int depth(Node v) {
        if (isRoot(v)) {
            return 0;
        } else {
            return 1 + depth(parent(v));
        }
    }

    public int height(Node v) {
        if (!isInternal(v)) {
            return 0;
        } else {
            int h = 0;
            h = Math.max(height(v.getLeft()), height(v.getRight()));
            return 1 + h;
        }
    }

    // Métodos de acceso a nodos
    public Node root() {
        return root;
    }

    public Node left(Node v) {
        return v.getLeft();
    }

    public Node right(Node v) {
        return v.getRight();
    }

    public Node parent(Node v) {
        if (isRoot(v)) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node temp = root;

        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.getLeft() == v || temp.getRight() == v) {
                return temp;
            }

            if (hasLeft(temp)) {
                queue.add(left(temp));
            }

            if (hasRight(temp)) {
                queue.add(right(temp));
            }
        }

        return null;
    }

    // Métodos para agregar datos
    public void addRoot(Object e) {
        root = new Node(e);
        size = 1;
    }

    public void insertLeft(Node v, Object e) {
        Node left = new Node(e);
        v.setLeft(left);
        size++;
    }

    public void insertRight(Node v, Object e) {
        Node right = new Node(e);
        v.setRight(right);
        size++;
    }

    // Métodos para eliminar un nodo
    public void remove(Node v) {
        Node p = parent(v);

        if (hasLeft(v) || hasRight(v)) {
            Node child;
            if (hasLeft(v)) {
                child = left(v);
            } else {
                child = right(v);
            }

            if (left(p) == v) {
                p.setLeft(child);
            } else {
                p.setRight(child);
            }

            v.setLeft(null);
            v.setRight(null);
        } else {
            if (left(p) == v) {
                p.setLeft(null);
            } else {
                p.setRight(null);
            }
        }

        size--;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.addRoot(1); // Agregar raíz
        Node root = tree.root();
        tree.insertLeft(root, 2);  // Insertar hijo izquierdo
        tree.insertRight(root, 3); // Insertar hijo derecho

        System.out.println("Root: " + root.getData());
        System.out.println("Left child of root: " + tree.left(root).getData());
        System.out.println("Right child of root: " + tree.right(root).getData());
        System.out.println("Tree size: " + tree.size());
    }
}
