package it.itba.pod.deadlock;

import java.util.logging.Logger;

public class Deadlock {

    private static final Logger LOGGER = Logger.getLogger(Deadlock.class.getName());

    public static void main(String a[])
    {
        final Object object1 = new Object();
        final Object object2 = new Object();

        Thread thread1 = new Thread("Thread 1")
        {
            public void run()
            {
                while(true)
                {
                    synchronized(object1)
                    {
                        synchronized(object2)
                        {
                            LOGGER.info("Inside Thread 1!");
                        }
                    }
                }
            }
        };

        Thread thread2 = new Thread("Thread 2")
        {
            public void run()
            {
                while(true)
                {
                    synchronized(object2)
                    {
                        synchronized(object1)
                        {
                            LOGGER.info("Inside Thread 2!");
                        }
                    }
                }
            }
        };

        thread1.start();
        thread2.start();
    }
}
