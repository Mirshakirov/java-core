package lessons.lesson_11.PublisherSubscriber;

import java.util.Queue;
import java.util.Scanner;

public class Publisher extends Thread{
    private Queue<String> queue;
    private Object lock;
    private Scanner scanner = new Scanner(System.in);

    Publisher(Queue<String> queue, Object lock){
        this.queue = queue;
        this.lock = lock;
    }

    @Override
    public void run() {
        while(true){
            String word = scanner.nextLine();
            synchronized(lock){
                queue.add(word);
                lock.notify();
            }
            if(word.equals("exit")){
                break;
            }
        }
    }
}
