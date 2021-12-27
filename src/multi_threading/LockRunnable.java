package multi_threading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockRunnable implements Runnable{
    private final ReentrantLock lock;
    private final Condition condition;

    public LockRunnable(ReentrantLock lock) {
        this.lock = lock;
        this.condition = lock.newCondition();
    }

    @Override
    public void run() {
        while (true){
            try{
                int ran = (int) (Math.random() * 1000.0) + 1;
                System.out.println(Thread.currentThread().getName() + "睡眠时间" + ran);
                Thread.sleep(ran);
                if(lock.tryLock()){

                    System.out.println(Thread.currentThread().getName() + "获取到锁");
                    Thread.sleep(1000);
                    lock.unlock();
//                    condition.await();
                }else {
                    System.out.println(Thread.currentThread().getName() + "尝试获取锁");
                }

            }catch (InterruptedException e ){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        LockRunnable lockRunnable = new LockRunnable(lock);
         new Thread(lockRunnable, "A").start();
         new Thread(lockRunnable, "B").start();
         new Thread(lockRunnable, "C").start();
         new Thread(lockRunnable, "D").start();


    }
}
