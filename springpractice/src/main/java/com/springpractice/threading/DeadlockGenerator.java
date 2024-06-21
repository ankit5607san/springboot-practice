package com.springpractice.threading;

public class DeadlockGenerator
{
    final static String R1 = "Hello Welcome to Scaler!";
    final static String R2 = "Visit Scaler!";

    public static void main(String[] args)
    {
        try
        {
            Thread t1 = new Thread(() ->
            {
                synchronized (R1)
                {
                    System.out.println("Thread t1 locked  > R1");

                    synchronized (R2)
                    {
                        System.out.println("Thread t1 locked > R2");
                    }
                }
            });

            Thread t2 = new Thread(() ->
            {
                synchronized (R2)
                {
                    System.out.println("Thread t2 locked  > R2");

                    synchronized (R1)
                    {
                        System.out.println("Thread t2 locked > R1");
                    }
                }
            });

            t1.start();
            t2.start();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
