package lessons.lesson_11;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Object lock = new Object();

        Thread publisher = new Thread(new Publisher(queue, lock));
        Thread subscriber = new Thread(new Subscriber(queue, lock));

        publisher.start();
        subscriber.start();


    }
}
