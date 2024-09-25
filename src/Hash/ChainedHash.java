package Hash;

import Nodes.DoubleList;
import Nodes.DoubleNode;
import Usuario.Usuario;

import java.util.Random;
import java.util.Arrays;

public class ChainedHash {
    private DoubleList[] table; // Array de listas dobles
    private int size;
    private String hashMethod; // Método de hash (división o multiplicación)

    // Constructor
    public ChainedHash(int m, String method) {
        this.size = m;
        this.hashMethod = method.toLowerCase(); // Normaliza el método a minúsculas
        this.table = new DoubleList[m];
        for (int i = 0; i < m; i++) {
            table[i] = new DoubleList(); // Inicializa cada lista en el arreglo
        }
    }

    // Función Hash usando el método de la división
    private int hashDivision(int key) {
        return key % size;
    }

    // Función Hash usando el método de la multiplicación
    private int hashMultiplication(int key) {
        double A = (Math.sqrt(5) - 1) / 2; // Constante A (número áureo)
        return (int) (size * ((key * A) % 1)); // Redondeo hacia abajo
    }

    // Método Hash que selecciona el método según el constructor
    private int hash(int key) {
        if (hashMethod.equals("d")) {
            return hashDivision(key);
        } else if (hashMethod.equals("m")) {
            return hashMultiplication(key);
        } else {
            throw new IllegalArgumentException("Método de hash no válido: " + hashMethod);
        }
    }

    // Insertar un nuevo dato
    public void insert(int key, Object value) {
        int index = hash(key);
        table[index].addLast(new Entry(key, value)); // Añade una nueva entrada
    }

    // Buscar un dato dada su clave
    public Object search(int key) {
        int index = hash(key);
        DoubleNode currentNode = table[index].first();
        while (currentNode != null) {
            Entry entry = (Entry) currentNode.getData();
            if (entry.getKey() == key) {
                return entry.getValue();
            }
            currentNode = currentNode.getNext();
        }
        return null; // No se encontró el elemento
    }

    // Eliminar un dato dada su clave
    public Object remove(int key) {
        int index = hash(key);
        DoubleNode currentNode = table[index].first();
        while (currentNode != null) {
            Entry entry = (Entry) currentNode.getData();
            if (entry.getKey() == key) {
                table[index].remove(currentNode); // Elimina el nodo de la lista
                return entry.getValue(); // Retorna el valor eliminado
            }
            currentNode = currentNode.getNext();
        }
        return null; // No se encontró el elemento
    }

    // Clase interna para almacenar la clave y el valor
    private static class Entry {
        private int key;
        private Object value;

        public Entry(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Key: " + key + ", Value: " + value.toString();
        }
    }

    // Método para imprimir la tabla hash
    public void displayTable() {
        for (int i = 0; i < size; i++) {
            System.out.print("Indice " + i + ": ");
            if (table[i].isEmpty()) {
                System.out.println("Vacio");
            } else {
                table[i].fullNodes(); // Mostrar todos los nodos de la lista en este índice
            }
        }
    }

    public void showDataInEachPosition() {
        for (int i = 0; i < size; i++) {
            System.out.println("Posicion " + i + ": " + table[i].size() + " elementos almacenados.");
        }
    }
    

    public static void main(String[] args) {
        // Creamos una tabla hash con encadenamiento, tamaño 10 y método de la división como función hash
        ChainedHash hashTable = new ChainedHash(10, "m");

        // Insertamos algunos valores
        hashTable.insert(1, "Data 1");
        hashTable.insert(2, "Data 2");
        hashTable.insert(15, "Data 15"); // Colisión con clave 1 si se usa el método de la división
        hashTable.insert(20, "Data 20");

        // Probamos buscar algunos valores
        System.out.println("Buscar clave 1: " + hashTable.search(1));
        System.out.println("Buscar clave 15: " + hashTable.search(15));
        System.out.println("Buscar clave 2: " + hashTable.search(2));
        System.out.println("Buscar clave 20: " + hashTable.search(20));
        System.out.println("Buscar clave 5 (no existe): " + hashTable.search(5));

        // Probamos eliminar algunos valores
        System.out.println("Eliminar clave 15: " + hashTable.remove(15));
        System.out.println("Eliminar clave 1: " + hashTable.remove(1));

        // Intentamos buscar los valores eliminados
        System.out.println("Buscar clave 15 después de eliminar: " + hashTable.search(15));
        System.out.println("Buscar clave 1 después de eliminar: " + hashTable.search(1));

        System.out.println("Elementos de la tabla hash:");
        hashTable.displayTable();

        //  ===========================  2nd Test  ===========================  //
        System.out.println("\n //  ===========================  2nd Test  ===========================  // \n");
        
        ChainedHash hashTable2 = new ChainedHash(10, "m");

        int[] randomNumbers = new Random().ints(20, 0, 101).toArray();

        for (int i = 0; i < randomNumbers.length; i++) {
            hashTable2.insert(randomNumbers[i], randomNumbers[i]);
        }
        System.out.println("Numeros: " + Arrays.toString(randomNumbers));
        System.out.println("Buscar clave " + randomNumbers[4] + ": " + hashTable2.search(randomNumbers[4]));
        System.out.println("Eliminar " + randomNumbers[4] + ": " + hashTable2.remove(randomNumbers[4]));
        System.out.println("Buscar clave " + randomNumbers[4] + ": " + hashTable2.search(randomNumbers[4]));

        System.out.println("\n //  ===========================  3th Test  ===========================  // \n");

        ChainedHash hashTable3 = new ChainedHash(5, "d");

        Usuario user1 = new Usuario(1111, "Jose");
        Usuario user2 = new Usuario(2222, "Maria");
        Usuario user3 = new Usuario(3333, "Carlos");
        Usuario user4 = new Usuario(4444, "Ximena");
        Usuario user5 = new Usuario(5555, "Manuel");
        Usuario user6 = new Usuario(6666, "Angel");
    
        hashTable3.insert((int)user1.getId(), user1.getNombre());
        hashTable3.insert((int)user2.getId(), user2.getNombre());
        hashTable3.insert((int)user3.getId(), user3.getNombre());
        hashTable3.insert((int)user4.getId(), user4.getNombre());
        hashTable3.insert((int)user5.getId(), user5.getNombre());
        hashTable3.insert((int)user6.getId(), user6.getNombre());
        
        hashTable3.showDataInEachPosition();

    }
}
