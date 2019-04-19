package ioc.framework.factory;

import ioc.annotation.Autowired;
import ioc.beans.BeanDefinition;
import ioc.beans.PropertyValue;
import ioc.beans.PropertyValues;
import ioc.framework.IO.AnnotationReader;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: lcm
 * @create: 2019-04-17 10:05
 **/

public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String,BeanDefinition> beanDefinitionMap=new ConcurrentHashMap();

    private List<String> beanDefinitionNames=new ArrayList<>();

    @Override
    public Object getBean(String name) throws IllegalAccessException, InstantiationException {
        BeanDefinition beanDefinition=beanDefinitionMap.get(name);
        if (beanDefinition==null) throw new IllegalArgumentException("No bean named " + name + " is defined");
        Object bean=beanDefinition.getBean();
        if(bean==null) bean=doCreateBean(beanDefinition);
        applyPropertyValues(bean,beanDefinition);
        return bean;
    }

    protected void applyPropertyValues(Object bean,BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException {
        PropertyValues propertyValues=new PropertyValues();
        beanDefinition.setPropertyValues(propertyValues);
        Field[] fields = bean.getClass().getDeclaredFields();
        for(Field field:fields){
            Autowired autowired = field.getAnnotation(Autowired.class);
            if (autowired!=null){
                String value = autowired.value();
                Object obj;
                if(value.equals("")){
                    obj = getBean(field.getType().getSimpleName());
                }else{
                    obj = getBean(autowired.value());
                }
                propertyValues.addPropertyValue(new PropertyValue(autowired.value(),obj));
                field.setAccessible(true);
                field.set(bean,obj);
            }
        }
    }

    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException;

    public void doRegister(String packagePath) throws ClassNotFoundException {
        AnnotationReader.doRegister(packagePath,beanDefinitionMap);
    }

}
