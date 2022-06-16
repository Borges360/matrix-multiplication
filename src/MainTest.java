import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class MainTest {

    private static int REPETICOES = 10;

    public synchronized static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger();
        CountDownLatch latchA = new CountDownLatch((int) (Math.pow(REPETICOES, 3)));
        Thread thread = new Thread(() -> {

            AtomicInteger i = new AtomicInteger();
            for (i.get(); i.get() < REPETICOES; i.getAndIncrement()) {
                Thread thread1 = new Thread() {
                    final int newI = i.get();

                    @Override
                    public void run() {
                        AtomicInteger j = new AtomicInteger();
                        for (j.get(); j.get() < REPETICOES; j.getAndIncrement()) {
                            Thread thread2 = new Thread() {
                                final int newj = j.get();

                                @Override
                                public void run() {
                                    AtomicInteger k = new AtomicInteger();
                                    for (k.get(); k.get() < REPETICOES; k.getAndIncrement()) {
                                        Thread thread3 = new Thread() {
                                            final int newk = k.get();

                                            @Override
                                            public void run() {
                                                final int newk = k.get();
                                                count.getAndIncrement();
//                                              System.out.println("Thread - " + "\tI:\t" + i.get() + "\tj:\t" + j.get() + "\tk:\t" + k.get());
                                                System.out.println("Thread - " + "\tI:\t" + newI + "\tj:\t" + newj + "\tk:\t" + newk);
                                                latchA.countDown();
                                            }
                                        };
                                        thread3.start();
                                    }
                                }
                            };
                            thread2.start();
                        }
                    }
                };
                thread1.start();
            }
        });
        double startTime = System.currentTimeMillis();
        thread.start();
        latchA.await();
        double stopTime = System.currentTimeMillis();
        System.out.println("Tempo de execução " + (stopTime - startTime) / 1000);
        System.out.println(count);

    }

}
