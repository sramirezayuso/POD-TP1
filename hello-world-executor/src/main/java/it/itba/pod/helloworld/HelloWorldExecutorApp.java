/*
* (c) 2003-2014 MuleSoft, Inc. This software is protected under international copyright
* law. All use of this software is subject to MuleSoft's Master Subscription Agreement
* (or other master license agreement) separately entered into in writing between you and
* MuleSoft. If such an agreement is not in place, you may not use the software.
*/

package it.itba.pod.helloworld;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class HelloWorldExecutorApp
{
    private static final int THREAD_NUM = 10;

    private static final Executor executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args)
    {
        for (int i = 0; i < THREAD_NUM; i++)
        {
            HelloWorld hw =  new HelloWorld(i + 1);
            executor.execute(hw);
        }
    }
}
