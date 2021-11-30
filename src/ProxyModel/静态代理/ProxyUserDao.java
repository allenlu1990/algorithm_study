package ProxyModel.静态代理;

import ProxyModel.IUserDao;

public class ProxyUserDao implements IUserDao {
    private IUserDao userDao;

    public ProxyUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("开始事务...");
        userDao.save();//执行目标对象的方法
        System.out.println("提交事务...");
    }
}
