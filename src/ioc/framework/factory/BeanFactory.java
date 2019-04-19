package ioc.framework.factory;


/**
 * @description:
 * @author: lcm
 * @create: 2019-04-12 11:06
 **/
public interface BeanFactory {

    Object getBean(String name) throws IllegalAccessException, InstantiationException;


}
