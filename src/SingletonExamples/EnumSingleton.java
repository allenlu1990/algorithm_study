package SingletonExamples;

/**
 * 枚举单例其实就是静态内部类的实现方式（饿汉模式）
 * 枚举类的实例会在类加载的时候线程安全的进行初始实例化(所以也是饿汉模式)
 *
 * 反射中限制了Enum的类进行反射，所以不能被反射破坏。
 *
 *通过反编译后的代码
     public final class DataSourceEnum extends Enum<DataSourceEnum> {
     public static final DataSourceEnum DATASOURCE;
     public static DataSourceEnum[] values();
     public static DataSourceEnum valueOf(String s);
     static {};
     }
 *
 * **/

public enum  EnumSingleton {
    INSTANCE;
    public EnumSingleton getInstance(){
        return INSTANCE;
    }
}