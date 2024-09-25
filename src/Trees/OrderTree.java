package Trees; 

public class OrderTree {

    // Método para recorrido posorder
    public static void posorder(BinaryTree T, BinaryTree.Node v) {
        if (v == null) return;
        if (T.hasLeft(v)) {
            posorder(T, T.left(v));
        }
        if (T.hasRight(v)) {
            posorder(T, T.right(v));
        }
        visit(v);
    }

    // Método para recorrido preorder
    public static void preorder(BinaryTree T, BinaryTree.Node v) {
        if (v == null) return;
        visit(v);
        if (T.hasLeft(v)) {
            preorder(T, T.left(v));
        }
        if (T.hasRight(v)) {
            preorder(T, T.right(v));
        }
    }

    // Método para recorrido inorder
    public static void inorder(BinaryTree T, BinaryTree.Node v) {
        if (v == null) return;
        if (T.hasLeft(v)) {
            inorder(T, T.left(v));
        }
        visit(v);
        if (T.hasRight(v)) {
            inorder(T, T.right(v));
        }
    }

    // Método visit para mostrar la clave del nodo
    private static void visit(BinaryTree.Node v) {
        System.out.print(((BSTEntry) v.getData()).getKey() + " ");
    }
}
