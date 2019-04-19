package ioc.framework.factory;

import ioc.beans.BeanDefinition;
import ioc.framework.IO.AnnotationReader;

/**
 * @description:
 * @author: lcm
 * @create: 2019-04-18 09:21
 **/

public class AutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException {
        Object bean=createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException {
        return beanDefinition.getBeanClass().newInstance();
    }


}
