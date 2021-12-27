package SingletonExamples;

public class LazySingleton {
    /**
    * instance = new LazySingleton();
     * 这一步在JVM中为三步：
     * 1.为 LazySingle 分配内存空间，对内存清零
     * 2.执行 LazySingle 的构造函数，初始化对象
     * 3.将 single 指向分配的内存地址（执行完这步 single就为非 null 了）
     * 由于编译器会进行指令重排序（两个执行步骤没有数据依赖的时候，可能会进行执行顺序的重新排序），
     * 会有可能导致先执行3步骤，还没有执行步骤2时，其余线程如果获取到锁，instance已经不为null
     * 但是还没有初始化instance，所以就会出现问题，加了volatile可以保证可见性的同时保证不进行指令重排序。
     *
    * */
    private static volatile LazySingleton instance = null;    //保证 instance 在所有线程中同步
    private LazySingleton() {
    }    //private 避免类在外部被实例化
    public static LazySingleton getInstance() {
        //提高性能 减少锁竞争
        if(instance == null){
            //保证同一时刻只有一个线程操作该单例
            synchronized(LazySingleton.class){
                //getInstance 方法前加同步
                //竞争到锁时不能保证instance还是null， 需要再次判断
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}