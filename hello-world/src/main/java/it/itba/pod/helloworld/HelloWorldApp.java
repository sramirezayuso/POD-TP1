package it.itba.pod.helloworld;

public class HelloWorldApp
{
    private static final int THREAD_NUM = 10;

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
