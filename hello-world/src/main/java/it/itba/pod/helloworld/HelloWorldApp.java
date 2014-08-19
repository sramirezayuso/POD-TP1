/*
* (c) 2003-2014 MuleSoft, Inc. This software is protected under international copyright
* law. All use of this software is subject to MuleSoft's Master Subscription Agreement
* (or other master license agreement) separately entered into in writing between you and
* MuleSoft. If such an agreement is not in place, you may not use the software.
*/

package it.itba.pod.helloworld;

public class HelloWorldApp
{
    public static final int THREAD_NUM = 10;

    public static void main(String[] args)
    {
        for (int i = 0; i < THREAD_NUM; i++)
        {
            HelloWorld hw =  new HelloWorld(i + 1);
            Thread hwThread = new Thread(hw);
            hwThread.start();
        }
    }
}
