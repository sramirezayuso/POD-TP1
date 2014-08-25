package it.itba.pod.counter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class CounterApp
{
    private static final Logger LOGGER = Logger.getLogger(CounterApp.class.getName());

    private static final int THREAD_NUM = 4;

    public static void main(String[] args)
    {
        AtomicInteger globalCounter = new AtomicInteger();

        List<Thread> counterThreadList = new ArrayList<Thread>();

        for (int i = 0; i < THREAD_NUM; i++)
        {
            Counter counter =  new Counter(globalCounter);
            Thread counterThread = new Thread(counter);
            counterThreadList.add(counterThread);
            counterThread.start();
        }

        for (Thread counterThread : counterThreadList)
        {
            try
            {
                counterThread.join();
            }
            catch (InterruptedException e)
            {
                // Should not happen
            }
        }

        LOGGER.info("" + globalCounter);
    }
}
