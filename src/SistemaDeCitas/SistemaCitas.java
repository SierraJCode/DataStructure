package SistemaDeCitas;

import java.util.*;
import PilasColas.*;
import Usuario.Usuario;

public class SistemaCitas {

    Scanner sc = new Scanner(System.in);
    ListQueue colaBanco = new ListQueue();

    public void pedirCredenciales(){
        System.out.println("===== Ingresar al sistema =====");
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.next();
        System.out.println("Ingrese su id: ");
        Long id = sc.nextLong();

        ingresar(nombre, id);
    }

    public void ingresar(String nombre, Long id){
        Usuario persona = new Usuario(id, nombre);
        colaBanco.enqueue(persona);
    }
}
