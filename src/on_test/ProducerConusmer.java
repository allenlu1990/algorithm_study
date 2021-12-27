package on_test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConusmer {
//    private volatile Queue queue = new LinkedList<String>();
    private LinkedList<String> queue = new LinkedList<>();
    private final Integer number;

    public ProducerConusmer(Integer number) {
        this.number = number;
    }

    public static void main(String[] args) {
        ProducerConusmer producerConusmer = new ProducerConusmer(200);
        LinkedList<String> queue = producerConusmer.queue;
        Integer number = producerConusmer.number;
        ReentrantLock lock = new ReentrantLock();

        //consumer
        new Thread(()->{
            while (true){
//                try {
//                    int time = (int) (Math.random() * 1000);
////                    int time = 1000;
//                    Thread.sleep(time);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                synchronized (queue){
                    if (!queue.isEmpty()){
                        int size = queue.size();
                        String remove = queue.remove(size-1);
//                        String remove = queue.remove();
                        System.out.println("remove "+ remove );
                    }else {
                        System.out.println("empty "+ queue.size());
                    }
                }
//                lock.lock();
//                try {
//                    if (!queue.isEmpty()){
//                        queue.remove();
//                        System.out.println("remove "+ queue.size());
//                    }else {
//                        System.out.println("empty "+ queue.size());
//                    }
//                }finally {
//                    lock.unlock();
//                }

            }
        }).start();

        //producer
        new Thread(()->{
            int i =0;
            while (true){
//                try {
//                    int time = (int) (Math.random() * 1000);
////                    int time = 2000;
//                    Thread.sleep(time);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                synchronized (queue){
                    if (queue.size() < number){
                        queue.add("go go" + i);
                        System.out.println("add "+ "go go" + i);
                        i++;
                    }else {
                        System.out.println("full "+ queue.size());
                    }
                }
//                lock.lock();
//                try{
//                    if (queue.size() < number){
//                        queue.add("go go");
//                        System.out.println("add "+ queue.size());
//                    }else {
//                        System.out.println("full "+ queue.size());
//                    }
//                }finally {
//                    lock.unlock();
//                }

            }

        }).start();


    }
}
