public class MainConcurrency {

    private static final Object LOCK = new Object();
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("Name: " + Thread.currentThread().getName() + ", State: " + Thread.currentThread().getState());
        });
        thread1.start();

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    inc(LOCK);
                }
            }).start();
        }

        Thread.sleep(5000);
        System.out.println(counter);
    }

    private static synchronized void inc(Object LOCK) {
        double tmp = Math.sin(13.);
        synchronized (LOCK) {
            counter++;
        }
    }

}
