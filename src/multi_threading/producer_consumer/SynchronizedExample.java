package multi_threading.producer_consumer;

import java.util.ArrayDeque;
import java.util.Queue;

public class SynchronizedExample {
    private int queueSize = 10;
    private Queue<String> queue = new ArrayDeque<>(queueSize);

    public static void main(String[] args) {
        SynchronizedExample example = new SynchronizedExample();
        //producer
        new Thread(()->{
            while (true){
                try {
                    synchronized (example) {
                        if (10 - example.queue.size() > 0) {
                            example.queue.add("生产元素");
                            System.out.println("向队列插入一个元素，队列剩余空间：" + (example.queueSize - example.queue.size()));
                        }
                    }
                    int ran = (int) (Math.random() * 1000.0) + 1;
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
                    synchronized (example) {
                        if (example.queue.size() > 0) {

                            example.queue.remove();
                            System.out.println("从队列取走一个元素，队列剩余" + (example.queue.size()));

                        }
                    }
                    int ran = (int) (Math.random() * 1000.0) + 1;
                    Thread.sleep(ran);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
        }).start();

    }

}
