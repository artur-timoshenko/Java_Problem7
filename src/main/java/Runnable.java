class MyRunnable implements Runnable {
    private final CyclicBarrier barrier;

    public MyRunnable(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " started");

            // Имитация работы потока
            Thread.sleep(1000);

            // Ждем остальные потоки на барьере
            barrier.await();

            System.out.println(Thread.currentThread().getName() + " resumed");

            // Продолжаем выполнение после прохождения барьера

            // После выполнения работы потока, если требуется повторное использование барьера:
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
