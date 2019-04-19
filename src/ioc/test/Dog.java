package ioc.test;

import ioc.annotation.Autowired;
import ioc.annotation.Component;

/**
 * @description:
 * @author: lcm
 * @create: 2019-04-18 16:57
 **/
@Component
public class Dog {

    @Autowired
    Hello hello;

    public void eat(){
        System.out.println("吃骨头");
        hello.say();
    }
}
