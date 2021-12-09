package multi_threading;

import multi_threading.producer_consumer.SynchronizedExample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private  Queue<String> queue = new LinkedList<>();

    public void add(String task){
        lock.lock();
        try {
            queue.add(task);
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }

    public String poll(){
        lock.lock();
        try{
            while (queue.isEmpty()){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.remove();
        }finally {
            lock.unlock();
        }
    }

}
