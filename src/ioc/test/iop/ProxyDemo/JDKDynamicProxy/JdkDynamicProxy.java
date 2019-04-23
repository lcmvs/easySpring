package ioc.test.iop.ProxyDemo.JDKDynamicProxy;

import ioc.test.iop.ProxyDemo.IService;
import ioc.test.iop.ProxyDemo.RealService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: jdk动态代理demo,可以共用一套代理逻辑
 * @author: lcm
 * @create: 2019-04-23 09:29
 **/

public class JdkDynamicProxy implements InvocationHandler {

    private Object realService;

    public JdkDynamicProxy(Object realService) {
        this.realService = realService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("entering " + method.getName());
        Object result = method.invoke(realService, args);
        System.out.println("leaving " + method.getName());
        return result;
    }

    public static void main(String[] args){

        IService proxy= (IService)Proxy.newProxyInstance(IService.class.getClassLoader(),
                new Class<?>[]{IService.class} ,
                new JdkDynamicProxy(new RealService()));

        proxy.say();

    }

}
