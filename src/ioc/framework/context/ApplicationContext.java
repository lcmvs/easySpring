package ioc.framework.context;

import ioc.framework.factory.AutowireCapableBeanFactory;
import ioc.framework.factory.BeanFactory;

/**
 * @description:
 * @author: lcm
 * @create: 2019-04-17 10:01
 **/
public interface ApplicationContext extends BeanFactory {

    AutowireCapableBeanFactory getAutowireCapableBeanFactory();

}
