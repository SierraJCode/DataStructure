package SistemaDeCitas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import PilasColas.ListQueue;
import PilasColas.ListStack;
import Usuario.Usuario;

public class TurnoUsuario {
    ListQueue registro;
    ListStack usuariosAtendidos;

    public TurnoUsuario(){
        registro = new ListQueue();
        usuariosAtendidos = new ListStack();
    }

    public void registrar(Usuario e){
        registro.enqueue(e);
    }

    public void atenderSiguiente(){
        Object temp = registro.first();
        registro.dequeue();
        usuariosAtendidos.push(temp);
    }

    public void toFile() {
        
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("UsuariosPendientes.txt"))) {
                Object[] contents = registro.getContents();
                for (Object item : contents) {
                    writer.write(item.toString());
                    writer.newLine();
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("UsuariosAtendidos.txt"))) {
                Object[] contents = usuariosAtendidos.getContents();
                for (Object item : contents) {
                    writer.write(item.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
