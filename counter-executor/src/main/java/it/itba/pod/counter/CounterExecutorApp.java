package it.itba.pod.counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class CounterExecutorApp
{
    private static final Logger LOGGER = Logger.getLogger(CounterExecutorApp.class.getName());

    private static final int THREAD_NUM = 4;

    private static final ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args)
    {
        AtomicInteger globalCounter = new AtomicInteger();
        for (int i = 0; i < THREAD_NUM; i++)
        {
            Counter counter =  new Counter(globalCounter);
            executor.execute(counter);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            LOGGER.info("" + globalCounter);
        } catch (InterruptedException e) {
            // Should not happen
        }

    }
}
