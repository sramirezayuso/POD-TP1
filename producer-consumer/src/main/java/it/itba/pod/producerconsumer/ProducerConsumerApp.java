/*
* (c) 2003-2014 MuleSoft, Inc. This software is protected under international copyright
* law. All use of this software is subject to MuleSoft's Master Subscription Agreement
* (or other master license agreement) separately entered into in writing between you and
* MuleSoft. If such an agreement is not in place, you may not use the software.
*/

package it.itba.pod.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerApp
{
    private static int MAX_SIZE = 100;

    public static void main(String[] args)
    {
        Queue<String> queue = new LinkedList<String>();

        Thread producer1 = new Thread(new Producer(queue, MAX_SIZE));
        Thread producer2 = new Thread(new Producer(queue, MAX_SIZE));
        Thread producer3 = new Thread(new Producer(queue, MAX_SIZE));
        Thread producer4 = new Thread(new Producer(queue, MAX_SIZE));

        Thread consumer1 = new Thread(new Consumer(queue));
        Thread consumer2 = new Thread(new Consumer(queue));

        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();

        consumer1.start();
        consumer2.start();
    }
}
