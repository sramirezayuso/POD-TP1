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
