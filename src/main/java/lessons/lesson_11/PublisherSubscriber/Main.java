package lessons.lesson_11.PublisherSubscriber;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Object lock = new Object();

        Publisher publisher = new Publisher(queue, lock);
        Subscriber subscriber = new Subscriber(queue, lock);

        publisher.start();
        subscriber.start();


    }
}
