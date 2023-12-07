import org.junit.Test;
import static org.junit.Assert.*;

public class CyclicBarrierTest {

    @Test
    public void testCyclicBarrier() throws InterruptedException {
        final int THREAD_COUNT = 5;
        final CyclicBarrier barrier = new CyclicBarrier(THREAD_COUNT);

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new MyRunnable(barrier));
            threads[i].start();
        }


        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i].join();
            assertFalse(threads[i].isAlive());
        }
    }

    @Test
    public void testResetCyclicBarrier() throws InterruptedException {
        final int THREAD_COUNT = 5;
        final CyclicBarrier barrier = new CyclicBarrier(THREAD_COUNT);

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new MyRunnable(barrier));
            threads[i].start();
        }


        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i].join();
            assertFalse(threads[i].isAlive());
        }


        barrier.reset();

        Thread[] newThreads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            newThreads[i] = new Thread(new MyRunnable(barrier));
            newThreads[i].start();
        }


        for (int i = 0; i < THREAD_COUNT; i++) {
            newThreads[i].join();
            assertFalse(newThreads[i].isAlive());
        }
    }
}
