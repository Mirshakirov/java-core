package lessons.lesson_11.PublisherSubscriber;

import java.util.Queue;
import java.util.Scanner;

public class Subscriber extends Thread{
    private Queue<String> queue;
    private Object lock;
    private Scanner scanner = new Scanner(System.in);

    Subscriber(Queue<String> queue, Object lock){
        this.queue = queue;
        this.lock = lock;
    }
    @Override
    public void run(){
        while(true){
            String word;
            synchronized(lock){
                while(queue.isEmpty()){
                    try{
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                word = queue.poll();
            }
            System.out.println("Word: " + word);
        }
    }
}
