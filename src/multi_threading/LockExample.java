package multi_threading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample extends Thread{
    private ReentrantLock lock;

    public LockExample(String name, ReentrantLock lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true){
            int ran = (int) (Math.random() * 1000.0) + 1;
            try{
                if(lock.tryLock()){
                    System.out.println("线程"+ super.getName() +"获取到锁");
                    Thread.sleep(1000*10);
                    lock.unlock();
                }else {
                    System.out.println("线程"+ super.getName() +"尝试获取锁失败");
                }
                Thread.sleep(ran);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        LockExample lockA = new LockExample("A", lock);
        LockExample lockB = new LockExample("B", lock);
        lockA.start();
        lockB.start();
    }
}
