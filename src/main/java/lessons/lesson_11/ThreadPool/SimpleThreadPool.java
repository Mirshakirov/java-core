package lessons.lesson_11.ThreadPool;

import java.util.Queue;

public class SimpleThreadPool{
    private Queue<Runnable> tasksQueue;
    private int poolSize;


    SimpleThreadPool(Queue<Runnable> tasksQueue, int poolSize){
        this.tasksQueue = tasksQueue;
        this.poolSize = poolSize;
    }

    public void submit(Runnable runnable){

    }
}


