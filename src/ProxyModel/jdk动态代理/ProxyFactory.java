package ProxyModel.jdk动态代理;

import ProxyModel.IUserDao;
import ProxyModel.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
       return Proxy.newProxyInstance(target.getClass().getClassLoader(),
               target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("事务开始...");
                        Object invoke = method.invoke(target, args);
                        System.out.println("事务结束...");
                        return invoke;
                    }
                }
       );
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        ProxyFactory proxyFactory = new ProxyFactory(userDao);
        IUserDao proxyInstance = (IUserDao)proxyFactory.getProxyInstance();
        proxyInstance.save();
    }
}
