package it.itba.pod.counter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class Counter implements Runnable
{
    private static final Logger LOGGER = Logger.getLogger(Counter.class.getName());

    private AtomicInteger counter;

    public Counter(AtomicInteger counter)
    {
        this.counter = counter;
    }

    @Override
    public void run()
    {
        for(int i = 0; i < 1000; i++)
        {
            counter.addAndGet(1);
        }
    }
}
