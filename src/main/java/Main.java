public class Main {
    public static void main(String[] args) {
        final int THREAD_COUNT = 5;
        CyclicBarrier barrier = new CyclicBarrier(THREAD_COUNT);

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new MyRunnable(barrier));
            threads[i].start();
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}