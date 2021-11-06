package thread.ejemplos;

import thread.ejemplos.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {
        Thread hilo = new NombreThread("Jhon Doe");
        hilo.start(); // Se inicializa con start()
        // Thread.sleep(2); // Como varía si colocamos una pequeña pausa

        Thread hilo2 = new NombreThread("María");
        hilo2.start();

        Thread hilo3 = new NombreThread("Pepe");
        hilo3.start();

        System.out.println(hilo.getState()); // Imprime el estado

    }
}
