/*
* (c) 2003-2014 MuleSoft, Inc. This software is protected under international copyright
* law. All use of this software is subject to MuleSoft's Master Subscription Agreement
* (or other master license agreement) separately entered into in writing between you and
* MuleSoft. If such an agreement is not in place, you may not use the software.
*/

package it.itba.pod.producerconsumerexecutor;

import it.itba.pod.producerconsumer.Consumer;
import it.itba.pod.producerconsumer.Producer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ProducerConsumerExecutorApp
{
    private static int MAX_QUEUE_SIZE = 100;

    private static int PRODUCER_THREAD_NUM = 4;

    private static int CONSUMER_THREAD_NUM = 2;

    private static final Executor executor = Executors.newFixedThreadPool(PRODUCER_THREAD_NUM + CONSUMER_THREAD_NUM);

    public static void main(String[] args)
    {
        Queue<String> queue = new LinkedList<String>();

        for (int i = 0; i < PRODUCER_THREAD_NUM; i++)
        {
            Producer producer =  new Producer(queue, MAX_QUEUE_SIZE);
            executor.execute(producer);
        }

        for (int i = 0; i < CONSUMER_THREAD_NUM; i++)
        {
            Consumer consumer =  new Consumer(queue);
            executor.execute(consumer);
        }
    }
}
