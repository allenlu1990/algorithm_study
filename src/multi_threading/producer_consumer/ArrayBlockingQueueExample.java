package multi_threading.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueExample {
    private int queueSize = 10;
    private ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(queueSize);

    public static void main(String[] args) {
        ArrayBlockingQueueExample example = new ArrayBlockingQueueExample();
        //producer
        new Thread(()->{
                while (true){
                    try {
                        int ran=(int)Math.random()*1000+1;
                        example.queue.put("product new thing");
                        System.out.println("向队列插入一个元素，队列剩余空间：" + (example.queueSize - example.queue.size()));
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
                    int ran=(int)Math.random()*1000+1;
                    example.queue.take();
                    System.out.println("从队列取走一个元素，队列剩余" + (example.queueSize - example.queue.size()));
                    Thread.sleep(ran);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }


}
