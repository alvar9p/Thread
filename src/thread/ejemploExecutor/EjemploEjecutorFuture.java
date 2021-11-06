package thread.ejemploExecutor;

import java.util.concurrent.*;

public class EjemploEjecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> tarea = () -> {
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("Nombre del thread " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Interrumpir ejecución actual
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea");
            return "Algun resultado importante de la tarea";
        };
        Future<String> resultado = executor.submit(tarea);
        executor.shutdown(); // Termina
        System.out.println("Continuando con la ejecución del método main 1");

        // System.out.println(resultado.isDone());
        while (!resultado.isDone()){ // Mientras no haya finalizado
            System.out.println("Ejecutando tarea...");
            TimeUnit.MILLISECONDS.sleep(1500); // Queda en while hasta los 1500ms
        }
        // get recibe parámetros y puede lanzar excepciones
        // Si demora más que el tiempo, lanza el error
        System.out.println("Obtenemos resultado " + resultado.get()); // get bloquea el thread actual, espera que finalice
        System.out.println("Finaliza la tarea: " + resultado.isDone());

    }
}
