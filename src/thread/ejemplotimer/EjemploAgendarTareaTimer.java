package thread.ejemplotimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaTimer {
    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tarea realizada en: " + new Date() + " nombre del Thread: " +
                        Thread.currentThread().getName());
                System.out.println("Finaliza el tiempo");
                timer.cancel(); // Terminamos el timer ya que no lo ocupamos mas
            }
        }, 5000); // Tiempo en ms

        System.out.println("Agendamos una tarea para 5 segundos más...");
    }
}
