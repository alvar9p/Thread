package thread.ejemplos.runneable;

public class ViajeTarea implements Runnable{

    // Hay que implementar run

    // Como no implementamos de Thread, hay que tener atributos
    private String nombre;

    public ViajeTarea(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println(i + " - " + nombre);
            try {
                Thread.sleep(1000); // Puedo hacerlo con Math.random
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finalmente me voy de viaje a: " + nombre);
    }
}
