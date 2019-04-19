package ioc.framework.context;


import ioc.framework.factory.AbstractBeanFactory;
import ioc.framework.factory.AutowireCapableBeanFactory;

/**
 * @description:
 * @author: lcm
 * @create: 2019-04-17 10:04
 **/

public abstract class AbstarctApplicationContext implements ApplicationContext{

    protected AutowireCapableBeanFactory beanFactory;

    public AbstarctApplicationContext(AutowireCapableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getBean(String name) throws InstantiationException, IllegalAccessException {
        return beanFactory.getBean(name);
    }

    @Override
    public AutowireCapableBeanFactory getAutowireCapableBeanFactory(){
        return beanFactory;
    }

    public void refresh() throws ClassNotFoundException {

    }

}
