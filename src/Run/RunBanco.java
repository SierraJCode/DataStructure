package Run;

import SistemaDeCitas.TurnoUsuario;
import Usuario.Usuario;

public class RunBanco {

    TurnoUsuario turno = new TurnoUsuario();
    Usuario user1 = new Usuario(1, "Jose");
    Usuario user2 = new Usuario(2, "Maria");
    Usuario user3 = new Usuario(3, "Carlos");
    Usuario user4 = new Usuario(4, "Ximena");
    Usuario user5 = new Usuario(5, "Manuel");

    public void Run(){

        turno.registrar(user1);
        turno.registrar(user2);
        turno.registrar(user3);
        turno.registrar(user4);
        turno.registrar(user5);

        turno.toFile();   

        turno.atenderSiguiente();
        turno.atenderSiguiente();

        turno.toFile();        
    }
}
