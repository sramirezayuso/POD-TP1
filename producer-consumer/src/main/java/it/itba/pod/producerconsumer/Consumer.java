package it.itba.pod.producerconsumer;

import java.util.Queue;
import java.util.logging.Logger;

public class Consumer implements Runnable
{
    private static final Logger LOGGER = Logger.getLogger(Consumer.class.getName());

    private final Queue<String> queue;

    public Consumer(Queue<String> queue)
    {
        this.queue = queue;
    }

    private int countVowels(String string)
    {
        int vowelCount = 0;
        for (int i = 0; i < string.length(); ++i)
        {
            switch(string.charAt(i))
            {
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    vowelCount++;
                    break;
                default:
                    // do nothing
            }
        }
        return vowelCount;
    }

    public void consume()
    {
        synchronized (queue)
        {
            while (queue.isEmpty())
            {
                LOGGER.warning("Queue is empty!");
                try
                {
                    queue.wait();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            String randomString = queue.poll();
            int vowelCount = countVowels(randomString);
            LOGGER.info("Consumed " + randomString + " from queue! It has " + vowelCount + " vowels!");

            queue.notifyAll();
        }
    }

    @Override
    public void run() {
        while (true) {
            consume();
        }
    }
}
