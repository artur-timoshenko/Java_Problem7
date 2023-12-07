class CyclicBarrier {
    private final int parties;
    private int count = 0;
    private int generation = 0;

    public CyclicBarrier(int parties) {
        this.parties = parties;
    }

    public synchronized void await() throws InterruptedException {
        int gen = generation;

        count++;

        if (count < parties) {
            while (gen == generation) {
                wait();
            }
        } else {
            count = 0;
            generation++;
            notifyAll();
        }
    }

    public synchronized void reset() {
        count = 0;
        generation++;
        notifyAll();
    }
}