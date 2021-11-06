package thread.ejemploExecutor;

import java.util.concurrent.*;

public class EjemploEjecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        // Con Executors.newFixedThreadPool(3) se ejecutan todas al mismo tiempo
        // Si pongo Executors.newFixedThreadPool(2), se ejecutan 2 y una queda en cola
        ExecutorService executor = Executors.newFixedThreadPool(2);

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

        Callable<Integer> tarea2 = () -> {
            System.out.println("Iniciando tarea 3...");
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };

        Future<String> resultado = executor.submit(tarea);
        Future<String> resultado2 = executor.submit(tarea);
        Future<Integer> resultado3 = executor.submit(tarea2);

        executor.shutdown(); // Termina
        System.out.println("Continuando con la ejecución del método main 1");

        // System.out.println(resultado.isDone());
        while (!(resultado.isDone() && resultado2.isDone() && resultado3.isDone())){ // Mientras no haya finalizado
            System.out.println(String.format("resultado1: %s - resultado2: %s - resultado3 %s",
                    resultado.isDone() ? "finalizó": "en proceso",
                    resultado2.isDone() ? "finalizó": "en proceso",
                    resultado3.isDone() ? "finalizó": "en proceso"));
            TimeUnit.MILLISECONDS.sleep(1000); // Queda en while hasta los 1500 ms
        }
        // get recibe parámetros y puede lanzar excepciones
        // Si demora más que el tiempo, lanza el error
        System.out.println("Obtenemos resultado1 " + resultado.get()); // get bloquea el thread actual, espera que finalice
        System.out.println("Finaliza la tarea: " + resultado.isDone());

        System.out.println("Obtenemos resultado2 " + resultado.get());
        System.out.println("Finaliza la tarea: " + resultado.isDone());

        System.out.println("Obtenemos resultado3 " + resultado.get());
        System.out.println("Finaliza la tarea: " + resultado.isDone());


    }
}
