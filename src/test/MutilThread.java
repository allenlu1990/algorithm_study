package test;

import java.util.concurrent.locks.ReentrantLock;

public class MutilThread implements Runnable{
    final ReentrantLock lock;
    private int number=0;

    public MutilThread(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run(){
        while (number < 5){
            try {
                number++;
                if(lock.tryLock()){
                    System.out.println(Thread.currentThread().getName()+"获取到锁");
                    number =0;
                    Thread.sleep(1000*1);

                    lock.unlock();
                }

                int ran = (int)(Math.random()*1000);
                Thread.sleep(ran);
                System.out.println(Thread.currentThread().getName()+"尝试获取锁");

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"退出"+number);

    }
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
         new Thread(new MutilThread(lock),"A").start();
         new Thread(new MutilThread(lock),"B").start();
         new Thread(new MutilThread(lock),"C").start();
        new Thread(new MutilThread(lock),"D").start();


    }


}
