package ioc.test.iop.ProxyDemo.CglibProxy;

import ioc.test.iop.ProxyDemo.IService;
import ioc.test.iop.ProxyDemo.RealService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:cglib动态代理demo
 * @author: lcm
 * @create: 2019-04-23 11:10
 **/

public class CglibDynamicProxyDemo implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置");
        Object result= methodProxy.invokeSuper(o,objects);
        System.out.println("后置");
        return result;
    }

    public static <T> T getProxy(Class<T> clazz){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new CglibDynamicProxyDemo());
        return (T)enhancer.create();
    }

    public static void main(String[] args){
        IService proxy=getProxy(RealService.class);
        proxy.say();
    }


}
