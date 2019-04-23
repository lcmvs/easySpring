package ioc.test.iop.ProxyDemo.StaticProxy;

import ioc.test.iop.ProxyDemo.IService;
import ioc.test.iop.ProxyDemo.RealService;

/**
 * @description: 代理类
 * @author: lcm
 * @create: 2019-04-23 09:57
 **/

public class ServiceProxy implements IService {

    private RealService realService;

    public ServiceProxy(RealService realService) {
        this.realService = realService;
    }

    @Override
    public void say() {
        System.out.println("前置。。。");
        realService.say();
        System.out.println("后置。。。");
    }

    public static void main(String[] args){
        ServiceProxy proxy=new ServiceProxy(new RealService());
        proxy.say();
    }

}
