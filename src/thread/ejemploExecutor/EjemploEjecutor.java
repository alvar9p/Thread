package thread.ejemploExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploEjecutor {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable tarea = () -> {
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("Nombre del thread " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Interrumpir ejecución actual
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea");
        };
        executor.submit(tarea);
        executor.shutdown(); // Termina
        System.out.println("Continuando con la ejecución del método main 1");
        executor.awaitTermination(2, TimeUnit.SECONDS); // Finaliza todas las tareas o espera timeout
        System.out.println("Continuando con la ejecución del método main 2");
    }
}
