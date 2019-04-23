package ioc.test.iop.ProxyDemo;

/**
 * @description: 被代理类
 * @author: lcm
 * @create: 2019-04-23 09:55
 **/

public class RealService implements IService {

    @Override
    public void say() {
        System.out.println("静态代理内容");
    }

}
