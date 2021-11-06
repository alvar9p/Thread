package thread.tarea;
/* Para la tarea se pide implementar una clase llamada AlfanumericoTarea
que implemente la interface Runnabley tenga como atributo un enum llamado Tipo.
El enum Tipo tiene dos elementos NUMERO Y LETRA.
Si el tipo es NUMERO, mostrara los números del 1 al 10, excluyente el último.
Si el tipo es LETRA, mostrar las letras de la 'A' a la 'Z', inclusivo el último.
Crea un par de hilos de diferentes tipos y ejecutarlos. */

import java.util.concurrent.TimeUnit;

public class AlfanumericoTarea implements Runnable {

    private Tipo tipo;

    public AlfanumericoTarea(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {
        //Segun el tipo hace una u otra cosa
        try {
            switch (tipo) {
                case NUMERO -> {
                    for (int i = 1; i < 10; i++) {
                        System.out.println(i);
                        TimeUnit.SECONDS.sleep(1);
                    }
                }
                case LETRA -> {
                    for (char c = 'A'; c <= 'Z'; c++) {

                        System.out.println(c);
                        TimeUnit.SECONDS.sleep(1);

                    }
                }
            }
        } catch (InterruptedException ex) {
        }
    }
}