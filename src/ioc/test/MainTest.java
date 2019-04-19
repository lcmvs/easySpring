package ioc.test;

import ioc.framework.context.AnnotationApplicationContext;
import ioc.framework.context.ApplicationContext;

/**
 * @description:
 * @author: lcm
 * @create: 2019-04-18 09:40
 **/

public class MainTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        ApplicationContext applicationContext=new AnnotationApplicationContext("ioc");
        Hello hello = (Hello) applicationContext.getBean("Hello");
        hello.say();
//        Dog dog=(Dog)applicationContext.getBean("Dog");
//        dog.eat();
    }

}
