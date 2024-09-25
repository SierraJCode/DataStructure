package Run;

import Trees.BinarySearchTree;
import Trees.OrderTree;
import Trees.BinaryTree;
import Trees.BSTEntry;

public class RunTree {
    
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        
        // Insertar nuevos datos
        bst.insert("Object 1", 50);
        bst.insert("Object 2", 30);
        bst.insert("Object 3", 70);
        bst.insert("Object 4", 20);
        bst.insert("Object 5", 40);
        bst.insert("Object 6", 60);
        bst.insert("Object 7", 80);

        // Buscar valor máximo
        BinaryTree.Node maxNode = bst.findMax();
        if (maxNode != null) {
            System.out.println("Valor máximo en el árbol: " + ((BSTEntry) maxNode.getData()).getData() +
                               " con clave: " + ((BSTEntry) maxNode.getData()).getKey());
        }

        // Buscar valor mínimo
        BinaryTree.Node minNode = bst.findMin();
        if (minNode != null) {
            System.out.println("Valor mínimo en el árbol: " + ((BSTEntry) minNode.getData()).getData() +
                               " con clave: " + ((BSTEntry) minNode.getData()).getKey());
        }
        
        System.out.println("Árbol después de insertar los elementos:");
        mostrarArbol(bst.root(), 0);

        // Eliminar un objeto dada la clave
        int claveAEliminar = 30;
        System.out.println("\nEliminando el objeto con clave: " + claveAEliminar);
        bst.remove(claveAEliminar);

        System.out.println("Árbol después de eliminar el elemento: " + claveAEliminar);
        mostrarArbol(bst.root(), 0);


        // Buscar un objeto dada la clave
        int claveABuscar = 50;
        System.out.println("\nBuscando el objeto con clave: " + claveABuscar);
        BinaryTree.Node nodoEncontrado = bst.find(claveABuscar);
        if (nodoEncontrado != null) {
            System.out.println("Objeto encontrado: " + ((BSTEntry) nodoEncontrado.getData()).getData());
        } else {
            System.out.println("Objeto no encontrado.");
        }

        // Recorridos
        System.out.println("Recorrido inorder:");
        OrderTree.inorder(bst, bst.root());
        System.out.println("\nRecorrido preorder:");
        OrderTree.preorder(bst, bst.root());
        System.out.println("\nRecorrido posorder:");
        OrderTree.posorder(bst, bst.root());
    }


    // Método para mostrar el árbol de manera visual
    public static void mostrarArbol(BinaryTree.Node nodo, int nivel) {
        if (nodo != null) {
            mostrarArbol(nodo.getRight(), nivel + 1);
            System.out.println(" ".repeat(nivel * 4) + ((BSTEntry) nodo.getData()).getKey());
            mostrarArbol(nodo.getLeft(), nivel + 1);
        }
    }
}
