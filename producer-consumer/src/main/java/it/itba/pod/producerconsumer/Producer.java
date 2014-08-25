package it.itba.pod.producerconsumer;

import java.util.Queue;
import java.util.Random;
import java.util.logging.Logger;

public class Producer implements Runnable
{
    private static final Logger LOGGER = Logger.getLogger(Producer.class.getName());
    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random rnd = new Random();

    private final Queue<String> queue;
    private int maxSize;

    public Producer(Queue<String> queue, int maxSize)
    {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    String randomString()
    {
        StringBuilder sb = new StringBuilder( 10 );
        for( int i = 0; i < 10; i++ )
        {
            sb.append(CHARS.charAt(rnd.nextInt(CHARS.length())));
        }
        return sb.toString();
    }

    public void produce()
    {
        synchronized (queue)
        {
            while (queue.size() >= maxSize)
            {
                LOGGER.warning("Queue is full!");
                try
                {
                    queue.wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            String randomString = randomString();
            queue.offer(randomString);

            LOGGER.info("Added " + randomString + " to queue!");

            queue.notifyAll();
        }
    }

    @Override
    public void run()
    {
        while (true)
        {
            produce();
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                // Souldn't happen
            }
        }
    }
}
