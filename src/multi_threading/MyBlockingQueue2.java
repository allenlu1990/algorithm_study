package multi_threading;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue2<T> {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<T> queue = new LinkedList<>();

    private Integer maxNumber;

    public MyBlockingQueue2() {
        this(Integer.MAX_VALUE);
    }

    public MyBlockingQueue2(int number) {
        maxNumber = number;
    }

    public void put(T object){
        try {
            lock.lock();
            while (queue.size() == maxNumber){
                try {
                    System.out.println("已超上限"+queue.size());
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.add(object);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void add(T object){
        try {
            lock.lock();
            if (queue.size() == maxNumber){
                throw new IllegalStateException("queue is full");
            }
            queue.add(object);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public T take() {
        try{
            lock.lock();
            while (queue.isEmpty()){
                try {
                    System.out.println("队列为空"+queue.size());
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T remove = queue.remove();
            condition.signalAll();
            return remove;
        }finally {
            lock.unlock();
        }
    }

    public T remove() {
        try{
            lock.lock();
            if (queue.isEmpty()){
              throw new NoSuchElementException("queue is empty");
            }
            T remove = queue.remove();
            condition.signalAll();
            return remove;
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue2<String> myBlockingQueue2 = new MyBlockingQueue2<>(20);

        new Thread(()-> {
                while (true){
                    String remove1 = myBlockingQueue2.take();
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
                    myBlockingQueue2.put(""+i);
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
