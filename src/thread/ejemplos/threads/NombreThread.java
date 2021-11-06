package thread.ejemplos.threads;

public class NombreThread extends Thread{

    // Importante! Heredar de Thread

    // Opcionalmente implementar un constructor para personalizar el nombre
    public NombreThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("se inicia el run del hilo " + getName());

        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName());
        }
        System.out.println("finaliza el hilo");
    }
}
