package com.springpractice;

import java.util.HashSet;
import java.util.Set;

public class PublisherSubscriberDemo
{
    public static void main(String[] args)
    {
        Publisher publisher = new Publisher();

        Subscriber subscriber1 = new TextSubscriber();

        Subscriber subscriber2 = new TextSubscriber();

        publisher.subscribe(subscriber1);

        publisher.subscribe(subscriber2);

        publisher.publish(new TexMessage("Hi message first"));
        publisher.publish(new TexMessage("Hi message second"));
    }
}

interface Message
{
    String getMessage();
}

interface Subscriber
{
    void onMessage(Message message);
}

class TexMessage implements Message
{
    private final String content;

    public TexMessage(String content)
    {
        this.content = content;
    }

    @Override
    public String getMessage()
    {
        return content;
    }
}

class TextSubscriber implements Subscriber
{
    @Override
    public void onMessage(Message message)
    {
        System.out.println("Received Message => " + message.getMessage());
    }
}


class Publisher
{
    private final Set<Subscriber> subscribers;

    public Publisher()
    {
        this.subscribers = new HashSet<>();
    }

    public void subscribe(Subscriber subscriber)
    {
        this.subscribers.add(subscriber);
    }

    public void publish(Message message)
    {
        for (Subscriber subscriber : subscribers)
        {
            subscriber.onMessage(message);
        }
    }
}
