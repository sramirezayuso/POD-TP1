/*
* (c) 2003-2014 MuleSoft, Inc. This software is protected under international copyright
* law. All use of this software is subject to MuleSoft's Master Subscription Agreement
* (or other master license agreement) separately entered into in writing between you and
* MuleSoft. If such an agreement is not in place, you may not use the software.
*/

package it.itba.pod.helloworldexecutor;

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
