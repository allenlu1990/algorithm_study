package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<T> {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue queue =  new LinkedList<T>();

    private int capacity;

    public MyBlockingQueue(int capatity) {
        this.capacity = capatity;
    }

    public <T> void add(T object){
        try {
            lock.lock();
            if(queue.size() >= capacity){
                throw new RuntimeException("queue out of capacity");
            }
            queue.add(object);
        }finally {
            lock.unlock();
        }
    }

    public T remove(){
        try {
            lock.lock();
            if(queue.isEmpty()){
                throw new RuntimeException("queue is empty");
            }
            return (T)queue.remove();
        }finally {
            lock.unlock();
        }
    }



    public <T> void put(T object) throws InterruptedException {
        try {
            lock.lock();
            while (queue.size() >= capacity){
                System.out.println("满了");
                condition.await();
            }
            queue.add(object);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        try {
            lock.lock();
            while (queue.isEmpty()){
                System.out.println("空了");
                condition.await();
            }
            T remove = (T) queue.remove();
            condition.signalAll();
            return remove;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyBlockingQueue<String> myBlockingQueue2 = new MyBlockingQueue<>(5);

        new Thread(()-> {
            while (true){
                String remove1 = null;
                try {
                    remove1 = myBlockingQueue2.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("出: "+ remove1);
                try {
                    int ran = (int)(Math.random()*1000);
                    Thread.sleep(ran);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()-> {
            int i =0;
            while (i <1000){
                try {
                    myBlockingQueue2.put(""+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("进: " +i++ );
                try {
                    int ran = (int)(Math.random()*1000);
                    Thread.sleep(ran);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

}
