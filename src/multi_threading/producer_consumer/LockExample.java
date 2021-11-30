package multi_threading.producer_consumer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private int queueSize = 10;
    private Queue<String> queue = new ArrayDeque<>(queueSize);

    public static void main(String[] args) {
        LockExample example = new LockExample();
        ReentrantLock lock = new ReentrantLock();
        //producer
        new Thread(()->{
            while (true){
                try {
                    int ran = (int) (Math.random() * 1000.0) + 1;
                    lock.lock();
                    if(10 - example.queue.size() >0) {
                        example.queue.add("生产元素");
                        System.out.println("向队列插入一个元素，队列剩余空间：" + (example.queueSize - example.queue.size()));
                    }
                    lock.unlock();
                    Thread.sleep(ran);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //consumer
        new Thread(()->{
            while (true){
                try {
                int ran = (int) (Math.random() * 1000.0) + 1;
                lock.lock();
                if (example.queue.size() > 0) {
                    example.queue.remove();
                    System.out.println("从队列取走一个元素，队列剩余：" + example.queue.size());
                }
                lock.unlock();
                Thread.sleep(ran);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

}
