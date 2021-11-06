package thread.ejemplos;

import thread.ejemplos.runneable.ViajeTarea;

public class EjemploInterfaceRunneable {
    public static void main(String[] args) {

        // Se puede instanciar el obj o colocar .start() para iniciar
        new Thread(new ViajeTarea("Isla de Pascua")).start();
        new Thread(new ViajeTarea("Robinson Crusoe")).start();
        new Thread(new ViajeTarea("Juan Fernández")).start();
        new Thread(new ViajeTarea("Isla de Chiloé")).start();
    }
}
