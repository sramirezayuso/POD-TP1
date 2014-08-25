package it.itba.pod.helloworld;

import java.util.logging.Logger;

public class HelloWorld implements Runnable
{

    private static final Logger LOGGER = Logger.getLogger(HelloWorld.class.getName());

    private int delay;

    public HelloWorld(int delay)
    {
        this.delay = delay;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                Thread.sleep(delay * 1000);
                long threadId = Thread.currentThread().getId();
                LOGGER.info("Hello World! - Thread ID: " + threadId);
            } catch (InterruptedException e)
            {
                //Should not happen
                LOGGER.severe("This shouldn't have happened!");
            }
        }
    }
}
