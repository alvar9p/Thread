package thread.ejemplos;

public class EjemploInterfaceRunneableJava8Funcional {
    public static void main(String[] args) throws InterruptedException {

        Thread main = Thread.currentThread(); // Thread principal
        Runnable viaje = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    System.out.println(i + " - " + Thread.currentThread().getName());
                    // Método estático que retorna la instancia del hilo que se está ejecutando
                    try {
                        Thread.sleep((long) Math.random()*1000); // Puedo hacerlo con Math.random
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Finalmente me voy de viaje a: " + Thread.currentThread().getName());
                System.out.println(main.getState()); // Mostrar el estado
            }
        };
        Thread v1 = new Thread(viaje, "Isla de Pascua");
        Thread v2 = new Thread(viaje, "Robinson Crusoe");
        Thread v3 = new Thread(viaje, "Juan Fernández");
        Thread v4 = new Thread(viaje, "Isla de Chiloé");

        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v1.join();
        v2.join();
        v3.join();
        v4.join();

        // Thread.sleep(1000); // Espera 1000ms para ejecutar
        System.out.println("Continuando con la ejecución del método main: " +main.getName());
    }
}
