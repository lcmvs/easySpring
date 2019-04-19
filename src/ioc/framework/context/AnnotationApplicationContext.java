package ioc.framework.context;

import ioc.beans.BeanDefinition;
import ioc.framework.IO.AnnotationReader;
import ioc.framework.context.ApplicationContext;
import ioc.framework.factory.AbstractBeanFactory;
import ioc.framework.factory.AutowireCapableBeanFactory;
import ioc.framework.factory.BeanFactory;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: lcm
 * @create: 2019-04-16 11:47
 **/

public class AnnotationApplicationContext extends  AbstarctApplicationContext {


    private String packagePath;

    public AnnotationApplicationContext(String packagePath) throws ClassNotFoundException {
        this(packagePath,new AutowireCapableBeanFactory());
    }

    public AnnotationApplicationContext(String packagePath, AutowireCapableBeanFactory beanFactory) throws ClassNotFoundException {
        super(beanFactory);
        this.packagePath=packagePath;
        refresh();
    }

    @Override
    public void refresh() throws ClassNotFoundException {
        beanFactory.doRegister(packagePath);
    }

}
