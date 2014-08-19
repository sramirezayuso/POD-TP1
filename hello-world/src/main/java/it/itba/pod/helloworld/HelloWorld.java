/*
* (c) 2003-2014 MuleSoft, Inc. This software is protected under international copyright
* law. All use of this software is subject to MuleSoft's Master Subscription Agreement
* (or other master license agreement) separately entered into in writing between you and
* MuleSoft. If such an agreement is not in place, you may not use the software.
*/

package it.itba.pod.helloworld;

import java.util.logging.Logger;

public class HelloWorld implements Runnable
{

    private static final Logger logger = Logger.getLogger(HelloWorld.class.getName());

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
                long threadId = Thread.currentThread().getId();
                logger.info("Hello World! - Thread ID: " + threadId);
                Thread.sleep(delay * 1000);
            } catch (InterruptedException e)
            {
                //Should not happen
                logger.severe("This shouldn't have happened!");
            }
        }
    }
}