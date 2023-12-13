import java.util.concurrent.Semaphore;

public class LectorEscritor {
        private static final int MAX_LECTORES = 10;

        private static int numLectores = 0;

        private static Semaphore mutex = new Semaphore(1);
        private static Semaphore lectores = new Semaphore(MAX_LECTORES);
        private static Semaphore escritores = new Semaphore(3);

        public static void main(String[] args) {
            // Creamos un hilo lector
            Thread lector = new Thread(() -> {
                while (true) {
                    try {
                        // Obtenemos el mutex
                        mutex.acquire();

                        // Aumentamos el número de lectores
                        numLectores++;

                        // Liberamos el mutex
                        mutex.release();

                        // Leemos el recurso
                        System.out.println("Lector: Leyendo el recurso");

                        // Dormimos el hilo durante un segundo
                        Thread.sleep(1000);

                        // Decrementamos el número de lectores
                        numLectores--;

                        // Liberamos el mutex
                        mutex.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            // Creamos un hilo escritor
            Thread escritor = new Thread(() -> {
                while (true) {
                    try {
                        // Obtenemos el mutex
                        mutex.acquire();

                        // Si hay lectores o hay otros escritores esperando, esperamos a que terminen
                        while (numLectores > 0 || escritores.hasQueuedThreads()) {
                            escritores.acquire();
                        }

                        // Escribimos en el recurso
                        System.out.println("Escritor: Escribiendo en el recurso");

                        // Dormimos el hilo durante un segundo
                        Thread.sleep(1000);

                        // Liberamos el mutex
                        mutex.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            // Creamos otros 2 hilos escritores
            Thread escritor1 = new Thread(escritor);
            Thread escritor2 = new Thread(escritor);

            // Iniciamos los hilos
            lector.start();
            escritor.start();
            escritor1.start();
            escritor2.start();
        }
    }
