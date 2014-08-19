/*
* (c) 2003-2014 MuleSoft, Inc. This software is protected under international copyright
* law. All use of this software is subject to MuleSoft's Master Subscription Agreement
* (or other master license agreement) separately entered into in writing between you and
* MuleSoft. If such an agreement is not in place, you may not use the software.
*/

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
