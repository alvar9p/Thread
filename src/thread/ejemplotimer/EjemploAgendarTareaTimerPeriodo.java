package thread.ejemplotimer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args) {

        // Toolkit toolkit = Toolkit.getDefaultToolkit(); // Sonido
        AtomicInteger contadorAtomic = new AtomicInteger(15);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            //private int contador = 3;

            @Override
            public void run() {
                int i = contadorAtomic.getAndDecrement();
                if ( i > 0){
                    // toolkit.beep(); // Sonido
                System.out.println("Tarea " +i+ " periódica en: " + new Date() + " nombre del Thread: " +
                        Thread.currentThread().getName());
                //contador --;
                }else{
                System.out.println("Finaliza el tiempo");
                timer.cancel(); // Terminamos el timer ya que no lo ocupamos mas
                }
            }
        }, 2000, 4000); // Tiempo en ms

        System.out.println("Agendamos una tarea para 2 segundos más...");
    }
}
